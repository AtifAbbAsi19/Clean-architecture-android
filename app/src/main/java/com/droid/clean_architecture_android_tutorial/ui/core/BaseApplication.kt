package com.droid.clean_architecture_android_tutorial.ui.core

import android.app.Application
import android.util.Log
import com.droid.clean_architecture_android_tutorial.di.components.DaggerNetworkComponent
import com.droid.clean_architecture_android_tutorial.network.retrofit.RequestApi
import javax.inject.Inject

class BaseApplication : Application() {

    /**
     * Field Injection or Member Injection
     */
    //    @JvmField
    @Inject
    public  lateinit var requestApi: RequestApi

    override fun onCreate() {
        super.onCreate()

        val networkComponent = DaggerNetworkComponent.create()
        networkComponent.inject(this)

        Log.d("NetworkModule", "AppClass : networkComponent")


    }


}