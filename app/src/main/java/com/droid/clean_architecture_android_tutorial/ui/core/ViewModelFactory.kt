package com.droid.clean_architecture_android_tutorial.ui.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


@Singleton
class ViewModelFactory : ViewModelProvider.Factory {

    private var creators: Map<Class<out ViewModel>, Provider<ViewModel>>? = null


    @Inject
     constructor(creators: Map<Class<out ViewModel>, Provider<ViewModel>>) {
       this.creators = creators
    }


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator = creators!!.get(modelClass)
        if (creator == null) {
            for (entry in creators!!.entries) {
                if (modelClass.isAssignableFrom(entry.key)) {
                    creator = entry.value
                    break
                }
            }
        }
        requireNotNull(creator) { "unknown model class $modelClass" }
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }


}