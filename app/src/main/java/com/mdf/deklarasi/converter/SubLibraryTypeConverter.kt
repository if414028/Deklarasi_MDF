package com.mdf.deklarasi.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mdf.deklarasi.model.SpiritualWarfareSubCategory
import com.mdf.deklarasi.model.SubLibrary
import java.lang.reflect.Type

class SubLibraryTypeConverter {

    @TypeConverter
    fun stringToSubLibrary(data: String?): List<SubLibrary?>? {
        if (data == null) {
            return listOf()
        }
        val listType: Type = object :
            TypeToken<List<SubLibrary?>?>() {}.type
        return Gson().fromJson<List<SubLibrary?>>(data, listType)
    }

    @TypeConverter
    fun listSubLibraryToString(someObjects: List<SubLibrary?>?): String? {
        return Gson().toJson(someObjects)
    }
}