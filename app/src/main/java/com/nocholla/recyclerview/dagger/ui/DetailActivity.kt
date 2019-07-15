package com.nocholla.recyclerview.dagger.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.nocholla.recyclerview.dagger.MyApplication
import com.nocholla.recyclerview.dagger.R
import com.nocholla.recyclerview.dagger.dagger.component.DetailActivityComponent
import com.nocholla.recyclerview.dagger.dagger.qualifier.ApplicationContext
import com.nocholla.recyclerview.dagger.model.Film
import com.nocholla.recyclerview.dagger.retrofit.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    internal lateinit var detailActivityComponent: DetailActivityComponent

    @Inject
    var apiInterface: APIInterface? = null

    @Inject
    @ApplicationContext
    var mContext: Context? = null

    internal lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

//        textView = findViewById(R.id.textView)
//
//        val url = intent.getStringExtra("url")
//
//        val applicationComponent = MyApplication.get(this).getApplicationComponent()
//        detailActivityComponent = DaggerDetailActivityComponent.builder()
//            .applicationComponent(applicationComponent)
//            .build()
//
//        detailActivityComponent.inject(this)
//
//        apiInterface!!.getFilmData(url, "json").enqueue(object : Callback<Film> {
//            override fun onResponse(call: Call<Film>, response: Response<Film>) {
//                val films = response.body()
//                val text = "Film name:\n" + films!!.title + "\nDirector:\n" + films!!.director
//                textView.text = text
//            }
//
//            override fun onFailure(call: Call<Film>, t: Throwable) {
//
//            }
//        })

    }
}