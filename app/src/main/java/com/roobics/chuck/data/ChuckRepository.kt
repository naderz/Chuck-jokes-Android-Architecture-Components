package com.roobics.chuck.data

import android.arch.lifecycle.LiveData
import com.roobics.chuck.utils.Resource


class ChuckRepository constructor(var chuckService: ChuckService) {

    fun getJoke(): LiveData<Resource<ChuckJoke>> {
        return chuckService.getJoke()
    }

}



