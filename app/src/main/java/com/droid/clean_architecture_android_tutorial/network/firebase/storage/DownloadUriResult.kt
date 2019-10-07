package com.hedwig.ecure.network.firebase.storage

import android.net.Uri
import java.lang.Exception


/**
 * @author Muhammad Atif Arif
 * @Github atifabbasi19
 */

interface DownloadUriResult {

    fun onSuccess(uri: Uri)
    fun onFailure(exception: Exception)

}