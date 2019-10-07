package com.hedwig.ecure.network.firebase.auth

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.text.TextUtils
import android.util.Log
/*  //todo imports code to use Classes
import com.google.android.gms.flags.Singletons
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest*/
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Muhammad Atif Arif
 * @Github atifabbasi19
 */

class FirebaseAuthHelper {

    private var context: Context? = null

/*  //todo Uncomment code to use Classes

    // @Singleton

    object Singleton {
        //  @SuppressLint("StaticFieldLeak")
        var instance: FirebaseAuthHelper? = null

        fun getInstance(context: Context?): FirebaseAuthHelper {
            if (instance == null && context != null) {
                instance = FirebaseAuthHelper()
                instance!!.context = context
            }
            return instance!!
        }//fun get instance ends
    }//object singleton ends here

//    private var instance: FirebaseAuthHelper? = null

    private var mAuth: FirebaseAuth? = null


    init {
        mAuth = FirebaseAuth.getInstance()
    }


//    companion object {
//        fun getInstance(): FirebaseAuthHelper? {
//            val instance: FirebaseAuthHelper = getInstance()!!
//            return instance
//        }
//
//    }


    fun getFirebaseUser(): FirebaseUser? {
        return mAuth!!.currentUser
    }

    */
    /**
     * @param email          user Email
     * @param password       user Password
     * @param context        context
     * @param onTaskComplete response
     *//*



    //method for user login
    fun userLogin(email: String?, password: String?,
                  onTaskComplete: FireBaseOnAuthResultTaskComplete?) {


        if (mAuth != null && email != null && !TextUtils.isEmpty(email) && password != null &&
                !TextUtils.isEmpty(password) && context != null
                && onTaskComplete != null) {

            //logging in the user
            mAuth!!.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener((context as Activity?)!!) { task -> onTaskComplete.onComplete(task) }

        }

    }//end of user login

    fun getCurrentUserId(): String? {
        return mAuth!!.currentUser!!.uid
    }

    fun getCurrentUserEmail(): String? {
        return mAuth!!.currentUser!!.email
    }


    fun getRandomId(): String {

        return UUID.randomUUID().toString()
    }


    fun registerUser(email: String?, password: String?,
                     onTaskComplete: FireBaseOnAuthResultTaskComplete?) {


        ///http://stackoverflow.com/questions/40404567/how-to-send-verification-email-with-firebase
        //https://firebase.googleblog.com/2017/02/email-verification-in-firebase-auth.html


        if (mAuth != null && email != null && password != null &&
                context != null && onTaskComplete != null) {


            //creating a new user
            mAuth!!.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener((context as Activity?)!!)
                    { task -> onTaskComplete.onComplete(task) }

        }//end of if

    }


    fun updateUserProfile(userProfileChangeRequest: UserProfileChangeRequest?) {


        if (userProfileChangeRequest != null) {
            val user = mAuth!!.currentUser

            user!!.updateProfile(userProfileChangeRequest).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("TAG", "User profile updated.")
                }
            }
        }

//                UserProfileChangeRequest profileUpdatex = new UserProfileChangeRequest.Builder()
//                        .setDisplayName("Atif AbbAsi")
//                        .setPhotoUri(myUri)
//                        .build();


    }


    fun getDateTime(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
        val date = Date()
        return dateFormat.format(date)
    }


    */
    /**
     * @param email       current user's email
     * @param oldPassword old password to relogin , in Firebase you cant easily change password,
     * first you have to re-login and then you have to update current user's password.
     * @param newPassword new password to update old password
     *
     * @source https://stackoverflow.com/questions/39866086/change-password-with-firebase-for-android
     *//*


    fun updateAuthUserPassword(email: String, oldPassword: String,
                               newPassword: String) {

        val user = FirebaseAuth.getInstance().currentUser

        // Get auth credentials from the user for re-authentication. The example below shows
        // email and password credentials but there are multiple possible providers,
        // such as GoogleAuthProvider or FacebookAuthProvider.
        val credential = EmailAuthProvider
                .getCredential(email, oldPassword)

        // Prompt the user to re-provide their sign-in credentials
        user!!.reauthenticate(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        user.updatePassword(newPassword)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        //  Log.d(TAG, "Password updated")
                                    } else {
                                        //Log.d(TAG, "Error password not updated")
                                    }
                                }
                    } else {
                        //    Log.d(TAG, "Error auth failed")
                    }
                }

    }

*/

}