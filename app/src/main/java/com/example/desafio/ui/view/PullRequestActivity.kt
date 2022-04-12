package com.example.desafio.ui.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.desafio.data.model.UserModel

import com.example.desafio.databinding.ActivityPullRequestBinding
import com.example.desafio.ui.view.adapters.RPAdapter

import com.example.desafio.ui.viewmodel.PullRequestViewModel


class PullRequestActivity : AppCompatActivity(), RPAdapter.OnPullClickListener {

    private val pullRequestViewModel: PullRequestViewModel by viewModels()
    private lateinit var binding: ActivityPullRequestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPullRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        initRecyclerView(this)
        // searchByRP()


    }

    private fun initData() {
        val name = intent.extras!!.getString("name")
        val login = intent.extras!!.getString("login")

        if (name != null || login != null) {
            pullRequestViewModel.onStart(login.toString(), name.toString())
        }


    }

    private fun initRecyclerView(context: Context) {

        pullRequestViewModel.pullModel.observe(this, Observer {
            val mRecyclerView = binding.recyclerviewrp
            val mLayoutManager = LinearLayoutManager(this)
            val mAdapter = RPAdapter(it, this, this)
            mRecyclerView!!.layoutManager = mLayoutManager
            mRecyclerView.adapter = mAdapter
        })


        /*private fun searchByRP() {

                val name = intent.extras!!.getString("name")
                val login = intent.extras!!.getString("login")


            val response = getRetrofit().create(RetrofitInstance::class.java).getPulls("repos/$login/$name/pulls")
            var list: ArrayList<PullRequestModel> = ArrayList()

            return response.enqueue(object : Callback<RepoPullsList>{
                override fun onResponse(call: Call<RepoPullsList>, response: Response<RepoPullsList>) {

                    list = response.body()!!.pulls
                    mRecyclerView = findViewById(R.id.recyclerviewrp)
                    mRecyclerView!!.setHasFixedSize(true)
                    mLayoutManager = LinearLayoutManager(this@PullRequestActivity)
                    mAdapter = RPAdapter(list, this@PullRequestActivity,this@PullRequestActivity)

                    mRecyclerView!!.layoutManager = mLayoutManager
                    mRecyclerView!!.adapter = mAdapter
                }

                override fun onFailure(call: Call<RepoPullsList>, t: Throwable) {
                    Toast.makeText(this@PullRequestActivity,t.message, Toast.LENGTH_LONG).show()
                }


            })

        }*/


    }

    override fun onRepoClick(userModel: UserModel) {
        TODO("Not yet implemented")
    }
}