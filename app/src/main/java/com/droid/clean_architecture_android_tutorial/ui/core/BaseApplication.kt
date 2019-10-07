package com.droid.clean_architecture_android_tutorial.ui.core


import android.app.Application
import android.util.Log
import com.droid.clean_architecture_android_tutorial.di.components.AppComponent
import com.droid.clean_architecture_android_tutorial.di.components.DaggerAppComponent
import com.droid.clean_architecture_android_tutorial.di.modules.ApplicationModule
import com.droid.clean_architecture_android_tutorial.di.modules.NetworkModule

class BaseApplication : Application() {

    /**
     * Field Injection or Member Injection
     */
    //    @JvmField
//    @Inject
//    public lateinit var requestApi: RequestApi


    lateinit var applicationComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

//        val appComponent = DaggerAppComponent.create()
//        appComponent.inject(this)
//

        applicationComponent = DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .applicationModule(ApplicationModule(this))
            .build()

//        applicationComponent.inject(this)


//        val networkComponent = DaggerNetworkComponent.create()
//        networkComponent.inject(this)

        Log.d("NetworkModule", "AppClass : networkComponent")


    }

/*
    fun getApplicationComponent(): AppComponent {
        return applicationComponent

    }*/


}