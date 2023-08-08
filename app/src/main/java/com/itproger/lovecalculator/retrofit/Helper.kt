package com.itproger.lovecalculator.retrofit

import android.content.Context
import android.widget.Toast

class Helper {
    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}
