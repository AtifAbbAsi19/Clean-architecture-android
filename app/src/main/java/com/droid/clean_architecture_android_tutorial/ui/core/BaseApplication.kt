package com.droid.clean_architecture_android_tutorial.ui.core

import android.app.Application
import com.droid.clean_architecture_android_tutorial.di.components.DaggerNetworkComponent
import com.droid.clean_architecture_android_tutorial.network.retrofit.RequestApi
import javax.inject.Inject

class BaseApplication : Application() {


    //    @JvmField
    @Inject
    lateinit var requestApi: RequestApi

    override fun onCreate() {
        super.onCreate()

        val networkComponent = DaggerNetworkComponent.create()
        networkComponent.inject(this)


    }


}