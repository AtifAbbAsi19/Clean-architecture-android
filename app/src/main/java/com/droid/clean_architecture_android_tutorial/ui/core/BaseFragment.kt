package com.droid.clean_architecture_android_tutorial.ui.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {


    protected lateinit var mFragmentViewDataBinding: ViewDataBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        onCreateViews(savedInstanceState)


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        mFragmentViewDataBinding = DataBindingUtil.inflate(inflater, setLayout(), container, false)

        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    abstract fun onCreateView(savedInstanceState: Bundle?)
    abstract fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle)
//    abstract fun onViewCreated(view: View, savedInstanceState: Bundle)

    override fun onStart() {
        super.onStart()
        onCreateViews()
        initViewsListeners()
    }

    abstract fun setLayout(): Int

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


}