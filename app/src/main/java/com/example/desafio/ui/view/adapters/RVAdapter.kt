package com.example.desafio.ui.view.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafio.data.model.RepositoriesModel
import com.example.desafio.R


class RVAdapter(var userList: List<RepositoriesModel>, private val ctx: Context,
                val RepositoryOnClickListener: OnRepoClickListener
): RecyclerView.Adapter<RVAdapter.MyViewHolder>() {


interface OnRepoClickListener{
    fun onRepoClick(owner: String, full_name: String)
}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val inflater = LayoutInflater.from(parent.context).inflate(R.layout.rvrow,parent,false)

        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val datos: RepositoriesModel = userList[position]
        holder.Tittle.text = datos.name
        holder.Descripcion.text = datos.description
        holder.Fork.text = datos.forks_count
        holder.Star.text = datos.stargazers_count
        holder.Usser.text = datos.userModel.login
        holder.itemView.setOnClickListener{RepositoryOnClickListener.onRepoClick(datos.userModel.login, datos.name)}
       val urlimage = datos.userModel.name
            Glide.with(holder.image)
                .load(urlimage)
                .circleCrop()
                .into(holder.image)

        /*holder.rvView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {


            }

        })*/

        }


        //holder.SobrUsser.text = datos.sobrenombre





    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){


        val Tittle: TextView
        val Descripcion: TextView
        val Fork: TextView
        val Star: TextView
        val Usser: TextView
        val image: ImageView


        //val SobrUsser: TextView

        init {
            Tittle = itemView.findViewById<View>(R.id.Tittle) as TextView
            Descripcion = itemView.findViewById<View>(R.id.Description) as TextView
            Fork = itemView.findViewById<View>(R.id.forks) as TextView
            Star = itemView.findViewById<View>(R.id.stars) as TextView
            Usser = itemView.findViewById<View>(R.id.nmbreusser) as TextView
            image = itemView.findViewById<View>(R.id.usserimage) as ImageView



            //SobrUsser = itemView.findViewById<View>(R.id.sobrenmbreusser) as TextView
        }




    }

}