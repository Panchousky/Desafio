package com.example.desafio.ui.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio.data.model.UserModel
import com.example.desafio.databinding.ActivityPullRequestBinding
import com.example.desafio.ui.view.adapters.PullRequestRvAdapter
import com.example.desafio.ui.viewmodel.PullRequestViewModel


class PullRequestActivity : AppCompatActivity(), PullRequestRvAdapter.OnPullClickListener {

    private val pullRequestViewModel: PullRequestViewModel by viewModels()
    private lateinit var binding: ActivityPullRequestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPullRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        initRecyclerView()


    }

    private fun initData() {
        val name = intent.extras!!.getString("name")
        val login = intent.extras!!.getString("login")

        if (name != null || login != null) {
            pullRequestViewModel.getPullRequestList(login.toString(), name.toString())
        }


    }

    private fun initRecyclerView() {

        pullRequestViewModel.pullModel.observe(this, Observer {
            val mRecyclerView = binding.recyclerviewrp
            val mLayoutManager = LinearLayoutManager(this)
            val mAdapter = PullRequestRvAdapter(it)
            mRecyclerView.layoutManager = mLayoutManager
            mRecyclerView.adapter = mAdapter
        })


    }

    override fun onRepoClick(userModel: UserModel) {
        //Action when clicks in any pull request of the list.
    }
}