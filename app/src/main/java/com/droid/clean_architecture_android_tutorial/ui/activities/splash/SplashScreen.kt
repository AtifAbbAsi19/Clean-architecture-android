package com.droid.clean_architecture_android_tutorial.ui.activities.splash


import android.os.Bundle
import android.util.Log
import android.view.View
import com.droid.clean_architecture_android_tutorial.R
import com.droid.clean_architecture_android_tutorial.databinding.ActivitySplashScreenBinding
import com.droid.clean_architecture_android_tutorial.ui.core.BaseActivity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import android.widget.Toast
import com.droid.clean_architecture_android_tutorial.ui.activities.main_activity.MainActivity
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_splash_screen.view.*


class SplashScreen : BaseActivity<ActivitySplashScreenBinding>() {


    val TAG = this.javaClass.simpleName

    var disposable: CompositeDisposable = CompositeDisposable()


    lateinit var mObservable: Observable<Int> // Observable

    lateinit var mObserver: Observer<Int> // Observer

    override fun onCreateViews(savedInstanceState: Bundle?) {

    }


    override fun setLayout(): Int {
        return R.layout.activity_splash_screen
    }

    override fun onCreateViews() {


        initializeObservable()

        if (this::mObservable.isInitialized)
            initializeObserver()

    }

    //    code to initialize Observable
    fun initializeObservable() {

        this.mActivityViewDataBinding.let { it.root.progressBar.visibility = View.VISIBLE }
        this.mActivityViewDataBinding.let { it.root.tvLoadingLabel.visibility = View.VISIBLE }

        mObservable = Observable.create {

            for (i in 1..100) {
                if (!it.isDisposed) {
                    Log.d(TAG, "Create : onNext : ".plus(i))
                    it.onNext(i)
                }
            }//end of for loop

            if (!it.isDisposed) {
                Log.d(TAG, "Create : onComplete : ")
                it.onComplete()
            }


        }


    }


    //  code to initialize Observer
    fun initializeObserver() {

        mObserver = object : Observer<Int> {
            override fun onComplete() {

                mActivityViewDataBinding.root.progressBar.visibility = View.INVISIBLE
                mActivityViewDataBinding.root.tvLoadingLabel.visibility = View.INVISIBLE


                Toast.makeText(this@SplashScreen, "onComplete : ", Toast.LENGTH_SHORT).show()
                startNewActivity(this@SplashScreen, MainActivity::class.java)
                finish()

            }

            override fun onSubscribe(d: Disposable) {
                disposable.add(d)
                Toast.makeText(this@SplashScreen, "onSubscribe : ", Toast.LENGTH_SHORT).show()
            }

            override fun onNext(t: Int) {
                Log.d(TAG, "onNext : ".plus(t))
                Toast.makeText(this@SplashScreen, "onNext : ".plus(t), Toast.LENGTH_SHORT).show()
            }

            override fun onError(e: Throwable) {
                Toast.makeText(this@SplashScreen, "Error : ".plus(e), Toast.LENGTH_SHORT).show()
            }

        }

        //subscribing observer to observable
        mObservable.subscribe(mObserver);

    }


    /* fun loadSpinner(): Observable<Int> {

         return Observable.fromIterable(DataSource().getLoaderData()) // data source
             .subscribeOn(Schedulers.io())// subscribing data in background thread
             .observeOn(AndroidSchedulers.mainThread())// returning data to main thread

     }*/


    override fun initViewsListeners() {

    }

    override fun onFinish() {
        disposable.dispose()
    }


}
