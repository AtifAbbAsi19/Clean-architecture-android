package com.droid.clean_architecture_android_tutorial.utils

class DataSource {
    /**
     * https://www.journaldev.com/20405/android-dagger-2-retrofit-recyclerview
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