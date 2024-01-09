package com.example.beritakampus2

import android.content.Context
import android.text.Highlights
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterUJB (
    private val ujblist: ArrayList<NewsUJB>,
    private val context: Context):

    RecyclerView.Adapter<AdapterUJB.MyViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterUJB.MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ujb_item, parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: AdapterUJB.MyViewHolder, position: Int) {

        val currentitem = ujblist[position]

        holder.Judul.text = currentitem.Judul
        holder.Highlight.text = currentitem.Highlight
        holder.Tanggal.text = currentitem.Tanggal

        Glide.with(context)
            .load(currentitem.Gambar) // Assuming 'imageUrl' is the attribute in News class
            .into(holder.image)

    }

    override fun getItemCount(): Int {
        return ujblist.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val Judul : TextView = itemView.findViewById(R.id.tvtitle)
        val Highlight : TextView = itemView.findViewById(R.id.tvhigh)
        val Tanggal : TextView = itemView.findViewById(R.id.tvdate)
        val image : ImageView = itemView.findViewById(R.id.imageview)

    }
}