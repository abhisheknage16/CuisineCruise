package com.internshala.wavesoffood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.internshala.wavesoffood.databinding.ActivityLoginBinding
import com.internshala.wavesoffood.databinding.ActivitySigninactivityBinding

class signinactivity : AppCompatActivity() {
    private val binding: ActivitySigninactivityBinding by lazy{
        ActivitySigninactivityBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.logintxt.setOnClickListener{
            val intent= Intent(this,login_activity::class.java)
            startActivity(intent)
        }
    }
}