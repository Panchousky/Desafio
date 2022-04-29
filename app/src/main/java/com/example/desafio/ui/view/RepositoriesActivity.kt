package com.example.desafio.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.desafio.R
import com.example.desafio.databinding.ActivityMainBinding
import com.example.desafio.ui.viewmodel.RepositoriesViewModel

class RepositoriesActivity : AppCompatActivity() {

    private val repositoriesViewModel: RepositoriesViewModel by viewModels()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
   // private val repositoriesAdapter by lazy { RepositoriesListRvAdapter(onClickItem = RepositoriesManager()) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, RepositoriesFragment.newInstance())
                .commitNow()
        }



    }




}