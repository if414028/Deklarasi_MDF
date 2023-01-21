package com.mdf.deklarasi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.mdf.deklarasi.converter.BooleanTypeConverter

@Entity
data class Declaration(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "declaration")
    var declaration: String,

    @ColumnInfo(name = "fav")
    @TypeConverters(BooleanTypeConverter::class)
    var fav: Boolean,

    @ColumnInfo(name= "layout")
    var layout: String,

    @ColumnInfo
    var layoutIds: String
) {
    constructor() : this("", "", "", false, "", "")
}
