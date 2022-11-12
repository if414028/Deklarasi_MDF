package com.mdf.deklarasi.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mdf.deklarasi.R
import com.mdf.deklarasi.database.DatabaseErrorListener
import com.mdf.deklarasi.database.DatabaseSuccessListener
import com.mdf.deklarasi.database.IDeclarationDatabase
import com.mdf.deklarasi.databinding.ActivitySplashScreenBinding
import com.mdf.deklarasi.main.MainActivity
import com.mdf.deklarasi.model.Declaration
import com.mdf.deklarasi.utilities.AppConfiguration
import com.mdf.deklarasi.utilities.UserConfiguration

class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var database: IDeclarationDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)
        database =
            AppConfiguration.getInstance().getDeclarationDatabase(this)
        supportActionBar?.hide()

        if (UserConfiguration.getInstance().getCompleteFillData()) {
            openMainActivity()
        } else {
            initData()
        }
    }

    private fun initData() {
        val mdfDeclaration = Declaration(
            "declaration_sma_mdf",
            "S.M.A (MDF)",
            "Sample declaration",
            true
        )

        val bahteraDelcaration = Declaration(
            "declaration_bahtera_mdf",
            "S.M.A (Bahtera)",
            "Sample declaration",
            false
        )

        val declarationList = arrayListOf<Declaration>()
        declarationList.add(mdfDeclaration)
        declarationList.add(bahteraDelcaration)

        database.insertDeclaration(declarationList, getDatabaseSuccessListener(), errorListener())
    }

    private fun getDatabaseSuccessListener(): DatabaseSuccessListener<Void> {
        return object : DatabaseSuccessListener<Void>() {
            override fun onSuccessResponse(results: Void?) {
                UserConfiguration.getInstance().setCompleteFillData()
                openMainActivity()
            }
        }
    }

    private fun errorListener(): DatabaseErrorListener {
        return object : DatabaseErrorListener() {
            override fun onErrorResponseListener() {}
        }
    }

    private fun openMainActivity() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            },
            1000
        )
    }
}