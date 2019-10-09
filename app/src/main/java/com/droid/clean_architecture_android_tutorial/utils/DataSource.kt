package com.droid.clean_architecture_android_tutorial.utils

/**
 * @author Muhammad Atif
 * @Github AtifAbbAsi19
 */
class DataSource {
    /**
     *
     * https://www.coderefer.com/rxandroid-example-tutorial/
     *
     *
     *
     *
     *   https://guides.codepath.com/android/Dependency-Injection-with-Dagger-2
     *
     * https://www.journaldev.com/20405/android-dagger-2-retrofit-recyclerview
     *
     * https://www.vogella.com/tutorials/Dagger/article.html
     *
     * https://android.jlelse.eu/android-mvvm-with-dagger-2-retrofit-rxjava-architecture-components-6f5da1a75135
     *
     * https://medium.com/knowing-android/headers-interceptors-and-authenticators-with-retrofit-1a00fed0d5eb
     *
     */

    public fun getLoaderData(): List<Int> {

        var loadingList = ArrayList<Int>()
        loadingList.clear()



        for (i in 1..10) {
            loadingList.add(i)
//            println(i)
        }

        return loadingList

    }


}