package com.internshala.wavesoffood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.internshala.wavesoffood.R
import com.internshala.wavesoffood.adapter.CartAdapter
import com.internshala.wavesoffood.databinding.CartItemBinding
import com.internshala.wavesoffood.databinding.FragmentCartBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCartBinding.inflate(inflater,container,false)

        val cartFoodname= listOf("Chicken Tikka ","Dhokla","Pullav","Idli","Fruit Salad","Pav bhaji")
        val cartFoodPrice= listOf("300","200","400","500","200","250")
        val cartImage= listOf(R.drawable.chick,R.drawable.dhokala,R.drawable.pullav,R.drawable.saleidli,R.drawable.fruit,R.drawable.pb)
        val adapter=CartAdapter(ArrayList(cartFoodname),ArrayList(cartFoodPrice),ArrayList(cartImage))
        binding.RecyclerCart.layoutManager=LinearLayoutManager(requireContext())
        binding.RecyclerCart.adapter=adapter
        return binding.root
    }

    companion object {

    }
}
