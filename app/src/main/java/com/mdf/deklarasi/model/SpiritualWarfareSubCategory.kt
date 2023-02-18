package com.mdf.deklarasi.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class SpiritualWarfareSubCategory(
    var id: String,
    var subCategoryName: String,
    var verses: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(subCategoryName)
        parcel.writeString(verses)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SpiritualWarfareSubCategory> {
        override fun createFromParcel(parcel: Parcel): SpiritualWarfareSubCategory {
            return SpiritualWarfareSubCategory(parcel)
        }

        override fun newArray(size: Int): Array<SpiritualWarfareSubCategory?> {
            return arrayOfNulls(size)
        }
    }
}
