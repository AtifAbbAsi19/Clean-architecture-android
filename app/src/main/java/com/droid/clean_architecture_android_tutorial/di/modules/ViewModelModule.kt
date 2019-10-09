package com.droid.clean_architecture_android_tutorial.di.modules

import dagger.Module
import javax.inject.Singleton
import androidx.lifecycle.ViewModel
import com.droid.clean_architecture_android_tutorial.ui.activities.main_activity.MainActivityViewModel
import dagger.multibindings.IntoMap
import dagger.Binds
import com.droid.clean_architecture_android_tutorial.ui.core.ViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.droid.clean_architecture_android_tutorial.di.annotations.ViewModelKey


/**
 * @author Muhammad Atif
 * @Github AtifAbbAsi19
 */
//@Singleton error
@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


}