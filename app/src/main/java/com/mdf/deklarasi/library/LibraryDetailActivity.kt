package com.mdf.deklarasi.library

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.TypedValue
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.mdf.deklarasi.R
import com.mdf.deklarasi.databinding.ActivityLibraryDetailBinding
import com.mdf.deklarasi.model.Library
import com.mdf.deklarasi.utilities.UIHelper

class LibraryDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLibraryDetailBinding

    private var library: Library? = Library()
    private var isNightMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_library_detail)
        supportActionBar?.hide()

        getArgument()
        checkAppliedTheme()
        setupLayout()
    }

    private fun getArgument() {
        library = intent.getParcelableExtra("library") as? Library
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
        setupImage()
        binding.tvTitle.isSelected = true
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
        binding.tvTitle.text = library?.title

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.tvContent.text =
                Html.fromHtml(
                    library?.content,
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
                    library?.content, Html.fromHtml(
                        library?.content,
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
        var fontSize = binding.tvContent.textSize
        fontSize = fontSize.plus(4f)
        binding.tvContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize!!)
    }

    private fun decreaseTextSize() {
        var fontSize = binding.tvContent.textSize
        fontSize = fontSize.minus(4f)
        binding.tvContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize!!)
    }

    private fun setupImage() {
        if (library?.image != null) {
            val imageFile = resources.getIdentifier(library?.image, "drawable", packageName)
            binding.ivContent.setImageResource(imageFile)
            binding.ivContent.visibility = View.VISIBLE
        } else {
            binding.ivContent.visibility = View.GONE
        }
    }
}