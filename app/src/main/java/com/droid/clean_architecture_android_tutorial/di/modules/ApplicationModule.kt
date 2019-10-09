package com.droid.clean_architecture_android_tutorial.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @Modules add object to Dependency Graphs over provides method
 */


/**
 * @author Muhammad Atif
 * @Github AtifAbbAsi19
 */
@Module
class ApplicationModule(mApplication: Application) {

    var mApplication: Application


    init {
        this.mApplication = mApplication
    }

    /*  fun ApplicationModule() {
          this.mApplication = mApplication
      }
  */
    @Singleton
    @Provides
    fun getApplication(): Application {
        return mApplication
    }


}