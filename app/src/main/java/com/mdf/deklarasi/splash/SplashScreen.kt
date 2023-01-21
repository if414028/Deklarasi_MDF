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
            resources.getString(R.string.dek_sma_mdf),
            true,
            "layout_dek_sma_mdf",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13, tv_14, tv_15, tv_16, tv_17, tv_18, tv_19"
        )

        val bahteraDelcaration = Declaration(
            "declaration_bahtera_mdf",
            "S.M.A (Bahtera)",
            resources.getString(R.string.dek_sma_bahtera),
            false,
            "layout_dek_sma_bahtera",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13, tv_14, tv_15, tv_16"
        )

        val kendalikanAtmosferTiapPagi = Declaration(
            "kendalikan_atmosfer_setiap_pagi",
            "Deklarasi Kendalikan Atmosfer Setiap Pagi",
            resources.getString(R.string.kendalikan_atmosfer_tiap_pagi),
            false,
            "layout_kendalikan_atmosfer_tiap_pagi",
            "tv_1, tv_2, tv_3, tv_4"
        )

        val tembokPerlindunganDeclaration = Declaration(
            "declaration_tembok_perlindungan",
            "Deklarasi 35 Tembok Perlindungan",
            resources.getString(R.string.dek_tembok_perlindungan),
            false,
            "layout_tembok_perlindungan",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13, tv_14, tv_15, tv_16, tv_17," +
                    " tv_18, tv_19, tv_20, tv_21, tv_22, tv_22, tv_23, tv_24, tv_25, tv_26, tv_27, tv_28, tv_29, tv_30, tv_31, tv_32," +
                    " tv_33, tv_34, tv_35, tv_36, tv_37, tv_38, tv_39, tv_40, tv_41, tv_42, tv_43, tv_44, tv_45, tv_46, tv_47, tv_48," +
                    " tv_49, tv_50, tv_51, tv_52, tv_53, tv_54, tv_55, tv_56, tv_57, tv_58, tv_59, tv_60, tv_61, tv_62, tv_63, tv_64, tv_65," +
                    " tv_66, tv_67, tv_68, tv_69, tv_70, tv_71, tv_72, tv_73,"
        )

        val perjanjianDarah = Declaration(
            "perjanjian_darah",
            "Deklarasi Perjanjian Darah",
            resources.getString(R.string.dek_perjanjian_darah),
            false,
            "layout_dek_perjanjian_darah",
            "tv_1, tv_2"
        )

        val perjanjianGaram = Declaration(
            "perjanjian_garam",
            "Deklarasi Perjanjian Garam",
            resources.getString(R.string.dek_perjanjian_garam),
            false,
            "layout_dek_perjanjian_garam",
            "tv_1, tv_2"
        )

        val perjanjianPelangi1 = Declaration(
            "perjanjian_pelangi_1",
            "Deklarasi Perjanjian Pelangi 1",
            resources.getString(R.string.dek_perjanjian_pelangi_1),
            false,
            "layout_dek_perjanjian_pelangi_1",
            "tv_1, tv_2"
        )

        val perjanjianPelangi2 = Declaration(
            "perjanjian_pelangi_2",
            "Deklarasi Perjanjian Pelangi 2",
            resources.getString(R.string.dek_perjanjian_pelangi_2),
            false,
            "layout_dek_perjanjian_pelangi_2",
            "tv_1, tv_2"
        )

        val deklarasiMazmur91 = Declaration(
            "mazmur_91",
            "Deklarasi Mazmur 91 (Perlindungan)",
            resources.getString(R.string.dek_mazmur_91),
            false,
            "layout_dek_mazmur_91",
            "tv_1, tv_2"
        )

        val perpindahanKekayaan = Declaration(
            "perpindahan_kekayaan",
            "Deklarasi Perpindahan Kekayaan",
            resources.getString(R.string.dek_perpindahan_kekayaan),
            false,
            "layout_dek_perpindahan_kekayaan",
            "tv_1, tv_2"
        )

        val deklarasi7Meterai = Declaration(
            "7_meterai",
            "Deklarasi 7 Perjanjian & Meterai",
            resources.getString(R.string.dek_perjanjian_dan_meterai),
            false,
            "layout_perjanjian_dan_meterai",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val yesaya60 = Declaration(
            "yesaya_60",
            "Deklarasi Yesaya 60 Pemulihan Dan Kelimpahan",
            resources.getString(R.string.dek_yesaya_60),
            false,
            "layout_dek_yesaya_60",
            "tv_1, tv_2"
        )

        val perjanjianMatahari = Declaration(
            "perjanjian_matahari",
            "Deklarasi Perjanjian Matahari",
            "perjanjian_matahari.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val perjanjianBintang = Declaration(
            "perjanjian_bintang",
            "Deklarasi Perjanjian Bintang",
            "perjanjian_bintang.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val everlastingCovenant = Declaration(
            "everlasting_covenant",
            "Everlasting Covenant (Kasih Setia Tuhan) - 2022",
            "everlasting_covenant.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val membangunTembokIlahi = Declaration(
            "membangun_tembok_ilahi",
            "Deklarasi Membangun Tembok Ilahi",
            "membangun_tembok_ilahi.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val mematahkanKutuk = Declaration(
            "mematahkan_kutuk",
            "Deklarasi Mematahkan Kutuk",
            "mematahkan_kutuk.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val perlindunganKesehatan = Declaration(
            "perlindungan_kesehatan",
            "Deklarasi Perlindungan Kesehatan",
            "perlindungan_kesehatan.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val perjanjianPersepuluhan = Declaration(
            "perjanjian_persepuluhan",
            "Deklarasi Perjanjian Persepuluhan",
            "perjanjian_persepuluhan.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val pelayananMalaikat = Declaration(
            "pelayanan_malaikat",
            "Deklarasi Pelayanan Malaikat",
            "pelayanan_malaikat.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val pengakuanPanggilanImam = Declaration(
            "panggilan_imam",
            "Deklarasi Pengakuan Panggilan Imam",
            "pengakuan_panggilan_imam.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val pengakuanPanggilanMempelai = Declaration(
            "panggilan_mempelai",
            "Deklarasi Pengakuan Panggilan Mempelai",
            "pengakuan_panggilan_mempelai.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val pengakuanPanggilanPekerja = Declaration(
            "panggilan_pekerja",
            "Deklarasi Pengakuan Panggilan Pekerja",
            "pengakuan_panggilan_pekerja.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val pengakuanPanggilanPilar = Declaration(
            "panggilan_pilar",
            "Deklarasi Pengakuan Panggilan Pilar",
            "pengakuan_panggilan_pilar.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val pengakuanPanggilanRaja = Declaration(
            "panggilan_raja",
            "Deklarasi Pengakuan Panggilan Raja",
            "pengakuan_panggilan_raja.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val pengakuanPanggilanTentara = Declaration(
            "panggilan_tentara",
            "Deklarasi Pengakuan Panggilan Tentara",
            "pengakuan_panggilan_tentara.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val kutukBulanApril = Declaration(
            "kutuk_bulan_april",
            "Deklarasi Mematahkan Kutuk Bulan April",
            "kutuk_bulan_april.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val kutukBulanAgustus = Declaration(
            "kutuk_bulan_agustus",
            "Deklarasi Mematahkan Kutuk Bulan Agustus",
            "kutuk_bulan_agustus.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val perjanjianAbraham = Declaration(
            "perjanjian_abraham",
            "Deklarasi Perjanjian Abraham",
            "perjanjian_abraham.pdf",
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
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