package com.droid.clean_architecture_android_tutorial.di.components

import android.app.Application
import com.droid.clean_architecture_android_tutorial.di.modules.ApplicationModule
import com.droid.clean_architecture_android_tutorial.di.modules.NetworkModule
import com.droid.clean_architecture_android_tutorial.network.retrofit.RequestApi
import com.droid.clean_architecture_android_tutorial.ui.activities.main_activity.MainActivity
import com.droid.clean_architecture_android_tutorial.ui.core.BaseApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetworkModule::class, ApplicationModule::class))
interface AppComponent {

    //    fun getRequestApi(): RequestApi
//    fun inject(application: Application)

    fun inject(baseApplication: BaseApplication)
    fun inject(mainActivity: MainActivity)

}