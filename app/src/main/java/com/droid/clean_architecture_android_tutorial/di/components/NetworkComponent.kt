package com.droid.clean_architecture_android_tutorial.di.components

import android.app.Application
import com.droid.clean_architecture_android_tutorial.di.modules.NetworkModule
import dagger.Component


@Component(modules = arrayOf(NetworkModule::class))
interface NetworkComponent {

    fun inject(application: Application)

}