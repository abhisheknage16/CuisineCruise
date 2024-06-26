package com.internshala.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.internshala.wavesoffood.databinding.CartItemBinding

class CartAdapter(private val cartitems:MutableList<String>,private val cartitemprice:MutableList<String>,private var cartimage:MutableList<Int>): RecyclerView.Adapter<CartAdapter.CartViewholder>() {

private val itemqty=IntArray(cartitems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewholder {
        val binding=CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewholder(binding)
    }

    override fun onBindViewHolder(holder: CartViewholder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int =cartitems.size
    inner class CartViewholder(private val binding: CartItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity=itemqty[position]
                cartfoodname.text=cartitems[position]
                cartfoodprice.text=cartitemprice[position]
                cartfoodimage.setImageResource(cartimage[position])
                quantityfood.text=quantity.toString()

                minus.setOnClickListener{
                    decreaseqty(position)


                }
                plus.setOnClickListener{
                    increaseqty(position)

                }
                delete.setOnClickListener{
                    val itempos=adapterPosition
                    if(itempos!=RecyclerView.NO_POSITION){
                        delete(itempos)
                    }


                }


            }

        }
        private fun increaseqty(position: Int){
            if (itemqty[position]<10){
                itemqty[position]++
                binding.quantityfood.text=itemqty[position].toString()
            }
        }
        private fun decreaseqty(position: Int){
            if (itemqty[position]>1){
                itemqty[position]--
                binding.quantityfood.text=itemqty[position].toString()
            }
        }
        private fun delete(position: Int){
            cartitems.removeAt(position)
            cartitemprice.removeAt(position)
            cartimage.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,cartitems.size)
        }

    }
}