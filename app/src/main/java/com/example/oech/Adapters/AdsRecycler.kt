package com.example.oech.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.oech.R

class AdsRecycler (val context: Context, val list: ArrayList<adsData>) : RecyclerView.Adapter<AdsRecycler.MyVH>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsRecycler.MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.ads,parent,false)
        return MyVH(root)
    }

    class MyVH(itemView: View) :RecyclerView.ViewHolder(itemView){
        val image:ImageView = itemView.findViewById(R.id.ads)
    }

    override fun onBindViewHolder(holder: AdsRecycler.MyVH, position: Int) {
        holder.image.setImageResource(list[position].image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}