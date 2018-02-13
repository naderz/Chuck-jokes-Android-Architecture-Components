package com.roobics.chuck.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.roobics.chuck.data.ChuckJoke
import com.roobics.chuck.data.ChuckRepository
import com.roobics.chuck.utils.Resource

class WelcomeViewModel(private val chuckRepository: ChuckRepository) : ViewModel() {

    private val trigger: MutableLiveData<Unit> = MutableLiveData()

    private val updatingJoke: LiveData<Resource<ChuckJoke>> = Transformations.switchMap(trigger) { _ ->
        chuckRepository.getJoke()
    }

    fun getJoke(): LiveData<Resource<ChuckJoke>> {
        if (updatingJoke.value == null) {
            fetchJoke()
        }
        return updatingJoke
    }

    fun fetchJoke() {
        // trigger new API call
        trigger.value = Unit
    }

}
