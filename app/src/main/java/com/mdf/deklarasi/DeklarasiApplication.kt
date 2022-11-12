package com.mdf.deklarasi

import android.app.Application
import com.mdf.deklarasi.utilities.AppConfiguration
import com.mdf.deklarasi.utilities.DeclarationDatabaseImplementation
import com.mdf.deklarasi.utilities.UserConfiguration

class DeklarasiApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AppConfiguration.getInstance().initDb(applicationContext)
        UserConfiguration.getInstance().initSharedPreference(applicationContext)
    }


}