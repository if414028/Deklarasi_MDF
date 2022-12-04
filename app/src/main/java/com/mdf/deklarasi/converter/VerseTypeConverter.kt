package com.mdf.deklarasi.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mdf.deklarasi.model.Verse
import java.lang.reflect.Type

open class VerseTypeConverter {

    @TypeConverter
    fun stringToVerse(data: String?): List<Verse?>? {
        if (data == null) {
            return listOf()
        }
        val listType: Type = object :
            TypeToken<List<Verse?>?>() {}.type
        return Gson().fromJson<List<Verse?>>(data, listType)
    }

    @TypeConverter
    fun listVerseToString(someObjects: List<Verse?>?): String? {
        return Gson().toJson(someObjects)
    }
}