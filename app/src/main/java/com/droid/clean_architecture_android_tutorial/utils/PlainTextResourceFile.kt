// package com.droid.clean_architecture_android_tutorial.utils

// class PlainTextResourceFile {

// https://android.jlelse.eu/android-mvvm-with-dagger-2-retrofit-rxjava-architecture-components-6f5da1a75135

// https://www.journaldev.com/20405/android-dagger-2-retrofit-recyclerview


// https://proandroiddev.com/mvvm-architecture-using-livedata-rxjava-and-new-dagger-android-injection-639837b1eb6c


// https://code.tutsplus.com/tutorials/dependency-injection-with-dagger-2-on-android--cms-23345

// https://www.vogella.com/tutorials/RxJava/article.html

// https://www.journaldev.com/20433/android-rxjava-retrofit



// https://www.coderefer.com/rxandroid-tutorial-getting-started/


// https://medium.com/knowing-android/headers-interceptors-and-authenticators-with-retrofit-1a00fed0d5eb


// https://www.raywenderlich.com/262-dependency-injection-in-android-with-dagger-2-and-kotlin

// https://github.com/ResoCoder/forecast-mvvm-android-kotlin/blob/master/app/src/main/java/com/resocoder/forecastmvvm/data/network/ApixuWeatherApiService.kt

// https://github.com/ResoCoder/forecast-mvvm-android-kotlin/blob/master/app/src/main/java/com/resocoder/forecastmvvm/data/network/WeatherNetworkDataSourceImpl.kt

// https://github.com/ResoCoder/forecast-mvvm-android-kotlin/blob/master/app/src/main/java/com/resocoder/forecastmvvm/data/network/WeatherNetworkDataSource.kt



// https://kotlinlang.org/docs/reference/visibility-modifiers.html


// https://guides.codepath.com/android/Dependency-Injection-with-Dagger-2


// https://blog.kotlin-academy.com/understanding-dagger-2-multibindings-viewmodel-8418eb372848



// https://github.com/android/architecture-components-samples/tree/e33782ba54ebe87f7e21e03542230695bc893818/GithubBrowserSample/app/src/main/java/com/android/example/github/viewmodel

//https://stackoverflow.com/questions/29929963/is-there-a-way-to-show-a-preview-of-a-recyclerviews-contents-in-the-android-stu

//https://androidwave.com/recyclerview-kotlin-tutorial/



<androidx.recyclerview.widget.RecyclerView
        android:id="@+id/billTypeRecyclerView"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:overScrollMode="never"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        tools:itemCount="10"
        android:layout_marginBottom="8dp"
        app:layoutManager="androidx.recyclerview.widget.GridLayoutManager"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/selectBillTypeTv"
        tools:listitem="@layout/bill_type_item_view"
        tools:spanCount="3" />

// }