package com.example.desafio.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio.data.model.UserModel
import com.example.desafio.data.model.RepoPullsList
import com.example.desafio.data.model.PullRequestModel
import com.example.desafio.data.source.RetrofitInstance
import com.example.desafio.R
import com.example.desafio.ui.view.adapters.RPAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PullRequestActivity : AppCompatActivity(), RPAdapter.OnPullClickListener {

    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RPAdapter? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_request)


       // searchByRP()


    }




    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")//Java&sort=stars
            .addConverterFactory(GsonConverterFactory.create())

            .build()

    }

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


    override fun onRepoClick(userModel: UserModel) {
        TODO("Not yet implemented")
    }
}