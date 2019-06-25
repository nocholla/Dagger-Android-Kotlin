package com.nocholla.recyclerview.dagger.dagger.component

import com.nocholla.recyclerview.dagger.dagger.scopes.ActivityScope
import com.nocholla.recyclerview.dagger.ui.DetailActivity
import dagger.Component

@Component(dependencies = [ApplicationComponent::class])
@ActivityScope
interface DetailActivityComponent {

    fun inject(detailActivity: DetailActivity)
}