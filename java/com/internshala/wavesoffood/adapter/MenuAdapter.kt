package com.internshala.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.internshala.wavesoffood.databinding.MenuitemBinding

class MenuAdapter(private val menuItems:MutableList<String>, private val menuItemPrice:MutableList<String>, private val menuImage: MutableList<Int>):RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding=MenuitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }



    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int =menuItems.size
    inner class MenuViewHolder (private val binding:MenuitemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
            binding.apply {
                menufoodname.text=menuItems[position]
                menufoodprice.text=menuItemPrice[position]
                menufoodimage.setImageResource(menuImage[position])
            }
        }

    }
}