package com.mdf.deklarasi.utilities

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mdf.deklarasi.dao.DeclarationDao
import com.mdf.deklarasi.model.Declaration

@Database(entities = [Declaration::class], version = 1)
abstract class DeclarationDatabaseImplementation : RoomDatabase() {

    abstract fun declarationDao(): DeclarationDao

}