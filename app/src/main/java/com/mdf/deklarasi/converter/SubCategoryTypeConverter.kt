package com.mdf.deklarasi.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mdf.deklarasi.model.SpiritualWarfareSubCategory
import java.lang.reflect.Type

open class SubCategoryTypeConverter {

    @TypeConverter
    fun stringToSubCategory(data: String?): List<SpiritualWarfareSubCategory?>? {
        if (data == null) {
            return listOf()
        }
        val listType: Type = object :
            TypeToken<List<SpiritualWarfareSubCategory?>?>() {}.type
        return Gson().fromJson<List<SpiritualWarfareSubCategory?>>(data, listType)
    }

    @TypeConverter
    fun listSubCategoryToString(someObjects: List<SpiritualWarfareSubCategory?>?): String? {
        return Gson().toJson(someObjects)
    }

}