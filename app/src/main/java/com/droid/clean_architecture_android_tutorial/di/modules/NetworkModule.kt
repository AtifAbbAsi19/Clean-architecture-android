package com.droid.clean_architecture_android_tutorial.di.modules

import android.util.Log
import com.droid.clean_architecture_android_tutorial.network.retrofit.RequestApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Muhammad Atif
 * @Github AtifAbbAsi19
 */
@Module
public class NetworkModule {

    val BASE_URL = "https://jsonplaceholder.typicode.com"

    var TAG = "NetworkModule"
    @Singleton
    @Provides
    fun getRequestApi(retroFit: Retrofit): RequestApi {
        Log.d(TAG, "getRequestApi")
        return retroFit.create<RequestApi>(RequestApi::class.java)
    }

    /*  @Binds
      abstract fun bindRequestApi(retroFit: Retrofit)
  */
    @Singleton
    @Provides
    fun getRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        // fun getRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        /* val gson = GsonBuilder()
             .setLenient()
             .create()*/
        Log.d(TAG, "getRetrofit")
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun getGson(): Gson {

        return GsonBuilder()
            .setLenient()
            .create()

    }


    @Singleton
    @Provides
    fun getOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        Log.d(TAG, "getOkHttpClient")
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    }


    @Singleton
    @Provides
    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        Log.d(TAG, "getHttpLoggingInterceptor")
        var httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

/*
    @Provides
    @Singleton
    fun getUnsafeOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", UUID.randomUUID().toString())
                    .addHeader("Content-Type", "application/json")
                    .addHeader("charset", "UTF-8")
                    .build()
                chain.proceed(newRequest)
            }
    }
*/

}

