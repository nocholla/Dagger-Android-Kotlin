package com.nocholla.recyclerview.dagger.dagger.module

import com.nocholla.recyclerview.dagger.adapter.RecyclerViewAdapter
import com.nocholla.recyclerview.dagger.dagger.scopes.ActivityScope
import com.nocholla.recyclerview.dagger.ui.MainActivity
import dagger.Module
import dagger.Provides

@Module(includes = [MainActivityContextModule::class])
class AdapterModule {

    @Provides
    @ActivityScope
    fun getStarWarsPeopleLIst(clickListener: RecyclerViewAdapter.ClickListener): RecyclerViewAdapter {
        return RecyclerViewAdapter(clickListener)
    }

    @Provides
    @ActivityScope
    fun getClickListener(mainActivity: MainActivity): RecyclerViewAdapter.ClickListener {
        return mainActivity
    }
}
