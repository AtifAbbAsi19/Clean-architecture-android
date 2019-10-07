package com.droid.clean_architecture_android_tutorial.di.components

import android.app.Application
import com.droid.clean_architecture_android_tutorial.di.modules.ApplicationModule
import com.droid.clean_architecture_android_tutorial.di.modules.NetworkModule
import com.droid.clean_architecture_android_tutorial.network.retrofit.RequestApi
import dagger.Component


@Component(modules = arrayOf(NetworkModule::class,ApplicationModule::class))
interface AppComponent {

//    fun getRequestApi(): RequestApi

    fun inject(application: Application)

}