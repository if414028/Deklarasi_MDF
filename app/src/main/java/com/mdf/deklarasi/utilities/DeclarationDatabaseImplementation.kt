package com.mdf.deklarasi.utilities

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mdf.deklarasi.converter.BooleanTypeConverter
import com.mdf.deklarasi.converter.SubCategoryTypeConverter
import com.mdf.deklarasi.converter.SubLibraryTypeConverter
import com.mdf.deklarasi.dao.DeclarationDao
import com.mdf.deklarasi.dao.LibraryDao
import com.mdf.deklarasi.dao.ShofarSoundDao
import com.mdf.deklarasi.dao.SpiritualWarfareVerseDao
import com.mdf.deklarasi.model.Declaration
import com.mdf.deklarasi.model.Library
import com.mdf.deklarasi.model.ShofarSound
import com.mdf.deklarasi.model.SpiritualWarfareVerse

@Database(
    entities = [
        Declaration::class,
        SpiritualWarfareVerse::class,
        ShofarSound::class,
        Library::class], version = 1
)
@TypeConverters(BooleanTypeConverter::class, SubCategoryTypeConverter::class, SubLibraryTypeConverter::class)
abstract class DeclarationDatabaseImplementation : RoomDatabase() {

    abstract fun declarationDao(): DeclarationDao

    abstract fun spiritualWarfareVerseDao(): SpiritualWarfareVerseDao

    abstract fun shofarSoundDao(): ShofarSoundDao

    abstract fun libraryDao(): LibraryDao
}