package com.hedwig.ecure.network.firebase.database

/*

 //todo imports code to use Classes

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase*/
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Muhammad Atif Arif
 * @Github atifabbasi19
 */


class FireBaseDatabaseHelper {


    object Singleton {

        private var instance: FireBaseDatabaseHelper? = null

        fun getInstance(): FireBaseDatabaseHelper {
            if (instance == null) {
                instance = FireBaseDatabaseHelper()
            }

            return instance!!
        }

    }

/*

 //todo Uncomment code to use Classes

    private var mDatabase: FirebaseDatabase? = null

    private var mDatabaseReference: DatabaseReference? = null


    init {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.getReference()
    }


    fun getDataBaseReference(): DatabaseReference? {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.getReference()
        return mDatabaseReference
    }


    fun <T> readSnapShot(dataSnapshot: DataSnapshot, clazz: Class<T>): ArrayList<T> {

        //         ArrayList<Clazz> tempArray=new ArrayList<>();

        val arrayList = ArrayList<T>()

        for (childSnapshot in dataSnapshot.getChildren()) {

            // key for node .!
            // String key = childSnapshot.getKey();

            val `object` = childSnapshot.getValue(clazz) as T

            arrayList.add(`object`)

        }

        return arrayList
    }

    fun <T> readSnapShotKey(dataSnapshot: DataSnapshot,
                            arrayList: ArrayList<T>, clazz: Class<*>): ArrayList<T> {

        for (childSnapshot in dataSnapshot.getChildren()) {

            val key = childSnapshot.getKey()

            val `object` = childSnapshot.getValue(clazz) as T

            arrayList.add(`object`)

        }

        return arrayList
    }

*/  //todo end of comment

    fun getRandomId(): String {

        return UUID.randomUUID().toString()
    }


    fun getDateTime(): String {
        val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US)
        val date = Date()
        return dateFormat.format(date)
    }


}