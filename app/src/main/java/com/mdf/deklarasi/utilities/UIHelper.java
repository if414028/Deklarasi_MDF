package com.mdf.deklarasi.utilities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mdf.deklarasi.R;

public class UIHelper {
    private static final UIHelper ourInstance = new UIHelper();

    public static UIHelper getInstance() {
        return ourInstance;
    }

    private UIHelper() {
    }

    public static OneTimeClickListener getOneTimeClickListener() {
        return new OneTimeClickListener() {
            private long mLastClickedTime;

            @Override
            public void onClickedTime(View view, Runnable runnable, long thresholdTime) {
                if ((SystemClock.elapsedRealtime() - mLastClickedTime) < thresholdTime) {
                    return;
                }

                runnable.run();
                view.setEnabled(false);
                mLastClickedTime = SystemClock.elapsedRealtime();
            }
        };
    }

    private boolean isContextRunning(Context ctx) {
        if (ctx != null && ctx instanceof Activity) {
            Activity act = (Activity) ctx;
            return !act.isFinishing();
        } else {
            return false;
        }
    }

    public void showProgress(Context context, final View view, final View progressView, final boolean show) {

        if (isContextRunning(context) && view != null && progressView != null) {
            int shortAnimTime = context.getResources().getInteger(android.R.integer.config_shortAnimTime);

            view.setVisibility(show ? View.GONE : View.VISIBLE);
            view.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    view.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            progressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        }
    }

    public interface OneTimeClickListener {
        void onClickedTime(View view, Runnable runnable, long thresholdTime);
    }

    public void displayTextSizeChanger(Context context, @NonNull final Runnable decrease,
                                   @NonNull final Runnable increase,
                                   boolean isCancelable) {
        if (isContextRunning(context)) {
            final Dialog dialog = new BottomSheetDialog(context, R.style.MdfBottomAlertTheme);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_text_size);
            dialog.setCancelable(isCancelable);

            Button negativeButton = dialog.findViewById(R.id.btn_negative);
            assert negativeButton != null;
            negativeButton.setOnClickListener(view -> {
                decrease.run();
            });

            Button positiveButton = dialog.findViewById(R.id.btn_positive);
            if (positiveButton != null) {
                positiveButton.setOnClickListener(view -> {
                    increase.run();
                });
            }

            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing()) {
                    dialog.show();
                }
            } else {
                dialog.show();
            }
        }
    }
}
