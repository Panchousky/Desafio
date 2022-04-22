package com.example.desafio.ui.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio.data.model.UserModel
import com.example.desafio.databinding.ActivityPullRequestBinding
import com.example.desafio.ui.view.adapters.PullRequestRvAdapter
import com.example.desafio.ui.viewmodel.PullRequestViewModel


class PullRequestActivity : AppCompatActivity(){

    private val pullRequestViewModel: PullRequestViewModel by viewModels()
    private val binding by lazy { ActivityPullRequestBinding.inflate(layoutInflater) }
    private val pullRequestAdapter by lazy { PullRequestRvAdapter(onClickItem = PullRequestManager()) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initData()

        pullRequestViewModel.pullModel.observe(this, Observer {

            if (it.isNotEmpty()) {
                pullRequestAdapter.setListPullRequest(it)
            } else {
                Toast.makeText(this, "La lista está vacia", Toast.LENGTH_LONG).show()
            }
        })
        initAdapter()


    }

    private fun initData() {
        val name = intent.extras!!.getString("name")
        val login = intent.extras!!.getString("login")

        if (name != null || login != null) {
            pullRequestViewModel.getPullRequestList(login.toString(), name.toString())
        }


    }


    private fun initAdapter() {

        with(binding.recyclerviewrp){
            layoutManager = LinearLayoutManager(this@PullRequestActivity)
            adapter = pullRequestAdapter
        }

    }

    inner class PullRequestManager : PullRequestRvAdapter.pullItemClick {
        override fun pullClick() {
            Toast.makeText(this@PullRequestActivity, "Pull Click", Toast.LENGTH_LONG).show()
        }

    }
}