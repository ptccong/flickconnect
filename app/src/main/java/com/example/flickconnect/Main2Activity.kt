package com.example.flickconnect

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main2.*
import java.nio.file.Paths.get


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent = intent
        val src: String = intent.getStringExtra("src")
        val title: String = intent.getStringExtra("title")
        Picasso.with(applicationContext).load(src).into(imgView2)
        tvTitle.text = title
        fab_download.setOnClickListener {
            //saveImg(src)
            Toast.makeText(applicationContext,"Chua kip lam",Toast.LENGTH_LONG).show()
        }

    }
    fun saveImg(urlImg:String){
        val dowload:DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager;
        val uri:Uri =Uri.parse(urlImg)
        val request =DownloadManager.Request(uri)
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
       // Picasso.get().load
    }

    fun back(view: View) {
        finish()
    }


}


