package com.droid.clean_architecture_android_tutorial.di.components

import android.app.Application
import com.droid.clean_architecture_android_tutorial.di.modules.NetworkModule
import com.droid.clean_architecture_android_tutorial.network.retrofit.RequestApi
import dagger.Component


@Component(modules = arrayOf(NetworkModule::class))
interface NetworkComponent {

//    fun getRequestApi(): RequestApi

    fun inject(application: Application)

}