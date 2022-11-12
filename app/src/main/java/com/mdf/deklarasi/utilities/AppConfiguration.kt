package com.mdf.deklarasi.utilities

import android.content.Context
import androidx.room.Room
import com.mdf.deklarasi.R
import com.mdf.deklarasi.database.DeclarationDatabase
import com.mdf.deklarasi.database.IDeclarationDatabase

class AppConfiguration {

    private lateinit var database: DeclarationDatabaseImplementation

    companion object {
        private val ourInstance = AppConfiguration()
        fun getInstance(): AppConfiguration {
            return ourInstance
        }
    }

    fun initDb(context: Context) {
        database = Room.databaseBuilder(
            context,
            DeclarationDatabaseImplementation::class.java,
            context.getString(R.string.app_name)
        ).build()
    }

    fun getDatabase(): DeclarationDatabaseImplementation {
        return database
    }

    fun getDeclarationDatabase(context: Context) : IDeclarationDatabase{
        return DeclarationDatabase(context)
    }
}