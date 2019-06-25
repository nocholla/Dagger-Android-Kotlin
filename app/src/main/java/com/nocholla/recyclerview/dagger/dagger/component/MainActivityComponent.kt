package com.nocholla.recyclerview.dagger.dagger.component

import android.content.Context
import com.nocholla.recyclerview.dagger.dagger.module.AdapterModule
import com.nocholla.recyclerview.dagger.dagger.qualifier.ActivityContext
import com.nocholla.recyclerview.dagger.dagger.scopes.ActivityScope
import com.nocholla.recyclerview.dagger.ui.MainActivity
import dagger.Component

@ActivityScope
@Component(modules = [AdapterModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    @get:ActivityContext
    val context: Context

    fun injectMainActivity(mainActivity: MainActivity)
}