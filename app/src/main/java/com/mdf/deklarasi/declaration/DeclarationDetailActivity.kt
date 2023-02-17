package com.mdf.deklarasi.declaration

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.mdf.deklarasi.R
import com.mdf.deklarasi.database.DatabaseErrorListener
import com.mdf.deklarasi.database.DatabaseSuccessListener
import com.mdf.deklarasi.database.IDeclarationDatabase
import com.mdf.deklarasi.databinding.ActivityDeclarationDetailBinding
import com.mdf.deklarasi.model.Declaration
import com.mdf.deklarasi.utilities.AppConfiguration
import com.mdf.deklarasi.utilities.UIHelper


class DeclarationDetailActivity : AppCompatActivity(), View.OnTouchListener {

    private lateinit var binding: ActivityDeclarationDetailBinding
    private lateinit var database: IDeclarationDatabase

    private var declaration: Declaration? = Declaration()
    private lateinit var declarationId: String
    private var isNightMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_declaration_detail)
        database = AppConfiguration.getInstance().getDeclarationDatabase(this)
        supportActionBar?.hide()

        getArguments()
        checkAppliedTheme()
        setupLayout()
        getDeclarationDetail()
    }

    private fun getArguments() {
        declarationId = intent.getStringExtra("declarationId").toString()
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
        binding.tvTitle.isSelected = true
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
        binding.icFav.setOnClickListener {
            database.setFavDeclaration(
                if (declaration?.fav == true) 0 else 1,
                declarationId,
                getSetFavDeclarationSuccessListener(),
                getErrorListener()
            )
        }
        binding.icTextCopy.setOnClickListener {
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                ClipData.newPlainText(
                    declaration?.title, Html.fromHtml(
                        declaration?.declaration,
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

    private fun fetchDataToLayout() {
        binding.tvTitle.text = declaration?.title
        if (declaration?.fav == true)
            binding.icFav.setImageDrawable(resources.getDrawable(R.drawable.ic_fav_selected))
        else binding.icFav.setImageDrawable(resources.getDrawable(R.drawable.ic_fav))

        binding.icTextSetting.setOnClickListener {
            UIHelper.getInstance().displayTextSizeChanger(this, {
                decreaseTextSize()
            }, {
                increaseTextSize()
            }, true)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.tvDeclaration.text =
                Html.fromHtml(
                    declaration?.declaration,
                    Html.FROM_HTML_MODE_LEGACY
                )
        }
    }

    private fun increaseTextSize() {
        var fontSize = binding.tvDeclaration.textSize
        fontSize = fontSize.plus(4f)
        binding.tvDeclaration.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize!!)
    }

    private fun decreaseTextSize() {
        var fontSize = binding.tvDeclaration.textSize
        fontSize = fontSize.minus(4f)
        binding.tvDeclaration.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize!!)
    }

    private fun getDeclarationDetail() {
        database.getDetailDeclaration(
            declarationId,
            getDeclarationDetailSuccessListener(),
            getErrorListener()
        )
    }

    private fun getDeclarationDetailSuccessListener(): DatabaseSuccessListener<Declaration> {
        return object : DatabaseSuccessListener<Declaration>() {
            override fun onSuccessResponse(results: Declaration?) {
                declaration = results
                fetchDataToLayout()
            }
        }

    }

    private fun getErrorListener(): DatabaseErrorListener {
        return object : DatabaseErrorListener() {
            override fun onErrorResponseListener() {

            }
        }
    }

    private fun getSetFavDeclarationSuccessListener(): DatabaseSuccessListener<Boolean> {
        return object : DatabaseSuccessListener<Boolean>() {
            override fun onSuccessResponse(results: Boolean?) {
                if (results != null) {
                    declaration?.fav = results
                    if (results == true)
                        binding.icFav.setImageDrawable(resources.getDrawable(R.drawable.ic_fav_selected))
                    else binding.icFav.setImageDrawable(resources.getDrawable(R.drawable.ic_fav))
                }
            }
        }
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        return false
    }
}