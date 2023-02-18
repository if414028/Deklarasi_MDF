package com.mdf.deklarasi.spiritualwarfare

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.TypedValue
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.mdf.deklarasi.R
import com.mdf.deklarasi.databinding.ActivitySpiritualWarfareDetailBinding
import com.mdf.deklarasi.model.SpiritualWarfareVerse
import com.mdf.deklarasi.utilities.UIHelper

class SpiritualWarfareDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpiritualWarfareDetailBinding

    private var spiritualWarfareVerse: SpiritualWarfareVerse? = SpiritualWarfareVerse()
    private var isNightMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_spiritual_warfare_detail)
        supportActionBar?.hide()

        getArgument()
        checkAppliedTheme()
        setupLayout()
    }

    private fun getArgument() {
        spiritualWarfareVerse =
            intent.getParcelableExtra("spiritualWarfare") as? SpiritualWarfareVerse
    }

    private fun checkAppliedTheme() {
        when (AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_NO -> {
                isNightMode = false
            }
            AppCompatDelegate.MODE_NIGHT_YES -> {
                isNightMode = true
            }
        }
    }

    private fun setupLayout() {
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
        binding.tvTitle.text = spiritualWarfareVerse?.category

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.tvVerse.text =
                Html.fromHtml(
                    spiritualWarfareVerse?.verses,
                    Html.FROM_HTML_MODE_LEGACY
                )
        }

        binding.icTextSetting.setOnClickListener {
            UIHelper.getInstance().displayTextSizeChanger(this, {
                decreaseTextSize()
            }, {
                increaseTextSize()
            }, true)
        }

        binding.icTextCopy.setOnClickListener {
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                ClipData.newPlainText(
                    spiritualWarfareVerse?.category, Html.fromHtml(
                        spiritualWarfareVerse?.verses,
                        Html.FROM_HTML_MODE_LEGACY
                    )
                )
            } else {
                TODO("VERSION.SDK_INT < N")
            }
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(applicationContext, "Deklarasi telah di salin", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun increaseTextSize() {
        var fontSize = binding.tvVerse.textSize
        fontSize = fontSize.plus(4f)
        binding.tvVerse.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize!!)
    }

    private fun decreaseTextSize() {
        var fontSize = binding.tvVerse.textSize
        fontSize = fontSize.minus(4f)
        binding.tvVerse.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize!!)
    }
}