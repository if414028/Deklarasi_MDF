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
import com.mdf.deklarasi.model.*
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
            resources.getString(R.string.perjanjian_matahari),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val perjanjianBintang = Declaration(
            "perjanjian_bintang",
            "Deklarasi Perjanjian Bintang",
            resources.getString(R.string.perjanjian_bintang),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val everlastingCovenant = Declaration(
            "everlasting_covenant",
            "Everlasting Covenant (Kasih Setia Tuhan) - 2022",
            resources.getString(R.string.everlasting_covenant),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val membangunTembokIlahi = Declaration(
            "membangun_tembok_ilahi",
            "Deklarasi Membangun Tembok Ilahi",
            resources.getString(R.string.membangun_tembok_ilahi),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val mematahkanKutuk = Declaration(
            "mematahkan_kutuk",
            "Deklarasi Mematahkan Kutuk",
            resources.getString(R.string.mematahkan_kutuk),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val perlindunganKesehatan = Declaration(
            "perlindungan_kesehatan",
            "Deklarasi Perlindungan Kesehatan",
            resources.getString(R.string.perlindungan_kesehatan),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val perjanjianPersepuluhan = Declaration(
            "perjanjian_persepuluhan",
            "Deklarasi Perjanjian Persepuluhan",
            resources.getString(R.string.perjanjian_persepuluhan),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val pelayananMalaikat = Declaration(
            "pelayanan_malaikat",
            "Deklarasi Pelayanan Malaikat",
            resources.getString(R.string.pelayanan_malaikat),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val pengakuanPanggilanImam = Declaration(
            "panggilan_imam",
            "Deklarasi Pengakuan Panggilan Imam",
            resources.getString(R.string.panggilan_imam),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val pengakuanPanggilanMempelai = Declaration(
            "panggilan_mempelai",
            "Deklarasi Pengakuan Panggilan Mempelai",
            resources.getString(R.string.panggilan_mempelai),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val pengakuanPanggilanPekerja = Declaration(
            "panggilan_pekerja",
            "Deklarasi Pengakuan Panggilan Pekerja",
            resources.getString(R.string.panggilan_pekerja),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val pengakuanPanggilanPilar = Declaration(
            "panggilan_pilar",
            "Deklarasi Pengakuan Panggilan Pilar",
            resources.getString(R.string.panggilan_pilar),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val pengakuanPanggilanRaja = Declaration(
            "panggilan_raja",
            "Deklarasi Pengakuan Panggilan Raja",
            resources.getString(R.string.panggilan_raja),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val pengakuanPanggilanTentara = Declaration(
            "panggilan_tentara",
            "Deklarasi Pengakuan Panggilan Tentara",
            resources.getString(R.string.panggilan_tentara),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val kutukBulanApril = Declaration(
            "kutuk_bulan_april",
            "Deklarasi Mematahkan Kutuk Bulan April",
            resources.getString(R.string.kutuk_bulan_april),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val kutukBulanAgustus = Declaration(
            "kutuk_bulan_agustus",
            "Deklarasi Mematahkan Kutuk Bulan Agustus",
            resources.getString(R.string.kutuk_bulan_agustus),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val perjanjianAbraham = Declaration(
            "perjanjian_abraham",
            "Deklarasi Perjanjian Abraham",
            resources.getString(R.string.perjanjian_abraham),
            false,
            "",
            "tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_9, tv_10, tv_11, tv_12, tv_13,"
        )

        val perjanjianBoas = Declaration(
            "perjanjian_boas",
            "Deklarasi Pernjanjian Boas",
            resources.getString(R.string.perjanjian_boas),
            false,
            "",
            ""
        )

        val pengakuanPersembahanPerpuluhan = Declaration(
            "pengakuan_persembahan_perpuluhan",
            "PENGAKUAN SEBELUM DAN SESUDAH MEMBAWA PERSEMBAHAN PERSEPULUHAN",
            resources.getString(R.string.pengakuan_persembahan_persepuluhan),
            false,
            "",
            ""
        )

        val pengakuanPersembahanRumahTuhan = Declaration(
            "pengakuan_persembahan_rumah_tuhan",
            "PENGAKUAN SEBELUM DAN SESUDAH MEMBAWA PERSEMBAHAN UNTUK RUMAH TUHAN",
            resources.getString(R.string.pengakuan_persembahan_rumah_tuhan),
            false,
            "",
            ""
        )

        val pengakuanBenuaEropa = Declaration(
            "pengakuan_benua_eropa",
            "DEKLARASI PENGAKUAN BENUA EROPA",
            resources.getString(R.string.pengakuan_benua_eropa),
            false,
            "",
            ""
        )

        val berkatSukuAsyer = Declaration(
            "berkat_suku_asyer",
            "BERKAT SUKU ASYER, RASUL THOMAS, GERBANG MANDAT DAN PERJANJIAN ANAK DOMBA",
            resources.getString(R.string.berkat_suku_asyer),
            false,
            "",
            ""
        )

        val berkatSukuBenyamin = Declaration(
            "berkat_suku_benyamin",
            "BERKAT SUKU BENYAMIN, RASUL TADEUS, GERBANG TIMUR, PERJANJIAN RUTH",
            resources.getString(R.string.berkat_suku_benyamin),
            false,
            "",
            ""
        )

        val berkatSukuYohanes = Declaration(
            "berkat_suku_dan_rasul_yohanes",
            "BERKAT SUKU DAN, RASUL YOHANES, GERBANG KUDA, PERJANJIAN DANIEL",
            resources.getString(R.string.berkat_suku_dan_rasul_yohanes),
            false,
            "",
            ""
        )

        val berkatSukuGad = Declaration(
            "berkat_suku_gad",
            "BERKAT SUKU GAD, RASUL MATIUS, GERBANG MATA AIR, PERJANJIAN DARAH",
            resources.getString(R.string.berkat_suku_gad),
            false,
            "",
            ""
        )

        val berkatSukuIshakar = Declaration(
            "berkat_suku_ishakar",
            "BERKAT SUKU ISAKHAR, RASUL PAULUS, GERBANG DOMBA, PERJANJIAN HAK KESULUNGAN, DAN PERJANJIAN PERSEPULUHAN",
            resources.getString(R.string.berkat_suku_ishakar),
            false,
            "",
            ""
        )

        val berkatSukuLewi = Declaration(
            "berkat_suku_lewi",
            "BERKAT SUKU LEWI, RASUL YAKOBUS, GERBANG RUMAH ELSYAIB, PERJANJIAN GARAM",
            resources.getString(R.string.berkat_suku_lewi),
            false,
            "",
            ""
        )

        val berkatSukuNaftali = Declaration(
            "berkat_suku_naftali",
            "BERKAT SUKU NAFTALI, RASUL SIMON, GERBANG ELYASIB, PERJANJIAN HAGAR",
            resources.getString(R.string.berkat_suku_naftali),
            false,
            "",
            ""
        )

        val berkatSukuRuben = Declaration(
            "berkat_suku_ruben",
            "BERKAT SUKU RUBEN, RASUL ANDREAS, GERBANG SAMPAH, PERJANJIAN ESTER",
            resources.getString(R.string.berkat_suku_ruben),
            false,
            "",
            ""
        )

        val berkatSukuSimeon = Declaration(
            "berkat_suku_simeon",
            "BERKAT SUKU SIMEON, RASUL BARTOLOMEUS, GERBANG LEBAK, PERJANJIAN ABRAHAM",
            resources.getString(R.string.berkat_suku_simeon),
            false,
            "",
            ""
        )

        val berkatSukuYehuda = Declaration(
            "berkat_suku_yehuda",
            "BERKAT SUKU YEHUDA, RASUL YAKOBUS ANAK ALFEUS, GERBANG MENARA PERAPIAN, PERJANJIAN BATHSHEBA",
            resources.getString(R.string.berkat_suku_yehuda),
            false,
            "",
            ""
        )

        val berkatSukuYusuh = Declaration(
            "berkat_suku_yusuf",
            "BERKAT SUKU YUSUF, RASUL PETRUS, PINTU GERBANG AIR DAN PERJANJIAN YOSUA",
            resources.getString(R.string.berkat_suku_yusuf),
            false,
            "",
            ""
        )

        val berkatSukuZebulon = Declaration(
            "berkat_suku_zebulon",
            "BERKAT SUKU ZEBULON, RASUL FILIPUS, GERBANG LAMA, PERJANJIAN PELANGI",
            resources.getString(R.string.berkat_suku_zebulon),
            false,
            "",
            ""
        )

        val deklarasiPembalikanKeadaan = Declaration(
            "deklarasi_pembalikan_keadaan",
            "Deklarasi Pembalikan Keadaan",
            resources.getString(R.string.deklarasi_pembalikan_keadaan),
            false,
            "",
            ""
        )

        val deklarasiCinta = Declaration(
            "deklarasi_cinta",
            "Deklarasi Cinta",
            resources.getString(R.string.deklarasi_cinta),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianDaniel = Declaration(
            "deklarasi_perjanjian_daniel",
            "Deklarasi Perjanjian Daniel",
            resources.getString(R.string.deklarasi_perjanjian_daniel),
            false,
            "",
            ""
        )

        val pengakuanDaratLautUdara = Declaration(
            "deklarasi_pengakuan_darat_laut_udara",
            "Deklarasi Pengakuan Darat, Laut dan Udara",
            resources.getString(R.string.deklarasi_pengakuan_darat_laut_udara),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianDaud = Declaration(
            "deklarasi_perjanjian_daud",
            "Deklarasi Perjanjian Daud",
            resources.getString(R.string.deklarasi_perjanjian_daud),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianDeborah = Declaration(
            "deklarasi_perjanjian_deborah",
            "Deklarasi Perjanjian Deborah",
            resources.getString(R.string.deklarasi_perjanjian_deborah),
            false,
            "",
            ""
        )

        val deklarasiMematahkanKutuhBulanDesember = Declaration(
            "deklarasi_mematahkan_kutuk_bulan_desember",
            "Deklarasi Mematahkan Kutuk Bulan Desember",
            resources.getString(R.string.deklarasi_mematahkan_kutuk_bulan_desember),
            false,
            "",
            ""
        )

        val deklarasiDnaIlahi = Declaration(
            "deklarasi_dna_ilahi",
            "Deklarasi DNA Ilahi",
            resources.getString(R.string.deklarasi_dna_ilahi),
            false,
            "",
            ""
        )

        val deklarasi12JaminanTuhan = Declaration(
            "deklarasi_12_jaminan_tuhan",
            "Deklarasi 12 Jaminan Tuhan",
            resources.getString(R.string.deklarasi_12_jaminan_tuhan),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianEliezer = Declaration(
            "deklarasi_perjanjian_eliezer",
            "Deklarasi Perjanjian Eliezer",
            resources.getString(R.string.deklarasi_perjanjian_eliezer),
            false,
            "",
            ""
        )

        val deklarasiBerkatPenjuruMataAngin = Declaration(
            "deklarasi_berkat_4_penjuru_mata_angin",
            "Deklarasi Berkat 4 Penjuru Mata Angin",
            resources.getString(R.string.deklarasi_berkat_4_penjuru_mata_angin),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianEster = Declaration(
            "deklarasi_perjanjian_ester",
            "Deklarasi Perjanjian Ester",
            resources.getString(R.string.deklarasi_perjanjian_ester),
            false,
            "",
            ""
        )

        val deklarasiMematahkanKutukBulanFebruari = Declaration(
            "deklarasi_mematahkan_kutuk_bulan_februari",
            "Deklarasi Mematahkan Kutuk Bulan Februari",
            resources.getString(R.string.deklarasi_mematahkan_kutuk_bulan_februari),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianBesi = Declaration(
            "deklarasi_perjanjian_gada_besi",
            "Deklarasi Perjanjian Gada Besi",
            resources.getString(R.string.deklarasi_perjanjian_gada_besi),
            false,
            "",
            ""
        )

        val deklarasiKebangkitanGenerasiMuda = Declaration(
            "deklarasi_kebangkitan_generasi_muda",
            "Deklarasi Kebangkitan Generasi Muda",
            resources.getString(R.string.deklarasi_kebangkitan_generasi_muda),
            false,
            "",
            ""
        )

        val deklarasiPembalikanKeadaan_ = Declaration(
            "deklarasi_pembalikan_keadaan_",
            "Deklarasi Pembalikan Keadaan",
            resources.getString(R.string.deklarasi_pembalikan_keadaan_),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianGideon = Declaration(
            "deklarasi_perjanjian_gideon",
            "Deklarasi Perjanjian Gideon",
            resources.getString(R.string.deklarasi_perjanjian_gideon),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianHakKesulungan = Declaration(
            "deklarasi_perjanjian_hak_kesulungan",
            "Deklarasi Perjanjian Hak Kesulungan",
            resources.getString(R.string.deklarasi_perjanjian_hak_kesulungan),
            false,
            "",
            ""
        )

        val deklarasiPengakuanImanHidupDalamRoh = Declaration(
            "deklarasi_pengakuan_iman_hidup_dalam_roh",
            "Deklarasi Pengakuan Iman Tentang Hidup Dalam Roh",
            resources.getString(R.string.deklarasi_pengakuan_iman_hidup_dalam_roh),
            false,
            "",
            ""
        )

        val deklarasiHidupDenganRoh = Declaration(
            "deklarasi_hidup_dengan_roh",
            "Deklarasi Hidup Dengan Roh",
            resources.getString(R.string.deklarasi_hidup_dengan_roh),
            false,
            "",
            ""
        )

        val deklarasiImamMahanaim = Declaration(
            "deklarasi_imam_mahanaim",
            "Deklarasi Imam (Mahanaim)",
            resources.getString(R.string.deklarasi_imam_mahanaim),
            false,
            "",
            ""
        )

        val deklarasiImamAoc = Declaration(
            "deklarasi_imam_aoc",
            "Deklarasi Imam (AoC)",
            resources.getString(R.string.deklarasi_imam_aoc),
            false,
            "",
            ""
        )

        val deklarasiIndonesia = Declaration(
            "deklarasi_indonesia",
            "Deklarasi Indonesia",
            resources.getString(R.string.deklarasi_indonesia),
            false,
            "",
            ""
        )

        val deklarasiIndonesiaBersinar = Declaration(
            "deklarasi_indonesia_bersinar",
            "Deklarasi Indonesia Bersinar",
            resources.getString(R.string.deklarasi_indonesia_bersinar),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianIshak = Declaration(
            "deklarasi_perjanjian_ishak",
            "Deklarasi Perjanjian Ishak",
            resources.getString(R.string.deklarasi_perjanjian_ishak),
            false,
            "",
            ""
        )

        val deklarasiJakarta = Declaration(
            "deklarasi_jakarta",
            "Deklarasi Jakarta",
            resources.getString(R.string.deklarasi_jakarta),
            false,
            "",
            ""
        )

        val deklarasiJaminanPengangkatan = Declaration(
            "deklarasi_jaminan_pengangkatan",
            "Deklarasi Jaminan Pengangkatan",
            resources.getString(R.string.deklarasi_jaminan_pengangkatan),
            false,
            "",
            ""
        )

        val deklarasiMematahkanKutukBulanJanuari = Declaration(
            "deklarasi_mematahkan_kutuk_bulan_januari",
            "Dekarasi Mematahkan Kutuk Bulan Januari",
            resources.getString(R.string.deklarasi_mematahkan_kutuk_bulan_januari),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianYefta = Declaration(
            "deklarasi_perjanjian_yefta",
            "Deklarasi Perjanjian Yefta",
            resources.getString(R.string.deklarasi_perjanjian_yefta),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianYoel = Declaration(
            "deklarasi_perjanjian_yoel",
            "Deklarasi Perjanjian Yoel",
            resources.getString(R.string.deklarasi_perjanjian_yoel),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianYosua = Declaration(
            "deklarasi_perjanjian_yosua",
            "Deklarasi Perjanjian Yosua",
            resources.getString(R.string.deklarasi_perjanjian_yosua),
            false,
            "",
            ""
        )

        val deklarasiMematahkanKutukBulanJuli = Declaration(
            "deklarasi_mematahkan_kutuk_bulan_juli",
            "Deklarasi Mematahkan Kutuk Bulan Juli",
            resources.getString(R.string.deklarasi_mematahkan_kutuk_bulan_juli),
            false,
            "",
            ""
        )

        val deklarasiMematahkanKutukBulanJuni = Declaration(
            "mematahkan_kutuk_bulan_juni",
            "Deklarasi Mematahkan Kutuk Bulan Juni",
            resources.getString(R.string.mematahkan_kutuk_bulan_juni),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianKaleb = Declaration(
            "deklarasi_perjanjian_kaleb",
            "Deklarasi Perjanjian Kalen",
            resources.getString(R.string.deklarasi_perjanjian_kaleb),
            false,
            "",
            ""
        )

        val deklarasiKarpetMerah = Declaration(
            "deklarasi_karpet_merah",
            "Deklarasi Karpet Merah (Yohanes Pembabtis)",
            resources.getString(R.string.deklarasi_karpet_merah),
            false,
            "",
            ""
        )

        val deklarasiPengakuanKasihKarunia = Declaration(
            "pengakuan_kasih_karunia",
            "Deklarasi Pengakuan Kasih Karunia",
            resources.getString(R.string.pengakuan_kasih_karunia),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianKayuAras = Declaration(
            "deklarasi_perjanjian_kayu_aras",
            "Deklarasi Perjanjian Kayu Aras",
            resources.getString(R.string.deklarasi_perjanjian_kayu_aras),
            false,
            "",
            ""
        )

        val deklarasiKeluarga = Declaration(
            "deklarasi_keluarga",
            "Deklarasi Keluarga",
            resources.getString(R.string.deklarasi_keluarga),
            false,
            "",
            ""
        )

        val deklarasiKemahDaud = Declaration(
            "deklarasi_kemah_daud",
            "Deklarasi Kemah Daud",
            resources.getString(R.string.deklarasi_kemah_daud),
            false,
            "",
            ""
        )

        val deklarasiKemerdekaanIndonesia = Declaration(
            "deklarasi_kemerdekaan_indonesia",
            "Deklarasi Kemerdekaan Indonesia",
            resources.getString(R.string.deklarasi_kemerdekaan_indonesia),
            false,
            "",
            ""
        )

        val deklarasiKesembuhan = Declaration(
            "deklarasi_kesembuhan",
            "Deklarasi Kesembuhan",
            resources.getString(R.string.deklarasi_kesembuhan),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianKeshed = Declaration(
            "deklarasi_perjanjian_keshed",
            "Deklarasi Perjanjian Keshed",
            resources.getString(R.string.deklarasi_perjanjian_keshed),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianKornelius = Declaration(
            "deklarasi_perjanjian_kornelius",
            "Deklarasi Perjanjian Kornelius",
            resources.getString(R.string.deklarasi_perjanjian_kornelius),
            false,
            "",
            ""
        )

        val deklarasiLawatan = Declaration(
            "deklarasi_lawatan",
            "Deklarasi Lawatan",
            resources.getString(R.string.deklarasi_lawatan),
            false,
            "",
            ""
        )

        val deklarasiLawatanTuaianTerbesar = Declaration(
            "deklarasi_lawatan_tuaian_terbesar",
            "Deklarasi Lawatan Tuaian Terbesar",
            resources.getString(R.string.deklarasi_lawatan_tuaian_terbesar),
            false,
            "",
            ""
        )

        val deklarasiLevelRajaRaja = Declaration(
            "deklarasi_level_raja_raja",
            "Deklarasi Level Raja - Raja",
            resources.getString(R.string.deklarasi_level_raja_raja),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianLewi = Declaration(
            "deklarasi_perjanjian_lewi",
            "Deklarasi Perjanjian Lewi",
            resources.getString(R.string.deklarasi_perjanjian_lewi),
            false,
            "",
            ""
        )

        val deklarasiMematahkanKutukBulanMaret = Declaration(
            "deklarasi_mematahkan_kutuk_bulan_maret",
            "Deklarasi Mematahkan Kutuk Bulan Maret",
            resources.getString(R.string.deklarasi_mematahkan_kutuk_bulan_maret),
            false,
            "",
            ""
        )

        val deklarasiMematahkanKutukBulanMei = Declaration(
            "deklarasi_mematahkan_kutuk_bulan_mei",
            "Deklarasi Mematahkan Kutuk Bulan Mei",
            resources.getString(R.string.deklarasi_mematahkan_kutuk_bulan_mei),
            false,
            "",
            ""
        )

        val deklarasiMelawanPenyesat = Declaration(
            "deklarasi_melawan_penyesat",
            "Deklarasi Melawan Penyesat",
            resources.getString(R.string.deklarasi_melawan_penyesat),
            false,
            "",
            ""
        )

        val deklarasiMematahkanKutuk = Declaration(
            "deklarasi_mematahkan_kutuk",
            "Deklarasi Mematahkan Kutuk",
            resources.getString(R.string.deklarasi_mematahkan_kutuk),
            false,
            "",
            ""
        )

        val deklarasiMematahkanKutukDanPembalikanKeadaan = Declaration(
            "deklarasi_mematahan_kutuk_dan_pembalikan_keadaan",
            "Deklarasi Mematahkan Kutuk dan Pembalikan Keadaan",
            resources.getString(R.string.deklarasi_mematahan_kutuk_dan_pembalikan_keadaan),
            false,
            "",
            ""
        )

        val deklarasiMempelaiDanGadaBesi = Declaration(
            "deklarasi_mempelai_dan_gada_besi",
            "Deklarasi Mempelai dan Gada Besi",
            resources.getString(R.string.deklarasi_mempelai_dan_gada_besi),
            false,
            "",
            ""
        )

        val deklarasiMenahanBencana = Declaration(
            "deklarasi_menahan_bencana",
            "Deklarasi Menahan Bencana",
            resources.getString(R.string.deklarasi_menahan_bencana),
            false,
            "",
            ""
        )

        val deklarasiMenerimaKuasaDanOtoritasTuhan = Declaration(
            "deklarsi_menerima_kuasa_dan_otoritas_tuhan",
            "Deklarasi Menerima Kuasa Dan Otoritas Tuhan",
            resources.getString(R.string.deklarsi_menerima_kuasa_dan_otoritas_tuhan),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianTalitAoc = Declaration(
            "deklarasi_perjanjian_talit_aoc_1",
            "Deklarasi Perjanjian Talit (AoC)",
            resources.getString(R.string.deklarasi_perjanjian_talit_aoc_1),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianTalitAoc2 = Declaration(
            "deklarasi_perjanjian_talit_aoc_2",
            "Deklarasi Perjanjian Talit (AoC) 2",
            resources.getString(R.string.deklarasi_perjanjian_talit_aoc_2),
            false,
            "",
            ""
        )

        val deklarasiYohanes15DanMazmur23Aoc = Declaration(
            "deklarasi_yohanes_15_dan_mazmur_23_aoc",
            "Deklarasi Yohanes 15 dan Mazmur 23 (AoC)",
            resources.getString(R.string.deklarasi_yohanes_15_dan_mazmur_23_aoc),
            false,
            "",
            ""
        )

        val deklarasi12JaminanAnugerahAoc = Declaration(
            "deklarasi_12_jaminan_anugerah_aoc",
            "Deklarasi 12 Jaminan Anugerah (AoC)",
            resources.getString(R.string.deklarasi_12_jaminan_anugerah_aoc),
            false,
            "",
            ""
        )

        val deklarasiTahun2023Sion = Declaration(
            "deklarasi_tahun_2023_sion",
            "Deklarasi Tahun 2023 (Sion)",
            resources.getString(R.string.deklarasi_tahun_2023_sion),
            false,
            "",
            ""
        )

        val deklarasiTahun2023Aoc = Declaration(
            "deklarasi_tahun_2023_aoc",
            "Deklarasi Tahun 2023 (AoC)",
            resources.getString(R.string.deklarasi_tahun_2023_aoc),
            false,
            "",
            ""
        )

        val deklarasiPenetapanSupranatural = Declaration(
            "deklarasi_penetapan_supranatural",
            "Deklarasi Penetapan Supranatural",
            resources.getString(R.string.deklarasi_penetapan_supranatural),
            false,
            "",
            ""
        )

        val deklarasiYesaya51Aoc = Declaration(
            "deklarasi_yesaya_51_aoc",
            "Deklarasi Yesaya 51 (AoC)",
            resources.getString(R.string.deklarasi_yesaya_51_aoc),
            false,
            "",
            ""
        )

        val deklarasiMazmur91Aoc = Declaration(
            "deklarasi_mazmur_91_aoc",
            "Deklarasi Mazmur 91 (AoC)",
            resources.getString(R.string.deklarasi_mazmur_91_aoc),
            false,
            "",
            ""
        )

        val deklarasiMazmur23Aoc = Declaration(
            "deklarasi_mazmur_23_aoc",
            "Deklarasi Mazmur 23 (AoC)",
            resources.getString(R.string.deklarasi_mazmur_23_aoc),
            false,
            "",
            ""
        )

        val deklarasiYohanes15Aoc = Declaration(
            "deklarasi_yohanes_15_aoc",
            "Deklarasi Yohanes 15 (AoC)",
            resources.getString(R.string.deklarasi_yohanes_15_aoc),
            false,
            "",
            ""
        )

        val deklarasiEverlastingCovenantAoc = Declaration(
            "deklarasi_everlasting_covenant_aoc",
            "Deklarasi Everlasting Covenant (AoC)",
            resources.getString(R.string.deklarasi_everlasting_covenant_aoc),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianPerdamaian1Aoc = Declaration(
            "deklaras_perjanjian_perdamaian_aoc_1",
            "Deklarasi Perjanjian Perdamaian (AoC) 1",
            resources.getString(R.string.deklaras_perjanjian_perdamaian_aoc_1),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianPerdamaian2Aoc = Declaration(
            "deklarasi_perjanjian_perdamaian_aoc_2",
            "Deklarasi Perjanjian Perdamaian (AoC) 2",
            resources.getString(R.string.deklarasi_perjanjian_perdamaian_aoc_2),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianPerdamaian3Aoc = Declaration(
            "deklarasi_perjanjian_perdamaian_aoc_3",
            "Deklaraso Perjanjian Perdamaian (AoC) 3",
            resources.getString(R.string.deklarasi_perjanjian_perdamaian_aoc_3),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianMatahariDanPeriasiAoc = Declaration(
            "deklarasi_perjanjian_matahari_dan_perisai_aoc",
            "Deklarasi Perjanjian Matahari dan Perisai (AoC)",
            resources.getString(R.string.deklarasi_perjanjian_matahari_dan_perisai_aoc),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianYusufAoc = Declaration(
            "deklarasi_perjanjian_yusuf_aoc",
            "Deklarasi Perjanjian Yusuf (AoC)",
            resources.getString(R.string.deklarasi_perjanjian_yusuf_aoc),
            false,
            "",
            ""
        )

        val deklarasiMazmur21Aoc = Declaration(
            "deklarasi_mazmur_21_aoc",
            "Deklarasi Mazmur 21 (AoC)",
            resources.getString(R.string.deklarasi_mazmur_21_aoc),
            false,
            "",
            ""
        )

        val deklarasiImamPendamaianAoc = Declaration(
            "deklarasi_imam_pendamaian_aoc",
            "Deklarasi Imam Pendamaian (AoC)",
            resources.getString(R.string.deklarasi_imam_pendamaian_aoc),
            false,
            "",
            ""
        )

        val deklarasiPerjanjianPelangi = Declaration(
            "deklarasi_perjanjian_pelangi",
            "Deklarasi Perjanjian Pelangi",
            resources.getString(R.string.deklarasi_perjanjian_pelangi),
            false,
            "",
            ""
        )

        val deklarasiPerjanjian1000SyikalPerak = Declaration(
            "deklarasi_perjanjian_1000_syikal_perak",
            "Deklarasi Perjanjian 1000 Syikal Perak",
            resources.getString(R.string.deklarasi_perjanjian_1000_syikal_perak),
            false,
            "",
            ""
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
        declarationList.add(perjanjianBoas)
        declarationList.add(perjanjianBoas)
        declarationList.add(perjanjianBoas)
        declarationList.add(pengakuanPersembahanPerpuluhan)
        declarationList.add(pengakuanPersembahanRumahTuhan)
        declarationList.add(pengakuanBenuaEropa)
        declarationList.add(berkatSukuAsyer)
        declarationList.add(berkatSukuBenyamin)
        declarationList.add(berkatSukuYohanes)
        declarationList.add(berkatSukuGad)
        declarationList.add(berkatSukuIshakar)
        declarationList.add(berkatSukuLewi)
        declarationList.add(berkatSukuNaftali)
        declarationList.add(berkatSukuRuben)
        declarationList.add(berkatSukuSimeon)
        declarationList.add(berkatSukuYehuda)
        declarationList.add(berkatSukuYusuh)
        declarationList.add(berkatSukuZebulon)
        declarationList.add(deklarasiPembalikanKeadaan)
        declarationList.add(deklarasiCinta)
        declarationList.add(deklarasiPerjanjianDaniel)
        declarationList.add(pengakuanDaratLautUdara)
        declarationList.add(deklarasiPerjanjianDaud)
        declarationList.add(deklarasiPerjanjianDeborah)
        declarationList.add(deklarasiMematahkanKutuhBulanDesember)
        declarationList.add(deklarasiDnaIlahi)
        declarationList.add(deklarasi12JaminanTuhan)
        declarationList.add(deklarasiPerjanjianEliezer)
        declarationList.add(deklarasiBerkatPenjuruMataAngin)
        declarationList.add(deklarasiPerjanjianEster)
        declarationList.add(deklarasiMematahkanKutukBulanFebruari)
        declarationList.add(deklarasiPerjanjianBesi)
        declarationList.add(deklarasiKebangkitanGenerasiMuda)
        declarationList.add(deklarasiPembalikanKeadaan_)
        declarationList.add(deklarasiPerjanjianHakKesulungan)
        declarationList.add(deklarasiPerjanjianGideon)
        declarationList.add(deklarasiPengakuanImanHidupDalamRoh)
        declarationList.add(deklarasiHidupDenganRoh)
        declarationList.add(deklarasiImamMahanaim)
        declarationList.add(deklarasiImamAoc)
        declarationList.add(deklarasiIndonesia)
        declarationList.add(deklarasiIndonesiaBersinar)
        declarationList.add(deklarasiPerjanjianIshak)
        declarationList.add(deklarasiJakarta)
        declarationList.add(deklarasiJaminanPengangkatan)
        declarationList.add(deklarasiMematahkanKutukBulanJanuari)
        declarationList.add(deklarasiPerjanjianYefta)
        declarationList.add(deklarasiPerjanjianYoel)
        declarationList.add(deklarasiPerjanjianYosua)
        declarationList.add(deklarasiMematahkanKutukBulanJuni)
        declarationList.add(deklarasiMematahkanKutukBulanJuli)
        declarationList.add(deklarasiPerjanjianKaleb)
        declarationList.add(deklarasiKarpetMerah)
        declarationList.add(deklarasiPengakuanKasihKarunia)
        declarationList.add(deklarasiPerjanjianKayuAras)
        declarationList.add(deklarasiKeluarga)
        declarationList.add(deklarasiKemahDaud)
        declarationList.add(deklarasiKesembuhan)
        declarationList.add(deklarasiPerjanjianKeshed)
        declarationList.add(deklarasiKemerdekaanIndonesia)
        declarationList.add(deklarasiPerjanjianKornelius)
        declarationList.add(deklarasiLawatan)
        declarationList.add(deklarasiLawatanTuaianTerbesar)
        declarationList.add(deklarasiLevelRajaRaja)
        declarationList.add(deklarasiPerjanjianLewi)
        declarationList.add(deklarasiMematahkanKutukBulanMaret)
        declarationList.add(deklarasiMematahkanKutukBulanMei)
        declarationList.add(deklarasiMelawanPenyesat)
        declarationList.add(deklarasiMematahkanKutuk)
        declarationList.add(deklarasiMematahkanKutukDanPembalikanKeadaan)
        declarationList.add(deklarasiMempelaiDanGadaBesi)
        declarationList.add(deklarasiMenahanBencana)
        declarationList.add(deklarasiMenerimaKuasaDanOtoritasTuhan)
        declarationList.add(deklarasiPerjanjianTalitAoc)
        declarationList.add(deklarasiPerjanjianTalitAoc2)
        declarationList.add(deklarasiYohanes15DanMazmur23Aoc)
        declarationList.add(deklarasi12JaminanAnugerahAoc)
        declarationList.add(deklarasiTahun2023Sion)
        declarationList.add(deklarasiTahun2023Aoc)
        declarationList.add(deklarasiPenetapanSupranatural)
        declarationList.add(deklarasiYesaya51Aoc)
        declarationList.add(deklarasiMazmur91Aoc)
        declarationList.add(deklarasiMazmur23Aoc)
        declarationList.add(deklarasiYohanes15Aoc)
        declarationList.add(deklarasiEverlastingCovenantAoc)
        declarationList.add(deklarasiPerjanjianPerdamaian1Aoc)
        declarationList.add(deklarasiPerjanjianPerdamaian2Aoc)
        declarationList.add(deklarasiPerjanjianPerdamaian3Aoc)
        declarationList.add(deklarasiPerjanjianMatahariDanPeriasiAoc)
        declarationList.add(deklarasiPerjanjianYusufAoc)
        declarationList.add(deklarasiMazmur21Aoc)
        declarationList.add(deklarasiImamPendamaianAoc)
        declarationList.add(deklarasiPerjanjianPelangi)
        declarationList.add(deklarasiPerjanjian1000SyikalPerak)

        database.insertDeclaration(declarationList, getDatabaseSuccessListener(), errorListener())
    }

    private fun insertSpiritualWarfareVerseData() {
        val mintaOtoritasKerajaanSorga = SpiritualWarfareVerse(
            "ayat_minta_otoritas_kerajaan_sorga",
            "Minta Otoritas Kerajaan Sorga",
            emptyList(),
            resources.getString(R.string.ayat_minta_otoritas_kerajaan_sorga)
        )

        val malaikatPerang = SpiritualWarfareSubCategory(
            "malaikat_perang",
            "Malaikat Perang",
            resources.getString(R.string.malaikat_perang)
        )

        val malaikatPenerobos = SpiritualWarfareSubCategory(
            "malaikat_penerobos",
            "Malaikat Penerobos",
            resources.getString(R.string.malaikat_penerobos)
        )

        val malaikatMujizat = SpiritualWarfareSubCategory(
            "malaikat_mujizat",
            "Malaikat Mujizat",
            resources.getString(R.string.malaikat_mujizat)
        )

        val malaikatPengawalBerkat = SpiritualWarfareSubCategory(
            "malaikat_berkat",
            "Malaikat Pengawal Berkat",
            resources.getString(R.string.malaikat_berkat)
        )

        val malaikatPenuaian = SpiritualWarfareSubCategory(
            "malaikat_penuaian_jiwa",
            "Malaikat Penuaian dan Lawatan Jiwa-Jiwa",
            resources.getString(R.string.malaikat_penuaian_jiwa)
        )

        val malaikatBenih = SpiritualWarfareSubCategory(
            "malaikat_benih",
            "Malaikat Pembawa Benih",
            resources.getString(R.string.malaikat_benih)
        )

        val malaikatKekudusan = SpiritualWarfareSubCategory(
            "malaikat_kekudusan",
            "Malaikat Kekudusan",
            resources.getString(R.string.malaikat_kekudusan)
        )

        val malaikatKeadilan = SpiritualWarfareSubCategory(
            "malaikat_keadilan",
            "Malaikat Keadilan",
            resources.getString(R.string.malaikat_keadilan)
        )

        val malaikatPenyembahan = SpiritualWarfareSubCategory(
            "malaikat_pujian",
            "Malaikat Penyembahan",
            resources.getString(R.string.malaikat_pujian)
        )

        val malaikatKarakter = SpiritualWarfareSubCategory(
            "malaikat_karakter",
            "Malaikat Karakter dan Kabod",
            resources.getString(R.string.malaikat_karakter)
        )

        val malaikatPerjanjian = SpiritualWarfareSubCategory(
            "malaikat_perjanjian",
            "Malaikat Perjanjian",
            resources.getString(R.string.malaikat_perjanjian)
        )

        val malaikatPengangkatan = SpiritualWarfareSubCategory(
            "malaikat_pengangkatan",
            "Malaikat Pengangkatan",
            resources.getString(R.string.malaikat_pengangkatan)
        )
        val mintaLayananMalaikatSubCategory = arrayListOf<SpiritualWarfareSubCategory>()
        mintaLayananMalaikatSubCategory.add(malaikatPerang)
        mintaLayananMalaikatSubCategory.add(malaikatPenerobos)
        mintaLayananMalaikatSubCategory.add(malaikatMujizat)
        mintaLayananMalaikatSubCategory.add(malaikatPengawalBerkat)
        mintaLayananMalaikatSubCategory.add(malaikatPenuaian)
        mintaLayananMalaikatSubCategory.add(malaikatBenih)
        mintaLayananMalaikatSubCategory.add(malaikatKekudusan)
        mintaLayananMalaikatSubCategory.add(malaikatKeadilan)
        mintaLayananMalaikatSubCategory.add(malaikatPenyembahan)
        mintaLayananMalaikatSubCategory.add(malaikatKarakter)
        mintaLayananMalaikatSubCategory.add(malaikatPerjanjian)
        mintaLayananMalaikatSubCategory.add(malaikatPengangkatan)

        val mintaLayananMalaikat = SpiritualWarfareVerse(
            "ayat_minta_layanan_malaikat",
            "Minta Layanan Malaikat",
            mintaLayananMalaikatSubCategory,
            ""
        )

        val mintaKekuatanDariTuhan = SpiritualWarfareVerse(
            "ayat_minta_kekuatan_dari_tuhan",
            "Minta Kekuatan Dari Tuhan",
            emptyList(),
            resources.getString(R.string.ayat_minta_kekuatan_dari_tuhan)
        )

        val mintaPerlindunganDariTuhan = SpiritualWarfareVerse(
            "ayat_minta_perlindungan_dari_tuhan",
            "Minta Perlindungan Dari Tuhan",
            emptyList(),
            resources.getString(R.string.ayat_minta_perlindungan_dari_tuhan)
        )

        val ketetapanTuhan = SpiritualWarfareVerse(
            "ayat_ketetapan_tuhan",
            "Ketetapan Tuhan",
            emptyList(),
            resources.getString(R.string.ayat_ketetapan_tuhan)
        )

        val tarikBerkat = SpiritualWarfareVerse(
            "ayat_tarik_berkat",
            "Tarik Berkat",
            emptyList(),
            resources.getString(R.string.ayat_tarik_berkat)
        )

        val melawanMalaikatJatuh = SpiritualWarfareVerse(
            "ayat_melawan_malaikat_jatuh",
            "Melawan Malaikat Jatuh",
            emptyList(),
            resources.getString(R.string.ayat_melawan_malaikat_jatuh)
        )

        val melawanRohPenyesat = SpiritualWarfareVerse(
            "ayat_melawan_roh_penyesat",
            "Melawan Roh Penyesat",
            emptyList(),
            resources.getString(R.string.ayat_melawan_roh_penyesat)
        )

        val melawanRohMaut = SpiritualWarfareVerse(
            "ayat_melawan_roh_maut",
            "Melawan Roh Maut",
            emptyList(),
            resources.getString(R.string.ayat_melawan_roh_maut)
        )

        val melawanBerhala = SpiritualWarfareVerse(
            "ayat_melawan_berhala",
            "Melawan Berhala",
            emptyList(),
            resources.getString(R.string.ayat_melawan_berhala)
        )

        val melawanRohKedar = SpiritualWarfareVerse(
            "ayat_melawan_roh_kedar",
            "Melawan Roh Kedar",
            emptyList(),
            resources.getString(R.string.ayat_melawan_roh_kedar)
        )

        val melawanTenung = SpiritualWarfareVerse(
            "ayat_melawan_tenung",
            "Melawan Mentera/Tenung",
            emptyList(),
            resources.getString(R.string.ayat_melawan_tenung)
        )

        val melawanPembinasaKeji = SpiritualWarfareVerse(
            "ayat_melawan_pembinasa_keji",
            "Melawan Pembinasa Keji",
            emptyList(),
            resources.getString(R.string.ayat_melawan_pembinasa_keji)
        )

        val melawanRohMamon = SpiritualWarfareVerse(
            "ayat_melawan_roh_mamon",
            "Melawan Roh Mamon",
            emptyList(),
            resources.getString(R.string.ayat_melawan_roh_mamon)
        )

        val melawanRohUlar = SpiritualWarfareVerse(
            "ayat_melawan_roh_ular",
            "Melawan Roh Ular/Naga",
            emptyList(),
            resources.getString(R.string.melawan_roh_ular)
        )

        val spiritualWarfareVerses = arrayListOf<SpiritualWarfareVerse>()
        spiritualWarfareVerses.add(mintaOtoritasKerajaanSorga)
        spiritualWarfareVerses.add(mintaLayananMalaikat)
        spiritualWarfareVerses.add(mintaKekuatanDariTuhan)
        spiritualWarfareVerses.add(mintaPerlindunganDariTuhan)
        spiritualWarfareVerses.add(ketetapanTuhan)
        spiritualWarfareVerses.add(tarikBerkat)
        spiritualWarfareVerses.add(melawanMalaikatJatuh)
        spiritualWarfareVerses.add(melawanRohPenyesat)
        spiritualWarfareVerses.add(melawanRohMaut)
        spiritualWarfareVerses.add(melawanBerhala)
        spiritualWarfareVerses.add(melawanRohKedar)
        spiritualWarfareVerses.add(melawanTenung)
        spiritualWarfareVerses.add(melawanPembinasaKeji)
        spiritualWarfareVerses.add(melawanRohMamon)
        spiritualWarfareVerses.add(melawanRohUlar)
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

    private fun insertLibraryData() {
        val proseduralDoling = Library(
            "prosedural_doling",
            "Prosedural Doling",
            emptyList(),
            resources.getString(R.string.prosedural_doling),
            ""
        )

        val namaNamaTuhan = Library(
            "nama_nama_tuhan",
            "Nama Nama Tuhan",
            emptyList(),
            resources.getString(R.string.nama_nama_tuhan),
            ""
        )

        val perjanjianDaniel = SubLibrary(
            "perjanjian_daniel",
            "Perjanjian Daniel",
            resources.getString(R.string.perjanjian_daniel),
            "daniel"
        )

        val perjanjianGaram = SubLibrary(
            "perjanjian_garam",
            "Perjanjian Garam",
            resources.getString(R.string.perjanjian_garam),
            "garam"
        )

        val perjanjianPersepuluhan = SubLibrary(
            "perjanjian_perpuluhan",
            "Perjanjian Persepuluhan",
            resources.getString(R.string.perjanjian_perpuluhan),
            "perpuluhan"
        )

        val perjanjianDarah = SubLibrary(
            "perjanjian_darah",
            "Perjanjian Darah",
            resources.getString(R.string.perjanjian_darah),
            "darah"
        )

        val perjanjianAnakSulung = SubLibrary(
            "perjanjian_anak_sulung",
            "Perjanjian Anak Sulung",
            resources.getString(R.string.perjanjian_anak_sulung),
            "kesulungan"
        )

        val perjanjianPelangi = SubLibrary(
            "perjanjian_pelangi",
            "Perjanjian Pelangi",
            resources.getString(R.string.perjanjian_pelangi),
            "pelangi"
        )

        val perjanjiaAbraham = SubLibrary(
            "perjanjian_abraham",
            "Perjanjian Abaraham",
            resources.getString(R.string.pengajaran_perjanjian_abraham),
            "abraham"
        )

        val subLibraries = arrayListOf<SubLibrary>()
        subLibraries.add(perjanjianDaniel)
        subLibraries.add(perjanjianGaram)
        subLibraries.add(perjanjianPersepuluhan)
        subLibraries.add(perjanjianDarah)
        subLibraries.add(perjanjianAnakSulung)
        subLibraries.add(perjanjianPelangi)
        subLibraries.add(perjanjiaAbraham)

        val tujuhPerjanjian = Library(
            "tujuh_perjanjian",
            "7 Perjanjian (Legalitas dan Cawan)",
            subLibraries,
            resources.getString(R.string.nama_nama_tuhan),
            ""
        )

        val pengertianTumen = Library(
            "tumen",
            "Pengertian 7 Elemen (TUMEN)",
            emptyList(),
            resources.getString(R.string.pengertian_tumen),
            ""
        )

        val layananMalaikat = Library(
            "layanan_malaikat",
            "12 Layanan Malaikat Tuhan",
            emptyList(),
            resources.getString(R.string.layanan_malaikat),
            ""
        )

        val libraries = arrayListOf<Library>()
        libraries.add(proseduralDoling)
        libraries.add(namaNamaTuhan)
        libraries.add(tujuhPerjanjian)
        libraries.add(pengertianTumen)
        libraries.add(layananMalaikat)

        database.insertLibrary(libraries, getLibraryDatabaseListener(), errorListener())
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
                insertLibraryData()
            }
        }
    }

    private fun getLibraryDatabaseListener(): DatabaseSuccessListener<Void> {
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