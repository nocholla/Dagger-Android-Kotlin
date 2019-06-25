package com.nocholla.recyclerview.dagger.dagger.component

import android.content.Context
import com.nocholla.recyclerview.dagger.MyApplication
import com.nocholla.recyclerview.dagger.dagger.module.ContextModule
import com.nocholla.recyclerview.dagger.dagger.module.RetrofitModule
import com.nocholla.recyclerview.dagger.dagger.qualifier.ApplicationContext
import com.nocholla.recyclerview.dagger.dagger.scopes.ApplicationScope
import com.nocholla.recyclerview.dagger.retrofit.APIInterface
import dagger.Component

@ApplicationScope
@Component(modules = [ContextModule::class, RetrofitModule::class])
interface ApplicationComponent {

    val apiInterface: APIInterface

    @get:ApplicationContext
    val context: Context

    fun injectApplication(myApplication: MyApplication)
}