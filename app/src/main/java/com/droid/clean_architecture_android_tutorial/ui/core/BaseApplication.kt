package com.droid.clean_architecture_android_tutorial.ui.core

import android.app.Application
import com.droid.clean_architecture_android_tutorial.di.components.DaggerNetworkComponent

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val networkComponent=DaggerNetworkComponent.create()
        networkComponent.inject(this)


    }


}