package com.droid.clean_architecture_android_tutorial.ui.activities.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.droid.clean_architecture_android_tutorial.R
import com.droid.clean_architecture_android_tutorial.databinding.ActivityMainBinding
import com.droid.clean_architecture_android_tutorial.network.retrofit.RequestApi
import com.droid.clean_architecture_android_tutorial.ui.core.BaseActivity
import com.droid.clean_architecture_android_tutorial.ui.core.BaseApplication
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>() {


    @Inject
    lateinit var requestApi: RequestApi


    override fun onCreateViews(savedInstanceState: Bundle?) {
        //no implementation Required
    }


    override fun setLayout(): Int {
        return R.layout.activity_main
    }


    override fun onCreateViews() {

        if (this::requestApi.isInitialized)
            requestApi.getPosts()


//        if (BaseApplication()::requestApi.isInitialized && BaseApplication()::requestApi != null) {
//            requestApi.getPosts()
//        }


    }


    override fun initViewsListeners() {

    }

    override fun onFinish() {

    }

}
