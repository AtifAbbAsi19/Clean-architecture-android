package com.droid.clean_architecture_android_tutorial.utils

import android.content.Context
import com.droid.clean_architecture_android_tutorial.network.retrofit.NetworkService
import com.droid.clean_architecture_android_tutorial.network.retrofit.RequestApi
import com.droid.clean_architecture_android_tutorial.ui.activities.main_activity.MainActivityViewModelFactory

class InjectorUtils {


    fun provideLoginModelFactory(context: Context): MainActivityViewModelFactory {
        val repository = getAuthRepository(context)
        return MainActivityViewModelFactory(repository)
    }


    private fun getAuthRepository(context: Context): RequestApi {
        return NetworkService().getRequestApi()
    }

}