package com.example.desafio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(),RVAdapter.OnRepoClickListener {
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RVAdapter? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    var item: ArrayList<RecyclerData> = ArrayList()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



       searchBy()

        //initRecView(item)


    }


    fun crearData(): ArrayList<RecyclerData> {


/*
        item.add(RecyclerData("TITULO1", "DESCRIPCION CORTA1", "300", "300", "NOMBRE1" ))
        item.add(RecyclerData("TITULO2", "DESCRIPCION CORTA2", "300", "300", "NOMBRE2" ))
        item.add(RecyclerData("TITULO3", "DESCRIPCION CORTA3", "300", "500", "NOMBRE3" ))
        item.add(RecyclerData("TITULO4", "DESCRIPCION CORTA4", "300", "500", "NOMBRE4" ))
        item.add(RecyclerData("TITULO5", "DESCRIPCION CORTA5", "300", "500", "NOMBRE5" ))
        item.add(RecyclerData("TITULO6", "DESCRIPCION CORTA6", "300", "500", "NOMBRE6" ))
        item.add(RecyclerData("TITULO7", "DESCRIPCION CORTA7", "300", "500", "NOMBRE7" ))
        item.add(RecyclerData("TITULO7", "DESCRIPCION CORTA7", "300", "500", "NOMBRE7" ))
        item.add(RecyclerData("TITULO7", "DESCRIPCION CORTA7", "300", "500", "NOMBRE7" ))
        item.add(RecyclerData("TITULO7", "DESCRIPCION CORTA7", "300", "500", "NOMBRE7" ))
        item.add(RecyclerData("TITULO7", "DESCRIPCION CORTA7", "300", "500", "NOMBRE7" ))
        item.add(RecyclerData("TITULO7", "DESCRIPCION CORTA7", "300", "500", "NOMBRE7" ))
        item.add(RecyclerData("TITULO7", "DESCRIPCION CORTA7", "300", "500", "NOMBRE7" ))
        */



        return item
    }

    private fun getRetrofit():Retrofit{

        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")//Java&sort=stars
            .addConverterFactory(GsonConverterFactory.create())

            .build()

    }

    private fun searchBy() {

        val response = getRetrofit().create(Interface::class.java).getDataFromAPI()
        var list: ArrayList<RecyclerData> = ArrayList()
         return response.enqueue(object:Callback<RecyclerList>{
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
               // if (response.body()!!.items.isNotEmpty()){

                list = response.body()!!.items
                mRecyclerView = findViewById(R.id.recyclerview)
                mRecyclerView!!.setHasFixedSize(true)
                mLayoutManager = LinearLayoutManager(this@MainActivity)
                mAdapter = RVAdapter(list, this@MainActivity,this@MainActivity)

                mRecyclerView!!.layoutManager = mLayoutManager
                mRecyclerView!!.adapter = mAdapter
               // }

            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Error",Toast.LENGTH_SHORT).show()

            }

        })



    }



    override fun onRepoClick(owner: String, full_name: String) {
        val intent = Intent(this, PullRequestActivity::class.java)
        intent.putExtra("login", owner)
        intent.putExtra("name", full_name)
        startActivity(intent)
    }
}