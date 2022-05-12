package com.example.desafio.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.ViewFlipper
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio.R
import com.example.desafio.data.model.LiveDataModels
import com.example.desafio.data.model.PullRequestModel
import com.example.desafio.databinding.PullRequestFragmentBinding
import com.example.desafio.ui.view.adapters.PullRequestRvAdapter
import com.example.desafio.ui.viewmodel.PullRequestViewModel

private const val CONTENT_VIEW = 0
private const val LOADING_VIEW = 1
private const val EMPTY_VIEW = 2
private const val ERROR_VIEW = 3

class PullRequestFragment : Fragment() {

    private val binding by lazy { PullRequestFragmentBinding.inflate(layoutInflater) }
    private val pullRequestAdapter by lazy { PullRequestRvAdapter(onClickItem = PullRequestManager()) }
    private val viewFlipper by lazy { binding.pullRequestViewFlipper }
    private val pullRequestViewModel: PullRequestViewModel by viewModels()
    private val args by navArgs<PullRequestFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        setDataByViewModel()
        initAdapter()

    }

    private fun setDataByViewModel() {
        pullRequestViewModel.pullModel.observe(viewLifecycleOwner) { items ->

            when (items) {
                is LiveDataModels.Result.OnLoading -> onLoading()
                is LiveDataModels.Result.OnSuccess -> onSuccess(items.value)
                is LiveDataModels.Result.OnError -> onError()
            }

        }
    }

    private fun onError() {
        viewFlipper.displayedChild = ERROR_VIEW
    }

    private fun onLoading() {
        viewFlipper.displayedChild = LOADING_VIEW
    }

    private fun onSuccess(list: List<PullRequestModel>) {
        if (list.isNotEmpty()) {
            pullRequestAdapter.setListPullRequest(list)
            viewFlipper.displayedChild = CONTENT_VIEW
        } else {
            viewFlipper.displayedChild = EMPTY_VIEW
        }

    }

    private fun initData() {

        pullRequestViewModel.getPullRequestList(args.repositoriesUser, args.repositoriesTitle)

    }

    private fun initAdapter() {

        with(binding.recyclerviewrp) {
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