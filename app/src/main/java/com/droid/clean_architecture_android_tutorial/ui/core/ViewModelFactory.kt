package com.droid.clean_architecture_android_tutorial.ui.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 *
 * https://blog.kotlin-academy.com/understanding-dagger-2-multibindings-viewmodel-8418eb372848
 */

/**
 * @author Muhammad Atif
 * @Github AtifAbbAsi19
 */
@Singleton

/**
 * @key creators
 * @provider value
 */
class ViewModelFactory
@Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

/*
   private var creators: Map<Class<out ViewModel>, Provider<ViewModel>>? = null
    @Inject
      constructor(creators: Map<Class<out ViewModel>, Provider<ViewModel>>) {
          this.creators = creators
      }
  */


    /**
     * For building customViewModel classes with argument-passing constructors
     * (e.g. for passing custom data or @Inject annotated constructors),
     * we must provide a class that extends ViewModelProvider.Factory,
     * returning instances of our custom ViewModel into the create() method.
     *
     *
     *
     * So, the first thing we can notice is the constructor of the class, that takes the
     * Map<Class<? extends ViewModel>, Provider<ViewModel>> parameter
     *
     * it is a map that has a Class that extends ViewModel as key, and a Provider of ViewModel
     * (a Dagger 2-specific class that let us provide — and so instantiate — a dependency-injected class) as value
     *
     *  Well, we just said that the create method of our custom ViewModelProvider.Factory expects an instance
     *  of the ViewModel as a return value.
     *  This method takes the type of the ViewModel that was requested from an Activity or
     *  Fragment as a parameter. Pairing this type (our Class object) to something that creates a
     *  ViewModel of the same type, we can, of course, instantiate and return that class to the system.
     *
     * What is that “something” that can give us the ViewModel of a determinate type?
     * The answer is theProvidervalue in the map that Dagger 2 injected us.
     *
     *
     *  Dagger 2 can associate a dependency Provider to a given key, and inject it into a Map.
     *  This is accomplished using the @IntoMap annotation on a method that produces the value we want to associate with a given key.
     *  The key is, on the other hand, specified using a custom annotation that is itself annotated with @MapKey .
     *  Here it is the annotation used for creating a Map with, as key type, a Class<? extends ViewModel> object.
     *
     * https://blog.mindorks.com/creating-custom-annotations-in-android-a855c5b43ed9
     *
     * @Retention(RetentionPolicy.RUNTIME)
     * @MapKey
     * @interface ViewModelKey {
     * Class<? extends ViewModel> value();
     * }
     *
     *
     */


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        /**
         * expects an instance of the ViewModel (modelClass)
         * This method takes the type of the ViewModel that was requested from an Activity or Fragment as a parameter
         */

        var creator = creators.get(modelClass)
        if (creator == null) {
            for (entry in creators.entries) {
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