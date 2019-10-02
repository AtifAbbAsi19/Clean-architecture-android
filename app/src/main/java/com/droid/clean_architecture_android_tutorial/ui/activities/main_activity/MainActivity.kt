package com.droid.clean_architecture_android_tutorial.ui.activities.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.droid.clean_architecture_android_tutorial.R
import com.droid.clean_architecture_android_tutorial.databinding.ActivityMainBinding
import com.droid.clean_architecture_android_tutorial.ui.core.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun onCreateViews(savedInstanceState: Bundle?) {
        //no implementation Required
    }


    override fun setLayout(): Int {
        return R.layout.activity_main
    }


    override fun onCreateViews() {
//        mViewDataBinding.root
    }


    override fun initViewsListeners() {

    }

    override fun onFinish() {

    }

}
