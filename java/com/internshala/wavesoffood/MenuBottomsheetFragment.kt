package com.internshala.wavesoffood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.internshala.wavesoffood.adapter.MenuAdapter
import com.internshala.wavesoffood.databinding.FragmentMenuBottomsheetBinding

class MenuBottomsheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding:FragmentMenuBottomsheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentMenuBottomsheetBinding.inflate(inflater,container,false)

        binding.buttonback.setOnClickListener{
            dismiss()
        }
        val menufoodname= listOf("Palak Paneer","Paneer Butter Masala","Butter Garlic Naan","Pomfert Fry","Pooran Poli(Ghee)","Soya Tikki","Tofu Mix","Chicken Tikka ","Dhokla","Pullav","Idli","Fruit Salad","Pav bhaji")
        val menufoodprice= listOf("250","250","90","400","90","150","190","300","200","400","500","200","250")
        val menufoodimage= listOf(R.drawable.palakpaneer,R.drawable.paneerbutter,R.drawable.naan,R.drawable.paplet,R.drawable.pooranpoli,R.drawable.soyatikki,R.drawable.tofu,R.drawable.chick,R.drawable.dhokala,R.drawable.pullav,R.drawable.saleidli,R.drawable.fruit,R.drawable.pb)
        val adapter= MenuAdapter(ArrayList(menufoodname),ArrayList(menufoodprice),ArrayList(menufoodimage))
        binding.menuRecycler.layoutManager= LinearLayoutManager(requireContext())
        binding.menuRecycler.adapter=adapter

        return binding.root
    }

    companion object {

    }
}