package com.itproger.lovecalculator.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.itproger.lovecalculator.retrofit.LoveModel


@Database(entities = [LoveModel::class], version = 2)
abstract class LoveDatabase : RoomDatabase() {
abstract fun loveDao(): LoveDao
}