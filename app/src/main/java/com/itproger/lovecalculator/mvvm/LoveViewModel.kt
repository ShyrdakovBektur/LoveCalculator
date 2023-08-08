package com.itproger.lovecalculator.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itproger.lovecalculator.retrofit.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel(), java.io.Serializable{


    fun getLiveData(firstName: String, secondName: String) : LiveData<LoveModel> {
        return repository.getPercentage(firstName, secondName)
    }

    fun getAll(): LiveData<String> {
        var result = ""
        val list = repository.getAllInformation()
        list.forEach {
          result += "First name - ${it.firstName} \nSecond name - ${it.secondName} \nCompatibility - ${it.percentage}% \n\n"
        }
        return MutableLiveData(result)
    }
}