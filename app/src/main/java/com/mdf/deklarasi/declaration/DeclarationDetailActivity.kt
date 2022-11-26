package com.mdf.deklarasi.declaration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mdf.deklarasi.R
import com.mdf.deklarasi.database.DatabaseErrorListener
import com.mdf.deklarasi.database.DatabaseSuccessListener
import com.mdf.deklarasi.database.IDeclarationDatabase
import com.mdf.deklarasi.databinding.ActivityDeclarationDetailBinding
import com.mdf.deklarasi.model.Declaration
import com.mdf.deklarasi.utilities.AppConfiguration

class DeclarationDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeclarationDetailBinding
    private lateinit var database: IDeclarationDatabase

    private var declaration: Declaration? = Declaration()
    private lateinit var declarationId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_declaration_detail)
        database = AppConfiguration.getInstance().getDeclarationDatabase(this)
        supportActionBar?.hide()

        getArguments()
        setupLayout()
        getDeclarationDetail()
    }

    private fun getArguments() {
        declarationId = intent.getStringExtra("declarationId").toString()
    }

    private fun setupLayout() {
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

    private fun fetchDataToLayout() {
        binding.tvTitle.text = declaration?.title
        binding.tvDeclaration.text = declaration?.declaration
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
}