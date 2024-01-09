package com.example.beritakampus2

import android.content.Context
import android.content.Intent
import android.text.Highlights
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (
    private val ugmList: ArrayList<News>,
    private val context: Context):

    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ugm_item, parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

        val currentitem = ugmList[position]

        holder.Judul.text = currentitem.Judul
        holder.Highlights.text = currentitem.Highlight
        holder.Tanggal.text = currentitem.Tanggal

        Glide.with(context)
            .load(currentitem.Gambar) // Assuming 'imageUrl' is the attribute in News class
            .into(holder.image)

    }

    override fun getItemCount(): Int {
        return ugmList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val Judul : TextView = itemView.findViewById(R.id.tvjudul)
        val Highlights : TextView = itemView.findViewById(R.id.tvhighlight)
        val Tanggal : TextView = itemView.findViewById(R.id.tvtanggal)
        val image : ImageView = itemView.findViewById(R.id.imageview)

    }
}