package com.droid.clean_architecture_android_tutorial.network.retrofit

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import com.droid.clean_architecture_android_tutorial.data.beans.Comment
import com.droid.clean_architecture_android_tutorial.data.beans.Post


interface RequestApi {


    @GET("posts")
    abstract fun getPosts(): Observable<List<Post>>

    @GET("posts/{id}/comments")
    abstract fun getComments(
        @Path("id") id: Int
    ): Observable<List<Comment>>


}