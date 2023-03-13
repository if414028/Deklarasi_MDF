package com.mdf.deklarasi.model

import android.os.Parcel
import android.os.Parcelable

data class SubLibrary(
    var id: String,
    var title: String,
    var content: String,
    var image: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {

    }

    constructor() : this("", "", "", "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(content)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SubLibrary> {
        override fun createFromParcel(parcel: Parcel): SubLibrary {
            return SubLibrary(parcel)
        }

        override fun newArray(size: Int): Array<SubLibrary?> {
            return arrayOfNulls(size)
        }
    }

}
