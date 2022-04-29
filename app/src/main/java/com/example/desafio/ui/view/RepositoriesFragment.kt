package com.example.desafio.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio.R
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
            if (items.isNotEmpty()) {
                repositoriesAdapter.setList(items)
            } else {
                Toast.makeText(this.context, "La lista está vacia", Toast.LENGTH_LONG).show()
            }
        }
    }

    inner class RepositoriesManager : RepositoriesListRvAdapter.onClickItemListener {
        override fun onItemClick(owner: String, full_name: String) {

            /*
            val bundle = Bundle()
            bundle.putString("full_name",full_name)
            bundle.putString("owner",owner)
            */

            val action =  RepositoriesFragmentDirections.actionRepositoriesFragmentToPullRequestFragment(full_name,owner)
            findNavController().navigate(action)

            /*val intent = Intent(this@MainActivity2Fragment, PullRequestActivity::class.java)
            intent.putExtra("login", owner)
            intent.putExtra("name", full_name)
            startActivity(intent)*/
        }

    }
}