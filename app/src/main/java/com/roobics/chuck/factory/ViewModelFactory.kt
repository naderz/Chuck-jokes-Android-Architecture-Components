package com.roobics.chuck.factory

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.roobics.chuck.BaseApp
import com.roobics.chuck.data.ChuckRepository
import com.roobics.chuck.ui.WelcomeViewModel


@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory() {

    private val chuckRepository: ChuckRepository = (mApplication as BaseApp).getChuckRepository()

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WelcomeViewModel::class.java)) {
            return WelcomeViewModel(chuckRepository) as T
        }

        return modelClass.newInstance()
    }
}