package com.hedwig.ecure.network.firebase.storage

/*
//todo import code to use Classes
import com.google.firebase.storage.UploadTask
*/


/**
 * @author Muhammad Atif Arif
 * @Github atifabbasi19
 */

interface UploadTaskSnapShotResult {

    //todo Uncomment code to use Classes
/*
    fun onSuccess(taskSnapshot: UploadTask.TaskSnapshot)*/
    fun onFailure(exception: Exception)
   /* fun onProgress(taskSnapshot: UploadTask.TaskSnapshot)*/

}