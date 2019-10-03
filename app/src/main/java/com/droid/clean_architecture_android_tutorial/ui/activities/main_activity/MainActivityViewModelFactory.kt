package com.droid.clean_architecture_android_tutorial.ui.activities.main_activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.droid.clean_architecture_android_tutorial.network.retrofit.RequestApi

class MainActivityViewModelFactory( private val repository: RequestApi) : ViewModelProvider.NewInstanceFactory() {



    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(repository) as T
    }

}