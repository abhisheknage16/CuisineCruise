
package com.internshala.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.internshala.wavesoffood.databinding.ActivityLocationBinding
import com.internshala.wavesoffood.databinding.ActivityLoginBinding

class LocationActivity : AppCompatActivity() {

    private val binding: ActivityLocationBinding by lazy{
        ActivityLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val locationlist= arrayOf("Pune","Mumbai","Nashik","PCMC","Satara")
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,locationlist)
        val autoCompleteTextView=binding.locationlist
        autoCompleteTextView.setAdapter(adapter)
    }
}