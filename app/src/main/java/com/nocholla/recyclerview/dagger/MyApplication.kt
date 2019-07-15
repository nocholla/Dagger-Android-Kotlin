package com.nocholla.recyclerview.dagger

import android.app.Activity
import android.app.Application
import com.nocholla.recyclerview.dagger.dagger.component.ApplicationComponent
import com.nocholla.recyclerview.dagger.dagger.module.ContextModule

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
        internal set

    override fun onCreate() {
        super.onCreate()

        //applicationComponent = DaggerApplicationComponent.builder().contextModule(ContextModule(this)).build()
        applicationComponent.injectApplication(this)

    }

    companion object {

        operator fun get(activity: Activity): MyApplication {
            return activity.application as MyApplication
        }
    }
}
