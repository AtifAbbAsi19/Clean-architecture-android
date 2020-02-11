package com.droid.clean_architecture_android_tutorial.di.components

import android.app.Application
import androidx.databinding.ViewDataBinding
import com.droid.clean_architecture_android_tutorial.di.modules.*
import com.droid.clean_architecture_android_tutorial.network.retrofit.RequestApi
import com.droid.clean_architecture_android_tutorial.ui.activities.main_activity.MainActivity
import com.droid.clean_architecture_android_tutorial.ui.core.BaseActivity
import com.droid.clean_architecture_android_tutorial.ui.core.BaseApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * @author Muhammad Atif
 * @Github AtifAbbAsi19
 */

@Singleton
@Component(
    modules = arrayOf(
        NetworkModule::class,
        ApplicationModule::class,
//        StorageModule::class,
        ViewModelModule::class
    )
)
interface AppComponent {

    /**
     * @Component Components define from which modules (or other components) dependencies are provided
     *
     *
     * @Basic_Url
     * https://code.tutsplus.com/tutorials/dependency-injection-with-dagger-2-on-android--cms-23345
     *
     * @Advance_url
     * https://android.jlelse.eu/android-mvvm-with-dagger-2-retrofit-rxjava-architecture-components-6f5da1a75135
     *
     * https://www.journaldev.com/20405/android-dagger-2-retrofit-recyclerview
     *
     * https://guides.codepath.com/android/Dependency-Injection-with-Dagger-2
     *
     * fun inject(base: BaseActivity<*>)
     *
     * fun getRequestApi(): RequestApi
     *
     * fun inject(application: Application)
     *
     */

    fun inject(baseApplication: BaseApplication)

//    fun inject(mainActivity: MainActivity)

    fun inject(baseActivity: BaseActivity)


    /* @Component.Builder
     interface Builder{
         @BindsInstance
         Builder horsePower(int horsePower);

         carComponent Build();

     }
 */
}