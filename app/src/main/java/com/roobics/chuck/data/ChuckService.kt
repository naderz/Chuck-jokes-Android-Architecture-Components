package com.roobics.chuck.data

import android.arch.lifecycle.LiveData
import com.roobics.chuck.utils.Resource
import retrofit2.http.GET


interface ChuckService {

    @GET("jokes/random")
    fun getJoke(): LiveData<Resource<ChuckJoke>>

}