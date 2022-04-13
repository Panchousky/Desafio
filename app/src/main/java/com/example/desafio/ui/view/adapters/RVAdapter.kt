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


class RVAdapter(
    val repoList: List<RepositoriesModel>, private val ctx: Context,
    val onRepoClickListener: OnRepoClickListener
) : RecyclerView.Adapter<RVAdapter.MyViewHolder>() {


    interface OnRepoClickListener {
        fun onRepoClick(owner: String, full_name: String)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater.inflate(R.layout.rvrow, parent, false))
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.render(repoList[position])

        holder.itemView.setOnClickListener {
            onRepoClickListener.onRepoClick(
                repoList[position].userModel.login,
                repoList[position].name
            )
        }
       /* val datos: RepositoriesModel = userList[position]
        holder.Tittle.text = datos.name
        holder.Descripcion.text = datos.description
        holder.Fork.text = datos.forks_count
        holder.Star.text = datos.stargazers_count
        holder.Usser.text = datos.userModel.login
        holder.itemView.setOnClickListener {
            RepositoryOnClickListener.onRepoClick(
                datos.userModel.login,
                datos.name
            )
        }
        val urlimage = datos.userModel.name
        Glide.with(holder.image)
            .load(urlimage)
            .circleCrop()
            .into(holder.image)*/

    }



    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        fun render(repositoriesModel: RepositoriesModel) {

            val tittle = itemView.findViewById<View>(R.id.Tittle) as TextView
            val descripcion = itemView.findViewById<View>(R.id.Description) as TextView
            val fork = itemView.findViewById<View>(R.id.forks) as TextView
            val star = itemView.findViewById<View>(R.id.stars) as TextView
            val usser = itemView.findViewById<View>(R.id.nmbreusser) as TextView
            val image = itemView.findViewById<View>(R.id.usserimage) as ImageView
           // val rv = itemView.findViewById<View>(R.id.recyclerview) as RecyclerView

            tittle.text = repositoriesModel.name
            descripcion.text = repositoriesModel.description
            fork.text = repositoriesModel.forks_count
            star.text = repositoriesModel.stargazers_count
            usser.text = repositoriesModel.userModel.login
            Glide.with(image)
                .load(repositoriesModel.userModel.name)
                .circleCrop()
                .into(image)


        }




        /*  val Tittle: TextView
          val Descripcion: TextView
          val Fork: TextView
          val Star: TextView
          val Usser: TextView
          val image: ImageView


          init {
              Tittle = itemView.findViewById<View>(R.id.Tittle) as TextView
              Descripcion = itemView.findViewById<View>(R.id.Description) as TextView
              Fork = itemView.findViewById<View>(R.id.forks) as TextView
              Star = itemView.findViewById<View>(R.id.stars) as TextView
              Usser = itemView.findViewById<View>(R.id.nmbreusser) as TextView
              image = itemView.findViewById<View>(R.id.usserimage) as ImageView

          }*/

    }

}