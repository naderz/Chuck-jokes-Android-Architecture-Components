package com.roobics.chuck

import android.app.Application
import com.roobics.chuck.data.ChuckRepository
import com.roobics.chuck.data.ChuckService
import com.roobics.chuck.utils.AppExecutors
import com.roobics.chuck.utils.LiveDataCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class BaseApp : Application() {


    private var chuckRepository: ChuckRepository = ChuckRepository(Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(ChuckService::class.java))

    private var appExecutors: AppExecutors = AppExecutors()

    fun getChuckRepository(): ChuckRepository {
        return chuckRepository
    }

    fun getAppExecutor(): AppExecutors {
        return appExecutors
    }

}