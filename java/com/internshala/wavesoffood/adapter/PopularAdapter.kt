package com.internshala.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.internshala.wavesoffood.databinding.PopularBinding

class PopularAdapter(private val items:List<String>,private val price:List<String>,private val image:List<Int>): RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }



    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item=items[position]
        val images=image[position]
        val price1=price[position]
        holder.bind(item,price1,images)
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class PopularViewHolder(private val binding:PopularBinding):RecyclerView.ViewHolder(binding.root) {
        private val imageView=binding.foodimage
        fun bind(item: String,price1:String, images: Int) {
            binding.foodpop.text=item
            binding.price.text=price1
            imageView.setImageResource(images)

        }

    }
}