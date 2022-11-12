package com.mdf.deklarasi.utilities

import android.content.Context
import android.content.SharedPreferences

class UserConfiguration {

    val SP_NAME = "deklarasiSf"
    private val COMPLETE_FILL_DATA = "completeFillData"

    private lateinit var sharedPreferences: SharedPreferences

    companion object {
        private val ourInstance = UserConfiguration()
        fun getInstance(): UserConfiguration {
            return ourInstance
        }
    }

    fun initSharedPreference(context: Context) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
    }

    fun setCompleteFillData() {
        val editor = sharedPreferences.edit()
        editor.putBoolean(COMPLETE_FILL_DATA, true)
        editor.apply()
    }

    fun getCompleteFillData(): Boolean {
        return sharedPreferences.getBoolean(COMPLETE_FILL_DATA, false)
    }
}