package com.droid.clean_architecture_android_tutorial.di.annotations

import androidx.lifecycle.ViewModel
import dagger.MapKey
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.RetentionPolicy.RUNTIME
import javax.inject.Scope
import kotlin.reflect.KClass

//@Retention(RUNTIME)
//@Scope
//@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

