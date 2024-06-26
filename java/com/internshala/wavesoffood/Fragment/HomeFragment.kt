package com.internshala.wavesoffood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.internshala.wavesoffood.MenuBottomsheetFragment
import com.internshala.wavesoffood.R
import com.internshala.wavesoffood.adapter.PopularAdapter
import com.internshala.wavesoffood.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false)
        binding.ViewMenu.setOnClickListener{
            val bottomSheetDialog=MenuBottomsheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList=ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.saleburger,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.saleidli,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.salesweet,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.salechina,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.salefrench,ScaleTypes.FIT))
        val imageSlider=binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList,ScaleTypes.FIT)
        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition=imageList[position]
                val itemMessage="Selected Image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }
        })
        val foodName=listOf("Chicken Chilli","Dhokla","Idli","Pav Bhaji","Fruit Salad","Chole Bhature")
        val price= listOf("₹300","₹200","₹100","₹150","₹99","₹80")
        val foodimage= listOf(R.drawable.chick,R.drawable.dhokala,R.drawable.saleidli,R.drawable.pb,R.drawable.fruit,R.drawable.chole)
        val adapter=PopularAdapter(foodName,price,foodimage)
        binding.RecyclerPopular.layoutManager=LinearLayoutManager(requireContext())
        binding.RecyclerPopular.adapter=adapter
    }

    companion object {
    }
}