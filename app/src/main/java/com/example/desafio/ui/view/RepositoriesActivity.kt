package com.example.desafio.ui.view

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio.data.model.RepositoriesModel
import com.example.desafio.databinding.ActivityMainBinding
import com.example.desafio.ui.view.adapters.RepositoriesListRvAdapter
import com.example.desafio.ui.viewmodel.RepositoriesViewModel

class RepositoriesActivity : AppCompatActivity(), RepositoriesListRvAdapter.OnRepoClickListener {

    private val repositoriesViewModel: RepositoriesViewModel by viewModels()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mAdapter: RepositoriesListRvAdapter by lazy { mAdapter }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        repositoriesViewModel.repoModel.observe(this) { items ->

            if (items.isNotEmpty()){
                mAdapter.setList(items)
            }else{
                Toast.makeText(this,"La lista está vacia",Toast.LENGTH_LONG).show()
            }

        }
        initAdapter()

    }

    private fun initAdapter() {
        with(binding.recyclerview) {
            layoutManager = LinearLayoutManager(this@RepositoriesActivity)
            adapter = mAdapter
        }

    }


    override fun onRepoClick(owner: String, full_name: String) {
        val intent = Intent(this, PullRequestActivity::class.java)
        intent.putExtra("login", owner)
        intent.putExtra("name", full_name)
        startActivity(intent)
    }
}