package com.example.flickconnect

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.flickconnect.Adapter.AdapterGetPhoto
import com.example.flickconnect.model.photo
import com.example.flickconnect.model.photoApp
import com.example.flickconnect.retrofit.services
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    var listPhoto:ArrayList<photo>  = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
        val recyclerView = findViewById<RecyclerView>(R.id.recy_Data)
        recyclerView.layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter=AdapterGetPhoto(listPhoto,this)
    }
    fun getData(){
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.flickr.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val api = retrofit.create(services::class.java)
        api.getPhoto("flickr.favorites.getList","a0653f7892aa0bfe5cfe2a8ddb7e6fb4","187873899@N08","views,url_sq, url_t, url_s, url_q, url_m, url_n, url_z, url_c, url_l, url_o",1,200,"json",1)
                .enqueue(object : Callback<photoApp> {
                    override fun onFailure(call: Call<photoApp>, t: Throwable) {
                        d("dulieu", t.toString())
                    }
                    override fun onResponse(call: Call<photoApp>, response: Response<photoApp>) {
                        d("abc", response.body()?.photos!!.photo.toString())
                        listPhoto.addAll(response.body()?.photos!!.photo)
                        val recyclerView = findViewById<RecyclerView>(R.id.recy_Data)
                        recyclerView.adapter=AdapterGetPhoto(listPhoto,applicationContext)

                    }

                })
    }
}

