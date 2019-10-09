package com.droid.clean_architecture_android_tutorial.ui.activities.main_activity

import androidx.lifecycle.ViewModel
import com.droid.clean_architecture_android_tutorial.network.retrofit.RequestApi
import javax.inject.Inject

/**
 * @author Muhammad Atif
 * @Github AtifAbbAsi19
 */
class MainActivityViewModel( repository: RequestApi) : ViewModel() {

//    @Inject
   public var requestApi: RequestApi = repository


}