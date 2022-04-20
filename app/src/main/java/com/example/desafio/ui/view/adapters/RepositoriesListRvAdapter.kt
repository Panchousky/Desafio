package com.example.desafio.ui.view.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafio.data.model.RepositoriesModel
import com.example.desafio.R


class RepositoriesListRvAdapter(
    private val onRepoClickListener: OnRepoClickListener
) : RecyclerView.Adapter<RepositoriesListRvAdapter.MyViewHolder>() {
private val list = mutableListOf<RepositoriesModel>()

    interface OnRepoClickListener {
        fun onRepoClick(owner: String, full_name: String)
    }

    fun setList(items:List<RepositoriesModel>){
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater.inflate(R.layout.rvrow, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.render(list[position])

        holder.itemView.setOnClickListener {
            onRepoClickListener.onRepoClick(
                list[position].userModel.login,
                list[position].name
            )
        }
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tittle: TextView by lazy { tittle }
        private val description: TextView by lazy { description }
        private val fork: TextView by lazy { fork }
        private val star: TextView by lazy { star }
        private val user: TextView by lazy { user }
        private val image: ImageView by lazy { image }

        fun render(repositoriesModel: RepositoriesModel) {

            tittle.text = repositoriesModel.name
            description.text = repositoriesModel.description
            fork.text = repositoriesModel.forks_count
            star.text = repositoriesModel.stargazers_count
            user.text = repositoriesModel.userModel.login
            Glide.with(image)
                .load(repositoriesModel.userModel.name)
                .circleCrop()
                .into(image)

        }

    }

}