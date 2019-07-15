package com.nocholla.recyclerview.dagger.ui

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.nocholla.recyclerview.dagger.MyApplication
import com.nocholla.recyclerview.dagger.R
import com.nocholla.recyclerview.dagger.adapter.RecyclerViewAdapter
import com.nocholla.recyclerview.dagger.dagger.component.MainActivityComponent
import com.nocholla.recyclerview.dagger.dagger.module.MainActivityContextModule
import com.nocholla.recyclerview.dagger.dagger.qualifier.ActivityContext
import com.nocholla.recyclerview.dagger.dagger.qualifier.ApplicationContext
import com.nocholla.recyclerview.dagger.model.StarWars
import com.nocholla.recyclerview.dagger.retrofit.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.ClickListener {

    private var recyclerView: RecyclerView? = null
    internal lateinit var mainActivityComponent: MainActivityComponent

    @Inject
    var recyclerViewAdapter: RecyclerViewAdapter? = null

    @Inject
    var apiInterface: APIInterface? = null

    @Inject
    @ApplicationContext
    var mContext: Context? = null

    @Inject
    @ActivityContext
    var activityContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        recyclerView = findViewById(R.id.recyclerView)
//        recyclerView!!.layoutManager = LinearLayoutManager(this@MainActivity)
//
//        val applicationComponent = MyApplication.get(this).getApplicationComponent()
//        mainActivityComponent = DaggerMainActivityComponent.builder()
//            .mainActivityContextModule(MainActivityContextModule(this))
//            .applicationComponent(applicationComponent)
//            .build()
//
//        mainActivityComponent.injectMainActivity(this)
//        recyclerView!!.adapter = recyclerViewAdapter
//
//        // Retrofit
//        apiInterface!!.getPeople("json").enqueue(object : Callback<StarWars> {
//            override fun onResponse(call: Call<StarWars>, response: Response<StarWars>) {
//                populateRecyclerView(response.body()!!.results)
//            }
//
//            override fun onFailure(call: Call<StarWars>, t: Throwable) {
//
//            }
//        })
    }

    private fun populateRecyclerView(response: List<StarWars.People>) {
        recyclerViewAdapter!!.setData(response)
    }

    override fun launchIntent(url: String) {
        Toast.makeText(mContext, "RecyclerView Row selected", Toast.LENGTH_SHORT).show()
        startActivity(Intent(activityContext, DetailActivity::class.java).putExtra("url", url))
    }
}
