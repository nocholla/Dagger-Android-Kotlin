package com.nocholla.recyclerview.dagger.dagger.module

import android.content.Context
import com.nocholla.recyclerview.dagger.dagger.qualifier.ActivityContext
import com.nocholla.recyclerview.dagger.dagger.scopes.ActivityScope
import com.nocholla.recyclerview.dagger.ui.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityContextModule(private val mainActivity: MainActivity) {

    var context: Context = mainActivity

    @Provides
    @ActivityScope
    fun providesMainActivity(): MainActivity {
        return mainActivity
    }

    @Provides
    @ActivityScope
    @ActivityContext
    fun provideContext(): Context {
        return context
    }

}
