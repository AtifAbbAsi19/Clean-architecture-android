package com.droid.clean_architecture_android_tutorial.utils

class DataSource {


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