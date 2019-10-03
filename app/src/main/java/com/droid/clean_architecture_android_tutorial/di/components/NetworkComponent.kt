package com.droid.clean_architecture_android_tutorial.di.components

import android.app.Application
import dagger.Module


@Module()
interface NetworkComponent {

    fun inject(application: Application)

}