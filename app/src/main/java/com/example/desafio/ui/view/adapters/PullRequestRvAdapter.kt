package com.example.desafio.ui.view.adapters

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

class PullRequestRvAdapter(private val pullList: List<PullRequestModel>) :
    RecyclerView.Adapter<PullRequestRvAdapter.MyViewHolder>() {


    interface OnPullClickListener {
        fun onRepoClick(userModel: UserModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.pulrequestrow, parent, false)

        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.render(pullList[position])


    }

    override fun getItemCount(): Int {
        return pullList.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tittle: TextView by lazy { tittle }
        private val description: TextView by lazy { description }
        private val user: TextView by lazy { user }
        private val image: ImageView by lazy { image }
        private val sobrUser: TextView by lazy { sobrUser }

        fun render(pullRequestModel: PullRequestModel) {

            tittle.text = pullRequestModel.title
            description.text = pullRequestModel.body
            user.text = pullRequestModel.userModel.login
            sobrUser.text = pullRequestModel.title
            Glide.with(image)
                .load(pullRequestModel.userModel.name)
                .circleCrop()
                .into(image)
        }
    }

}
