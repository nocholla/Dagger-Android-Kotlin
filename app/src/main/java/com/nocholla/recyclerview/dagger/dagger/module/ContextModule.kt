package com.nocholla.recyclerview.dagger.dagger.module

import android.content.Context
import com.nocholla.recyclerview.dagger.dagger.qualifier.ApplicationContext
import com.nocholla.recyclerview.dagger.dagger.scopes.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ContextModule(private val context: Context) {

    @Provides
    @ApplicationScope
    @ApplicationContext
    fun provideContext(): Context {
        return context
    }
}