package com.mdf.deklarasi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.mdf.deklarasi.converter.VerseTypeConverter

@Entity
data class SpiritualWarfareVerse(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "category")
    var category: String,

    @ColumnInfo(name = "verses")
    var verses: List<Verse>
) {
    constructor() : this("", "", listOf())
}
