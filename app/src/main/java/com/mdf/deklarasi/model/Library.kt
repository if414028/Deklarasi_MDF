package com.mdf.deklarasi.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Library(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "library")
    var title: String,

    @ColumnInfo(name = "sub_library")
    var subtitle: List<SubLibrary>,

    @ColumnInfo(name = "content")
    var content: String,

    @ColumnInfo(name = "image")
    var image: String

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.createTypedArrayList(SubLibrary)!!,
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    constructor() : this("", "", listOf(), "", "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeTypedList(subtitle)
        parcel.writeString(content)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Library> {
        override fun createFromParcel(parcel: Parcel): Library {
            return Library(parcel)
        }

        override fun newArray(size: Int): Array<Library?> {
            return arrayOfNulls(size)
        }
    }
}
