package com.itproger.lovecalculator.retrofit

import com.itproger.lovecalculator.retrofit.api.LoveApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    var retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    var api = retrofit.create(LoveApi::class.java)
}