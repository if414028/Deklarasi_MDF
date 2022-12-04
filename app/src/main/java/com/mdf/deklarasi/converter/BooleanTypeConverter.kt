package com.mdf.deklarasi.converter

import androidx.room.TypeConverter

open class BooleanTypeConverter {

    @TypeConverter
    fun booleanFromInteger(value: Int): Boolean {
        return value != 0
    }

    @TypeConverter
    fun intToBoolean(value: Boolean): Int {
        return if (value) {
            1
        } else {
            0
        }
    }
}