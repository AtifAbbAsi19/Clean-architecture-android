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
     * @JvmField
     * @Inject
     */


    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

/*     val appComponent = DaggerAppComponent.create() if no value for constructor
 */

        appComponent = DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .applicationModule(ApplicationModule(this))
            .build()


        Log.d("NetworkModule", "AppClass : networkComponent")


    }


    fun getApplicationComponent(): AppComponent {
        return appComponent

    }

}