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
import com.mdf.deklarasi.model.SpiritualWarfareVerse
import com.mdf.deklarasi.model.Verse
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
        insertDeclarationData()
    }

    private fun insertDeclarationData() {
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

        val tembokPerlindunganDeclaration = Declaration(
            "declaration_tembok_perlindungan",
            "Deklarasi 35 Tembok Perlindungan",
            "Sample declaration",
            false
        )

        val declarationList = arrayListOf<Declaration>()
        declarationList.add(mdfDeclaration)
        declarationList.add(bahteraDelcaration)
        declarationList.add(tembokPerlindunganDeclaration)

        database.insertDeclaration(declarationList, getDatabaseSuccessListener(), errorListener())
    }

    private fun insertSpiritualWarfareVerseData() {
        val yeremia10_11MILT = Verse("YEREMIA 10:11 (MILT)", "Seperti inilah harus kamu katakan kepada mereka, 'ilah-ilah' yang" +
                "tidak menjadikan langit dan bumi, akan lenyap dari bumi, dan dari kolong langit ini.")
        val petrus2_4MILT = Verse("2 PETRUS 2:4 (MILT)", "Sebab, jika Allah tidak berbelaskasihan atas malaikat-malaikat yang telah berdosa," +
                "sebaliknya, Dia malah menyerahkan ke dalam belenggu kegelapan dengan melemparkannya ke dalam tartarus untuk ditahan sampai pengakiman")
        val melawanMalaikatJatuhVerses = arrayListOf<Verse>()
        melawanMalaikatJatuhVerses.add(yeremia10_11MILT)
        melawanMalaikatJatuhVerses.add(petrus2_4MILT)
        val melawanMalaikatJatuh = SpiritualWarfareVerse(
            "1",
            "Melawan Malaikat Jatuh",
            melawanMalaikatJatuhVerses

        )

        val spiritualWarfareVerses = arrayListOf<SpiritualWarfareVerse>()
        spiritualWarfareVerses.add(melawanMalaikatJatuh)
        database.insertSpiritualWarfareVerse(spiritualWarfareVerses, getSpiritualWarfareVerseDatabaseSuccessListener(), errorListener())
    }

    private fun getDatabaseSuccessListener(): DatabaseSuccessListener<Void> {
        return object : DatabaseSuccessListener<Void>() {
            override fun onSuccessResponse(results: Void?) {
                insertSpiritualWarfareVerseData()
            }
        }
    }

    private fun getSpiritualWarfareVerseDatabaseSuccessListener(): DatabaseSuccessListener<Void> {
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