package com.itproger.lovecalculator.sharepreferences.preferences

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Preference (context: Context){

    companion object{
        const val PREFERENCES_NAME = "MyPreferences"
    }

    private var preferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE)


    fun saveBoardState() {
        preferences.edit().putBoolean("isShow", true).apply()
    }

    fun isBoardShow(): Boolean{
        return preferences.getBoolean("isShow", false)
    }
}