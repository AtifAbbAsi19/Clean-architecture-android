package com.droid.clean_architecture_android_tutorial.ui.activities.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.droid.clean_architecture_android_tutorial.R
import com.droid.clean_architecture_android_tutorial.data.beans.Post
import com.droid.clean_architecture_android_tutorial.databinding.ActivityMainBinding
import com.droid.clean_architecture_android_tutorial.network.retrofit.RequestApi
import com.droid.clean_architecture_android_tutorial.ui.core.BaseActivity
import com.droid.clean_architecture_android_tutorial.ui.core.BaseApplication
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
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


        (application as BaseApplication).appComponent.inject(this)


        if (this::requestApi.isInitialized && null != requestApi) {
//            requestApi.getComments(1)
        }

    }


    override fun initViewsListeners() {

    }

    override fun onFinish() {

    }

}
