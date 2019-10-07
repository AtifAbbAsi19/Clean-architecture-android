package com.hedwig.ecure.network.firebase.storage

import java.lang.Exception


/**
 * @author Muhammad Atif Arif
 * @Github atifabbasi19
 */

interface DeleteStorageResult {

    fun onSuccess()
    fun onFailure(exception: Exception)

}