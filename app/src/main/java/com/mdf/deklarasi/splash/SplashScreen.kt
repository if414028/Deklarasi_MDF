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
import com.mdf.deklarasi.model.ShofarSound
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

//        if (UserConfiguration.getInstance().getCompleteFillData()) {
//            openMainActivity()
//        } else {
//            initData()
//        }
        initData()
    }

    private fun initData() {
        insertDeclarationData()
    }

    private fun insertDeclarationData() {
        val mdfDeclaration = Declaration(
            "declaration_sma_mdf",
            "S.M.A (MDF)",
            "sma_mdf.pdf",
            true
        )

        val bahteraDelcaration = Declaration(
            "declaration_bahtera_mdf",
            "S.M.A (Bahtera)",
            "sma_bahtera.pdf",
            false
        )

        val kendalikanAtmosferTiapPagi = Declaration(
            "kendalikan_atmosfer_setiap_pagi",
            "Deklarasi Kendalikan Atmosfer Setiap Pagi",
            "deklarasi_kendalikan_atmosfer_setiap_pagi.pdf",
            false
        )

        val tembokPerlindunganDeclaration = Declaration(
            "declaration_tembok_perlindungan",
            "Deklarasi 35 Tembok Perlindungan",
            "tembok_perlindungan.pdf",
            false
        )

        val perjanjianDarah = Declaration(
            "perjanjian_darah",
            "Deklarasi Perjanjian Darah",
            "perjanjian_darah.pdf",
            false
        )

        val perjanjianGaram = Declaration(
            "perjanjian_garam",
            "Deklarasi Perjanjian Garam",
            "perjanjian_garam.pdf",
            false
        )

        val perjanjianPelangi1 = Declaration(
            "perjanjian_pelangi_1",
            "Deklarasi Perjanjian Pelangi 1",
            "perjanjian_pelangi_1",
            false
        )

        val perjanjianPelangi2 = Declaration(
            "perjanjian_pelangi_2",
            "Deklarasi Perjanjian Pelangi 2",
            "perjanjian_pelangi_2",
            false
        )

        val deklarasiMazmur91 = Declaration(
            "mazmur_91",
            "Deklarasi Mazmur 91 (Perlindungan)",
            "mazmur_91.pdf",
            false
        )

        val perpindahanKekayaan = Declaration(
            "perpindahan_kekayaan",
            "Deklarasi Perpindahan Kekayaan",
            "perpindahan_kekayaan.pdf",
            false
        )

        val deklarasi7Meterai = Declaration(
            "7_meterai",
            "Deklarasi 7 Perjanjian & Meterai",
            "perjanjian_7_perjanjian_dan_meterai.pdf",
            false
        )

        val yesaya60 = Declaration(
            "yesaya_60",
            "Deklarasi Yesaya 60 Pemulihan Dan Kelimpahan",
            "yesaya_60.pdf",
            false
        )

        val perjanjianMatahari = Declaration(
            "perjanjian_matahari",
            "Deklarasi Perjanjian Matahari",
            "perjanjian_matahari.pdf",
            false
        )

        val perjanjianBintang = Declaration(
            "perjanjian_bintang",
            "Deklarasi Perjanjian Bintang",
            "perjanjian_bintang.pdf",
            false
        )

        val everlastingCovenant = Declaration(
            "everlasting_covenant",
            "Everlasting Covenant (Kasih Setia Tuhan) - 2022",
            "everlasting_covenant.pdf",
            false
        )

        val membangunTembokIlahi = Declaration(
            "membangun_tembok_ilahi",
            "Deklarasi Membangun Tembok Ilahi",
            "membangun_tembok_ilahi.pdf",
            false
        )

        val mematahkanKutuk = Declaration(
            "mematahkan_kutuk",
            "Deklarasi Mematahkan Kutuk",
            "mematahkan_kutuk.pdf",
            false
        )

        val perlindunganKesehatan = Declaration(
            "perlindungan_kesehatan",
            "Deklarasi Perlindungan Kesehatan",
            "perlindungan_kesehatan.pdf",
            false
        )

        val perjanjianPersepuluhan = Declaration(
            "perjanjian_persepuluhan",
            "Deklarasi Perjanjian Persepuluhan",
            "perjanjian_persepuluhan.pdf",
            false
        )

        val pelayananMalaikat = Declaration(
            "pelayanan_malaikat",
            "Deklarasi Pelayanan Malaikat",
            "pelayanan_malaikat.pdf",
            false
        )

        val pengakuanPanggilanImam = Declaration(
            "panggilan_imam",
            "Deklarasi Pengakuan Panggilan Imam",
            "pengakuan_panggilan_imam.pdf",
            false
        )

        val pengakuanPanggilanMempelai = Declaration(
            "panggilan_mempelai",
            "Deklarasi Pengakuan Panggilan Mempelai",
            "pengakuan_panggilan_mempelai.pdf",
            false
        )

        val pengakuanPanggilanPekerja = Declaration(
            "panggilan_pekerja",
            "Deklarasi Pengakuan Panggilan Pekerja",
            "pengakuan_panggilan_pekerja.pdf",
            false
        )

        val pengakuanPanggilanPilar = Declaration(
            "panggilan_pilar",
            "Deklarasi Pengakuan Panggilan Pilar",
            "pengakuan_panggilan_pilar.pdf",
            false
        )

        val pengakuanPanggilanRaja = Declaration(
            "panggilan_raja",
            "Deklarasi Pengakuan Panggilan Raja",
            "pengakuan_panggilan_raja.pdf",
            false
        )

        val pengakuanPanggilanTentara = Declaration(
            "panggilan_tentara",
            "Deklarasi Pengakuan Panggilan Tentara",
            "pengakuan_panggilan_tentara.pdf",
            false
        )

        val kutukBulanApril = Declaration(
            "kutuk_bulan_april",
            "Deklarasi Mematahkan Kutuk Bulan April",
            "kutuk_bulan_april.pdf",
            false
        )

        val kutukBulanAgustus = Declaration(
            "kutuk_bulan_agustus",
            "Deklarasi Mematahkan Kutuk Bulan Agustus",
            "kutuk_bulan_agustus.pdf",
            false
        )

        val perjanjianAbraham = Declaration(
            "perjanjian_abraham",
            "Deklarasi Perjanjian Abraham",
            "perjanjian_abraham.pdf",
            false
        )


        val declarationList = arrayListOf<Declaration>()
        declarationList.add(mdfDeclaration)
        declarationList.add(bahteraDelcaration)
        declarationList.add(tembokPerlindunganDeclaration)
        declarationList.add(kendalikanAtmosferTiapPagi)
        declarationList.add(perjanjianDarah)
        declarationList.add(perjanjianGaram)
        declarationList.add(perjanjianPelangi1)
        declarationList.add(perjanjianPelangi2)
        declarationList.add(deklarasiMazmur91)
        declarationList.add(perpindahanKekayaan)
        declarationList.add(deklarasi7Meterai)
        declarationList.add(yesaya60)
        declarationList.add(perjanjianMatahari)
        declarationList.add(perjanjianBintang)
        declarationList.add(everlastingCovenant)
        declarationList.add(membangunTembokIlahi)
        declarationList.add(mematahkanKutuk)
        declarationList.add(perlindunganKesehatan)
        declarationList.add(perjanjianPersepuluhan)
        declarationList.add(pelayananMalaikat)
        declarationList.add(pengakuanPanggilanImam)
        declarationList.add(pengakuanPanggilanMempelai)
        declarationList.add(pengakuanPanggilanPekerja)
        declarationList.add(pengakuanPanggilanRaja)
        declarationList.add(pengakuanPanggilanPilar)
        declarationList.add(pengakuanPanggilanTentara)
        declarationList.add(kutukBulanApril)
        declarationList.add(kutukBulanAgustus)
        declarationList.add(perjanjianAbraham)

        database.insertDeclaration(declarationList, getDatabaseSuccessListener(), errorListener())
    }

    private fun insertSpiritualWarfareVerseData() {
        val yeremia10_11MILT = Verse(
            "YEREMIA 10:11 (MILT)",
            "Seperti inilah harus kamu katakan kepada mereka, 'ilah-ilah' yang" +
                    "tidak menjadikan langit dan bumi, akan lenyap dari bumi, dan dari kolong langit ini."
        )
        val petrus2_4MILT = Verse(
            "2 PETRUS 2:4 (MILT)",
            "Sebab, jika Allah tidak berbelaskasihan atas malaikat-malaikat yang telah berdosa," +
                    "sebaliknya, Dia malah menyerahkan ke dalam belenggu kegelapan dengan melemparkannya ke dalam tartarus untuk ditahan sampai pengakiman"
        )
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
        database.insertSpiritualWarfareVerse(
            spiritualWarfareVerses,
            getSpiritualWarfareVerseDatabaseSuccessListener(),
            errorListener()
        )
    }

    private fun insertShofarSoundData() {
        val shofar = ShofarSound("short", "Shofar 12x", "shofar", "shofarblower1")
        val shofarLong = ShofarSound("long", "Shofar Panjang", "shofarlong", "shofarblower2")

        val shofarSounds = arrayListOf<ShofarSound>()
        shofarSounds.add(shofar)
        shofarSounds.add(shofarLong)

        database.insertShofarSound(shofarSounds, getShofarSoundDatabaseListener(), errorListener())
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
                insertShofarSoundData()
            }
        }
    }

    private fun getShofarSoundDatabaseListener(): DatabaseSuccessListener<Void> {
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