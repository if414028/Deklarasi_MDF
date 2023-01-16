package com.mdf.deklarasi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShofarSound(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "file")
    var file: String,

    @ColumnInfo(name = "image")
    var image: String

) {
    constructor() : this("", "", "", "")
}
