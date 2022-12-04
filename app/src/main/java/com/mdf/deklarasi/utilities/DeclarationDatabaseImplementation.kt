package com.mdf.deklarasi.utilities

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mdf.deklarasi.converter.BooleanTypeConverter
import com.mdf.deklarasi.converter.VerseTypeConverter
import com.mdf.deklarasi.dao.DeclarationDao
import com.mdf.deklarasi.dao.SpiritualWarfareVerseDao
import com.mdf.deklarasi.model.Declaration
import com.mdf.deklarasi.model.SpiritualWarfareVerse

@Database(
    entities = [
        Declaration::class,
        SpiritualWarfareVerse::class], version = 1
)
@TypeConverters(BooleanTypeConverter::class, VerseTypeConverter::class)
abstract class DeclarationDatabaseImplementation : RoomDatabase() {

    abstract fun declarationDao(): DeclarationDao

    abstract fun spiritualWarfareVerseDao(): SpiritualWarfareVerseDao

}