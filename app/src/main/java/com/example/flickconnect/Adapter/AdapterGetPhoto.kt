package com.example.flickconnect.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flickconnect.Main2Activity
import com.example.flickconnect.R
import com.example.flickconnect.model.photo
import com.squareup.picasso.Picasso

class AdapterGetPhoto(private val listPhoto: ArrayList<photo>, private val context: Context):RecyclerView.Adapter<AdapterGetPhoto.ViewHolder> (){
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imgView = this.itemView.findViewById<ImageView>(R.id.imgView)
        val tvView = this.itemView.findViewById<TextView>(R.id.tvView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_list_main,parent,false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return listPhoto.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val photo = listPhoto[position]
        Picasso.with(context).load(photo.url_l).into(holder.imgView)
        holder.tvView.text=photo.views
        holder.itemView.setOnClickListener {
            val intent = Intent(context,Main2Activity::class.java)
            intent.putExtra("src",photo.url_l)
            intent.putExtra("title",photo.title)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}