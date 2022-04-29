package com.example.desafio.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio.databinding.PullRequestFragmentBinding
import com.example.desafio.ui.view.adapters.PullRequestRvAdapter
import com.example.desafio.ui.viewmodel.PullRequestViewModel

class PullRequestFragment: Fragment() {

    private val binding by lazy { PullRequestFragmentBinding.inflate(layoutInflater) }
    private val pullRequestAdapter by lazy { PullRequestRvAdapter(onClickItem = PullRequestManager()) }
    private val pullRequestViewModel: PullRequestViewModel by viewModels()

    companion object {
        fun newInstance() = PullRequestFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        getAndSetDataByViewModel()
        initAdapter()

    }

    private fun getAndSetDataByViewModel() {
        pullRequestViewModel.pullModel.observe(viewLifecycleOwner, Observer {

            if (it.isNotEmpty()) {
                pullRequestAdapter.setListPullRequest(it)
            } else {
                Toast.makeText(this.context, "La lista está vacia", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initData() {
        val args = this.arguments
        val name = args?.get("full_name")
        val login = args?.get("owner")

        if (name != null || login != null) {
            pullRequestViewModel.getPullRequestList(login.toString(), name.toString())
        }


    }

    private fun initAdapter() {

        with(binding.recyclerviewrp){
            layoutManager = LinearLayoutManager(this.context)
            adapter = pullRequestAdapter
        }

    }

    inner class PullRequestManager : PullRequestRvAdapter.pullItemClick {
        override fun pullClick() {
           //to do
        }

    }
}