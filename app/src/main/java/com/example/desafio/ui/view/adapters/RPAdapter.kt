package com.example.desafio.ui.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafio.data.model.UserModel
import com.example.desafio.data.model.PullRequestModel
import com.example.desafio.R

class RPAdapter(var pullList: List<PullRequestModel>, private val ctx: Context,
                val PullOnClickListener: OnPullClickListener
): RecyclerView.Adapter<RPAdapter.MyViewHolder>() {

    interface OnPullClickListener{
        fun onRepoClick(userModel: UserModel)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.pulrequestrow,parent,false)

        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val datos: PullRequestModel = pullList[position]
        holder.Tittle.text = datos.title
        holder.Descripcion.text = datos.body
        holder.Usser.text = datos.userModel.login
        holder.SobrUsser.text = datos.userModel.login

        val urlimage = datos.userModel.name
        Glide.with(holder.image)
            .load(urlimage)
            .circleCrop()
            .into(holder.image)
       /* holder.Tittle.text = datos.full_name
        holder.Descripcion.text = datos.description
        holder.Fork.text = datos.forks_count
        holder.Star.text = datos.stargazers_count
        holder.Usser.text = datos.name
        holder.rvView.setOnClickListener{PullOnClickListener.onRepoClick(datos.owner)}
        val urlimage = datos.owner.name
        Glide.with(holder.image)
            .load(urlimage)
            .circleCrop()
            */



    }




    override fun getItemCount(): Int {
        return pullList.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){


        val Tittle: TextView
        val Descripcion: TextView
        val Usser: TextView
        val image: ImageView
        val SobrUsser: TextView

        init {
            Tittle = itemView.findViewById<View>(R.id.Tittlerp) as TextView
            Descripcion = itemView.findViewById<View>(R.id.Descriptionrp) as TextView
            Usser = itemView.findViewById<View>(R.id.nmbreusserrp) as TextView
            image = itemView.findViewById<View>(R.id.usserimagerp) as ImageView
            SobrUsser = itemView.findViewById<View>(R.id.sobrenmbreusserrp) as TextView
        }




    }

}
