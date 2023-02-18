package com.mdf.deklarasi.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SpiritualWarfareVerse(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "category")
    var category: String,

    @ColumnInfo(name = "sub_category")
    var subCategory: List<SpiritualWarfareSubCategory>,

    @ColumnInfo(name = "verses")
    var verses: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.createTypedArrayList(SpiritualWarfareSubCategory)!!,
        parcel.readString().toString()
    ) {
    }

    constructor() : this("", "", listOf(), "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(category)
        parcel.writeTypedList(subCategory)
        parcel.writeString(verses)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SpiritualWarfareVerse> {
        override fun createFromParcel(parcel: Parcel): SpiritualWarfareVerse {
            return SpiritualWarfareVerse(parcel)
        }

        override fun newArray(size: Int): Array<SpiritualWarfareVerse?> {
            return arrayOfNulls(size)
        }
    }

}

