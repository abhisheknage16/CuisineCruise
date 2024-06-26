package com.internshala.wavesoffood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.internshala.wavesoffood.R
import com.internshala.wavesoffood.adapter.MenuAdapter
import com.internshala.wavesoffood.databinding.FragmentSearchBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val ogfoodname = listOf("Palak Paneer", "Paneer Butter Masala", "Butter Garlic Naan", "Pomfret Fry", "Pooran Poli(Ghee)", "Soya Tikki", "Tofu Mix", "Chicken Tikka", "Dhokla", "Pulao", "Idli", "Fruit Salad", "Pav Bhaji")
    private val ogfoodprice = listOf("250", "250", "90", "400", "90", "150", "190", "300", "200", "400", "500", "200", "250")
    private val ogfoodimage = listOf(R.drawable.palakpaneer, R.drawable.paneerbutter, R.drawable.naan, R.drawable.paplet, R.drawable.pooranpoli, R.drawable.soyatikki, R.drawable.tofu, R.drawable.chick, R.drawable.dhokala, R.drawable.pullav, R.drawable.saleidli, R.drawable.fruit, R.drawable.pb)
    private lateinit var adapter: MenuAdapter

    private val filterfoodname = mutableListOf<String>()
    private val filterfoodprice = mutableListOf<String>()
    private val filterfoodimage = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        adapter = MenuAdapter(filterfoodname, filterfoodprice, filterfoodimage)
        binding.menuRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecycler.adapter = adapter

        setupsearchview()

        showallmenu()
        return binding.root
    }

    private fun showallmenu() {
        filterfoodname.clear()
        filterfoodprice.clear()
        filterfoodimage.clear()

        filterfoodname.addAll(ogfoodname)
        filterfoodprice.addAll(ogfoodprice)
        filterfoodimage.addAll(ogfoodimage)

        adapter.notifyDataSetChanged()
    }


    private fun setupsearchview() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filtermenu(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filtermenu(newText)
                return true
            }
        })
    }

    private fun filtermenu(query: String?) {
        filterfoodname.clear()
        filterfoodprice.clear()
        filterfoodimage.clear()

        ogfoodname.forEachIndexed { index, foodName ->
            if (foodName.contains(query.toString(), ignoreCase = true)) {
                filterfoodname.add(foodName)
                filterfoodprice.add(ogfoodprice[index])
                filterfoodimage.add(ogfoodimage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {
    }
}
