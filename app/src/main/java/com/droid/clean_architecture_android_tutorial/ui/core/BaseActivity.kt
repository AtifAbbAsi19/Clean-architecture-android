package com.droid.clean_architecture_android_tutorial.ui.core

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.droid.clean_architecture_android_tutorial.network.retrofit.RequestApi
import javax.inject.Inject


/**
 * @author Muhammad Atif
 * @Github AtifAbbAsi19
 */

abstract class BaseActivity : AppCompatActivity() {
    //Base class extends databinding BaseActivity<T : ViewDataBinding>
    //https://www.journaldev.com/1663/java-generics-example-method-class-interface
//abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {


    protected lateinit var mActivityViewDataBinding: ViewDataBinding

    @Inject
    lateinit var requestApi: RequestApi

/*

    @Inject
   protected lateinit var requestApi: RequestApi

*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateViews(savedInstanceState)
        setContentView(setLayout())

        (application as BaseApplication).appComponent.inject(this)


        mActivityViewDataBinding = DataBindingUtil.setContentView(this, setLayout())


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
     * @Any
     * @throws Exception
     *
     */
    fun startNewActivityUsingAny(context: Context, clazz: Class<Any>) {

        val intent = Intent(context, clazz)
        // start your next activity
        context.startActivity(intent)

    }


}