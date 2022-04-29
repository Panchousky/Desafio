package com.example.desafio.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {


    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }


}