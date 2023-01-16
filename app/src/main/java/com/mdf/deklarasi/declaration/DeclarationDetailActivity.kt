package com.mdf.deklarasi.declaration

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.github.barteksc.pdfviewer.util.FitPolicy
import com.mdf.deklarasi.R
import com.mdf.deklarasi.database.DatabaseErrorListener
import com.mdf.deklarasi.database.DatabaseSuccessListener
import com.mdf.deklarasi.database.IDeclarationDatabase
import com.mdf.deklarasi.databinding.ActivityDeclarationDetailBinding
import com.mdf.deklarasi.model.Declaration
import com.mdf.deklarasi.utilities.AppConfiguration
import kotlin.properties.Delegates


class DeclarationDetailActivity : AppCompatActivity(), View.OnTouchListener {

    private lateinit var binding: ActivityDeclarationDetailBinding
    private lateinit var database: IDeclarationDatabase

    private var declaration: Declaration? = Declaration()
    private lateinit var declarationId: String
    private var isNightMode = false

    private val move = 200f
    private var ratio= 1.0f
    private var bastDst = 0
    private var baseRatio = 0.0f

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
    }

    private fun showPdfFromAssets(pdfName: String?) {
        binding.pdvViewer.fromAsset(pdfName)
            .password(null)
            .defaultPage(0)
            .nightMode(isNightMode)
            .onPageError{
                page, _ ->
                Toast.makeText(this@DeclarationDetailActivity, "Error at page: $page", Toast.LENGTH_LONG).show()
            }
            .load()
    }

    private fun fetchDataToLayout() {
        binding.tvTitle.text = declaration?.title
        showPdfFromAssets(declaration?.declaration)

        if (declaration?.fav == true)
            binding.icFav.setImageDrawable(resources.getDrawable(R.drawable.ic_fav_selected))
        else binding.icFav.setImageDrawable(resources.getDrawable(R.drawable.ic_fav))
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