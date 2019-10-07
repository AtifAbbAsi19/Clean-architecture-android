package com.hedwig.ecure.network.firebase.storage

import android.net.Uri

/*
//todo imports code to use Classes
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
*/


/**
 * @author Muhammad Atif Arif
 * @Github atifabbasi19
 */


class FireBaseStorageHelper {

    /**
     *
     * https://firebase.google.com/docs/storage/android/upload-files#get_a_download_url
     *
     */

    object Singleton {

        private var instance: FireBaseStorageHelper? = null

        fun getInstance(): FireBaseStorageHelper {
            if (instance == null) {
                instance = FireBaseStorageHelper()
            }

            return instance!!
        }

    }
//todo Uncomment code to use Classes
    /**
     * @filePath                 StorageReference Firebase
     * @uri                      path of datas
     *@uploadTaskSnapShotResult  call back for result
     *
     */


    /*   fun uploadFile(ref: StorageReference, uriFile: Uri, downloadUriResult: DownloadUriResult) {


   //        // Create file metadata including the content type
   //        var metadata = StorageMetadata.Builder()
   //                .setContentType("image/jpg")
   //                .build()
   //
   //// Upload the file and metadata
   //        uploadTask = storageRef.child("images/mountains.jpg").putFile(file, metadata)

   //        val ref = filePath
           val uploadTask = ref.putFile(uriFile)

           val urlTask = uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
               if (!task.isSuccessful) {
                   downloadUriResult.onFailure(task.exception!!)
                   task.exception?.let {
                       throw it
                   }
               }
               return@Continuation ref.downloadUrl
           }).addOnCompleteListener { task ->
               if (task.isSuccessful) {
   //                val downloadUri = task.result
                   downloadUriResult.onSuccess(task.result!!)

               } else {
                   downloadUriResult.onFailure(task.exception!!)
               }
           }

       }

       fun uploadStorageFile(filePath: StorageReference, uri: Uri, uploadTaskSnapShotResult: UploadTaskSnapShotResult) {


           //        filePath = mFStorage.child("image").child(getRandomId() + ".png");

           filePath.putFile(uri).addOnSuccessListener { taskSnapshot ->


               uploadTaskSnapShotResult.onSuccess(taskSnapshot)

   //            val imageUrl = taskSnapshot.getDownloadUrl().toString()

           }.addOnFailureListener { exception ->

               uploadTaskSnapShotResult.onFailure(exception)
               //Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
           }.addOnProgressListener { taskSnapshot ->
               //displaying the upload progress
               uploadTaskSnapShotResult.onProgress(taskSnapshot)
               val progress = getUploadTaskProgress(taskSnapshot)

           }

       }


       fun getUploadedFileDownloadUrl(filePath: StorageReference, downloadUriResult: DownloadUriResult) {

           filePath.getDownloadUrl().addOnSuccessListener { tResult ->

               val uri: Uri = tResult

               downloadUriResult.onSuccess(tResult)

           }.addOnFailureListener { exception ->
               downloadUriResult.onFailure(exception)
           }

       }

       */
    /**
     * @taskSnapShot to show current progress status of file being uploading
     *//*


    fun getUploadTaskProgress(taskSnapshot: UploadTask.TaskSnapshot): Int {

        val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount

        return progress.toInt()
    }
//
//    fun testFunction(void: Void) {
//
//    }
//
//    fun void(): Void{
//        return Any() as Void
//    }

    */
    /**
     * @storageRef                 StorageReference Firebase
     *@deleteStorageResult  call back for result
     *//*

    fun deleteStorageFile(storageRef: StorageReference, deleteStorageResult: DeleteStorageResult) {

       // testFunction(void())

        storageRef.delete().addOnSuccessListener {
            deleteStorageResult.onSuccess()
        }.addOnFailureListener { exception ->
            deleteStorageResult.onFailure(exception)

        }
    }
*/ //todo end of comment


//    // Create file metadata including the content type
//    val metadata = StorageMetadata.Builder()
//            .setContentType("audio/mpeg")
//            .build()


//
//    fun uploadAudio(uri: Uri, filePath: StorageReference, urlAudioCallInterface: FireBaseStorageResult) {
//        var filePath = filePath
//
//
////        this.firebaseAudioUrlCallInterface = urlAudioCallInterface
//
//        //progressDialog.setMessage(context.getString(R.string.loading))
//        //progressDialog.show()
//

//
//        filePath = mFStorage.child("audio").child(getRandomId() + ".mp3")
//
//        filePath.putFile(galleryUri).addOnSuccessListener { taskSnapshot ->
//            //progressDialog.dismiss()
//            val url = taskSnapshot.getDownloadUrl().toString()
//            //firebaseAudioUrlCallInterface.onFirebaseCallComplete(url)
//        }.addOnFailureListener { exception ->
//           // progressDialog.dismiss()
//            //firebaseAudioUrlCallInterface.onFirebaseCallFailure(exception)
//
//            //Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
//        }.addOnProgressListener { taskSnapshot ->
//            //displaying the upload progress
//            val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount
//           // progressDialog.setMessage("Uploaded " + progress.toInt() + "%...")
//        }
//
//    }


}