package com.nocholla.recyclerview.dagger.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nocholla.recyclerview.dagger.R
import com.nocholla.recyclerview.dagger.adapter.RecyclerViewAdapter

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.ClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun launchIntent(filmName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
