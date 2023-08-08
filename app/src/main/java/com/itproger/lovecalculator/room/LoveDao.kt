package com.itproger.lovecalculator.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.itproger.lovecalculator.retrofit.LoveModel

@Dao
interface LoveDao {
    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM loveModel")
    fun getAllData(): List<LoveModel>
}