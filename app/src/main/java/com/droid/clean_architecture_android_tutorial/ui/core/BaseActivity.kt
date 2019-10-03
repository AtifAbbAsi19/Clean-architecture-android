package com.droid.clean_architecture_android_tutorial.ui.core

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {


    protected lateinit var mViewDataBinding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateViews(savedInstanceState)
        setContentView(setLayout())

        mViewDataBinding = DataBindingUtil.setContentView(this, setLayout())


    }

    override fun onStart() {
        super.onStart()
        onCreateViews()
        initViewsListeners()
    }

    abstract fun setLayout(): Int
    /**
     * @savedInstanceState for saved State Instance Screen Rotation
     */
    abstract fun onCreateViews(savedInstanceState: Bundle?)

    /**
     * for normal flow
     */

    abstract fun onCreateViews()


    abstract fun initViewsListeners()

    abstract fun onFinish()

    override fun onDestroy() {
        System.runFinalization() //The java.lang.System.runFinalization()
        // method runs the finalization methods of any objects pending finalization.
        System.gc() //garbage collector to remove object
        onFinish() //on finish method
        super.onDestroy()
    }
//on low memeirt


    fun startNewActivity(context: Context, clazz: Class<*>, extras: Bundle) {

        val intent = Intent(context, clazz)
        // To pass any data to next activity
        intent.putExtra("keyIdentifier", extras)
        // start your next activity
        context.startActivity(intent)

    }


    fun startNewActivity(context: Context, clazz: Class<*>) {

        val intent = Intent(context, clazz)
        // start your next activity
        context.startActivity(intent)

    }


    /**
     * @throws Exception
     *
     */
    fun startNewActivityUsingAny(context: Context, clazz: Class<Any>) {

        val intent = Intent(context, clazz)
        // start your next activity
        context.startActivity(intent)

    }




}