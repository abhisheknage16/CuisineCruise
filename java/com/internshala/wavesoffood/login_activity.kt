package com.internshala.wavesoffood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.internshala.wavesoffood.databinding.ActivityLoginBinding
import com.internshala.wavesoffood.databinding.ActivityStartBinding

class login_activity : AppCompatActivity() {
    private val binding:ActivityLoginBinding by lazy{
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.signintxt.setOnClickListener{
            val intent=Intent(this,signinactivity::class.java)
            startActivity(intent)
        }
        binding.textView10.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}