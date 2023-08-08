package com.itproger.lovecalculator.di

import android.content.Context
import androidx.room.Room
import com.itproger.lovecalculator.retrofit.api.LoveApi
import com.itproger.lovecalculator.room.LoveDao
import com.itproger.lovecalculator.room.LoveDatabase
import com.itproger.lovecalculator.sharepreferences.preferences.Preference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {


    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoveApi::class.java)
    }

    @Singleton
    @Provides
    fun provideSharePreferences(@ApplicationContext context: Context): Preference {
        return Preference(context)
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): LoveDatabase {
        return Room.databaseBuilder(context, LoveDatabase::class.java, "love_file")
            .allowMainThreadQueries()
            .build()
    }


    @Provides
    fun provideLoveDao(@ApplicationContext context: Context): LoveDao {
        return provideDatabase(context).loveDao()
    }
}
