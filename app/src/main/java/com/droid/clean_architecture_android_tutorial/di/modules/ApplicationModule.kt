package com.droid.clean_architecture_android_tutorial.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    lateinit var mApplication: Application


    fun ApplicationModule(mApplication: Application) {
        this.mApplication = mApplication
    }

    @Singleton
    @Provides
    fun getApplication(): Application {
        return mApplication
    }


}