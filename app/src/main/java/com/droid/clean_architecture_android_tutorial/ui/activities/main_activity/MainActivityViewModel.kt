package com.droid.clean_architecture_android_tutorial.ui.activities.main_activity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.droid.clean_architecture_android_tutorial.data.beans.Post
import com.droid.clean_architecture_android_tutorial.network.retrofit.RequestApi
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

/**
 * @author Muhammad Atif
 * @Github AtifAbbAsi19
 */
class MainActivityViewModel @Inject constructor(var requestApi: RequestApi) : ViewModel() {

    var disposable: CompositeDisposable = CompositeDisposable()

    private val TAG = "MainActivityViewModel"

    var postList = ArrayList<Post>()

    /*  init {
          private val disposables = CompositeDisposable()
      }*/

    var post = MutableLiveData<List<Post>>()


    private fun getPostsObservable(): Observable<Post> {
        return requestApi
            .getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { posts ->
                post.value = posts
                Observable.fromIterable(posts)
                    .subscribeOn(Schedulers.io())
            }
    }


    private fun getComments(): Unit {

        getPostsObservable().subscribeOn(Schedulers.io())
            .flatMap { post -> getCommentsObservable(post) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Post> {
                override fun onSubscribe(d: Disposable) {
                    disposable.add(d)
                }

                override fun onNext(postx: Post) {
                    postList.add(postx)
                    post.value = postList
                }

                override fun onError(e: Throwable) {
                    Log.e("TAG", "onError: ", e)
                }

                override fun onComplete() {}
            })

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


    fun getPostList(): LiveData<List<Post>> {
        return post
    }


}