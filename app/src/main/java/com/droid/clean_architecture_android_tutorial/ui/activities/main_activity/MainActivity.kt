package com.droid.clean_architecture_android_tutorial.ui.activities.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.droid.clean_architecture_android_tutorial.R
import com.droid.clean_architecture_android_tutorial.data.beans.Comment
import com.droid.clean_architecture_android_tutorial.data.beans.Post
import com.droid.clean_architecture_android_tutorial.databinding.ActivityMainBinding
import com.droid.clean_architecture_android_tutorial.network.retrofit.RequestApi
import com.droid.clean_architecture_android_tutorial.ui.adapters.RecyclerAdapter
import com.droid.clean_architecture_android_tutorial.ui.core.BaseActivity
import com.droid.clean_architecture_android_tutorial.ui.core.BaseApplication
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

/**
 * @author Muhammad Atif
 * @Github AtifAbbAsi19
 */

class MainActivity : BaseActivity() {
//class MainActivity : BaseActivity<ActivityMainBinding>() {

    //ui
    private var recyclerView: RecyclerView? = null

    // vars
    private val disposables = CompositeDisposable()
    private var adapter: RecyclerAdapter? = null

    private val TAG = "MAINACTIIVTY"

//    @Inject
//    lateinit var requestApi: RequestApi

    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Inject
    private lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateViews(savedInstanceState: Bundle?) {
        //no implementation Required
    }


    override fun setLayout(): Int {
        return R.layout.activity_main
    }


    override fun onCreateViews() {


        recyclerView = findViewById(R.id.recycler_view)


        mainActivityViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)

        initRecyclerView()

        if (null != requestApi) {
//        if (this::requestApi.isInitialized && null != requestApi) {
//            requestApi.getComments(1)
        }



        getPostsObservable()
            .subscribeOn(Schedulers.io())
            .flatMap { post -> getCommentsObservable(post) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Post> {
                override fun onSubscribe(d: Disposable) {
                    disposables.add(d)
                }

                override fun onNext(post: Post) {
                    updatePost(post)
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG, "onError: ", e)
                }

                override fun onComplete() {}
            })


    }

    /*  private fun subscribeUi() {

          val postListResponse = Observer<ArrayList<Post>> { posts ->

          }


          mainActivityViewModel.getPostList().observe(this, postListResponse)


      }*/

    private fun getPostsObservable(): Observable<Post> {
        return requestApi
            .getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { posts ->
                adapter!!.setPosts(posts)
                Observable.fromIterable(posts)
                    .subscribeOn(Schedulers.io())
            }
    }

    private fun updatePost(post: Post) {
        adapter!!.updatePost(post)
    }

    private fun getCommentsObservable(post: Post): Observable<Post> {
        return requestApi
            .getComments(post.id)
            .map { comments ->
                val delay = (Random().nextInt(5) + 1) * 1000 // sleep thread for x ms
                Thread.sleep(delay.toLong())
                Log.d(
                    TAG,
                    "apply: sleeping thread " + Thread.currentThread().name + " for " + delay.toString() + "ms"
                )

                post.comments = comments
                post
            }
            .subscribeOn(Schedulers.io())

    }


    private fun initRecyclerView() {

        adapter = RecyclerAdapter()
        if (null != recyclerView) {
            recyclerView!!.layoutManager = LinearLayoutManager(this)
            recyclerView!!.adapter = adapter
        }
    }


    override fun initViewsListeners() {

    }

    override fun onFinish() {

    }

}
