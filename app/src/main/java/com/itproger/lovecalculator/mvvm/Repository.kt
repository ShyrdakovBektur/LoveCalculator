package com.itproger.lovecalculator.mvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.itproger.lovecalculator.retrofit.api.LoveApi
import com.itproger.lovecalculator.room.LoveDao
import com.itproger.lovecalculator.retrofit.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private  val loveApi: LoveApi, private val loveDao: LoveDao) {

    fun getAllInformation(): List<LoveModel> {
        val unsortedData = loveDao.getAllData()
        return unsortedData.sortedBy { it.firstName }
    }
    fun getPercentage(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveData = MutableLiveData<LoveModel>()
   loveApi.getPercentage(firstName, secondName)
       .enqueue(object : Callback<LoveModel> {
           override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
           liveData.postValue(response.body())
               loveDao.insert(response.body()!!)
           }

           override fun onFailure(call: Call<LoveModel>, t: Throwable) {
               Log.e("ololo", t.message.toString())
           }
       })
        return liveData
    }

}