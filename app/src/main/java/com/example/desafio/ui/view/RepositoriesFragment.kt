package com.example.desafio.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio.data.model.LiveDataModels
import com.example.desafio.data.model.RepositoriesModel
import com.example.desafio.databinding.RepositoriesFragmentBinding
import com.example.desafio.ui.view.adapters.RepositoriesListRvAdapter
import com.example.desafio.ui.viewmodel.RepositoriesViewModel


class RepositoriesFragment : Fragment() {


    private val repositoriesViewModel by lazy { ViewModelProvider(this)[RepositoriesViewModel::class.java] }
    private val binding by lazy { RepositoriesFragmentBinding.inflate(layoutInflater) }
    private val repositoriesAdapter by lazy { RepositoriesListRvAdapter(onClickItem = RepositoriesManager()) }

    companion object {
        fun newInstance() = RepositoriesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAndSetDataByViewModel()
        initAdapter()

    }

    private fun initAdapter() {
        with(binding.recyclerview) {
            layoutManager = LinearLayoutManager(this.context)
            adapter = repositoriesAdapter
        }
    }

    private fun getAndSetDataByViewModel() {
        repositoriesViewModel.getRepositoriesList()
        repositoriesViewModel.repoModel.observe(viewLifecycleOwner) { items ->

            when (items) {
                is LiveDataModels.Result.OnLoading -> onLoading()
                is LiveDataModels.Result.OnSuccess -> onSuccess(items.value)
                is LiveDataModels.Result.OnError -> onError()
            }
        }
    }

    private fun onError() {

    }

    private fun onSuccess(list: List<RepositoriesModel>) {
        if (list.isNotEmpty()) {
            binding.repositoriesProgressBar.isVisible = false
            repositoriesAdapter.setList(list)
        } else {
            binding.repositoriesProgressBar.isVisible = false
            Toast.makeText(this.context, "La lista está vacia", Toast.LENGTH_LONG).show()
        }

    }


    private fun onLoading() {

    }


    inner class RepositoriesManager : RepositoriesListRvAdapter.onClickItemListener {
        override fun onItemClick(owner: String, full_name: String) {

            /*
            val bundle = Bundle()
            bundle.putString("full_name",full_name)
            bundle.putString("owner",owner)
            */

            val action =
                RepositoriesFragmentDirections.actionRepositoriesFragmentToPullRequestFragment(
                    full_name,
                    owner
                )
            findNavController().navigate(action)

            /*val intent = Intent(this@MainActivity2Fragment, PullRequestActivity::class.java)
            intent.putExtra("login", owner)
            intent.putExtra("name", full_name)
            startActivity(intent)*/
        }

    }
}