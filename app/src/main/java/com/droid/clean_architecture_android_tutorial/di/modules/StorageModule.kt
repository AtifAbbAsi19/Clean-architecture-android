package com.droid.clean_architecture_android_tutorial.di.modules

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class StorageModule {

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    fun providesSharedPreferences(application: Application): SharedPreferences {
        // Application reference must come from AppModule.class
        return PreferenceManager.getDefaultSharedPreferences(application)
    }


}