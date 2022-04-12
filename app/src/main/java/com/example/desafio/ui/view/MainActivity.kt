package com.example.desafio.ui.view

import android.content.Context
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio.databinding.ActivityMainBinding
import com.example.desafio.ui.view.adapters.RVAdapter
import com.example.desafio.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), RVAdapter.OnRepoClickListener {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.onStart()
        initRecyclerView(this)

    }

    private fun initRecyclerView(context: Context) {

        mainViewModel.repoModel.observe(this, Observer {

            val mRecyclerView = binding.recyclerview
            val mLayoutManager = LinearLayoutManager(this@MainActivity)
            val mAdapter = RVAdapter(it, this@MainActivity, this@MainActivity)
            mRecyclerView!!.layoutManager = mLayoutManager
            mRecyclerView.adapter = mAdapter

        })
    }

      override fun onRepoClick(owner: String, full_name: String) {
          val intent = Intent(this, PullRequestActivity::class.java)
          intent.putExtra("login", owner)
          intent.putExtra("name", full_name)
          startActivity(intent)
      }
}