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
import com.example.desafio.ui.view.PullRequestActivity
import com.example.desafio.ui.view.PullRequestFragment

class PullRequestRvAdapter(
    private val onClickItem: PullRequestFragment.PullRequestManager
) :
    RecyclerView.Adapter<PullRequestRvAdapter.MyViewHolder>() {

    private val listPullRequest = mutableListOf<PullRequestModel>()

    interface pullItemClick {
        fun pullClick()
    }

    fun setListPullRequest(items: List<PullRequestModel>){
        listPullRequest.clear()
        listPullRequest.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.pulrequestrow, parent, false)

        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.render(listPullRequest[position])
        holder.itemView.setOnClickListener {
            onClickItem.pullClick()
        }

    }

    override fun getItemCount(): Int {
        return listPullRequest.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tittle: TextView by lazy { view.findViewById(R.id.Tittlerp) }
        private val description: TextView by lazy { view.findViewById(R.id.Descriptionrp) }
        private val user: TextView by lazy { view.findViewById(R.id.nmbreusserrp) }
        private val image: ImageView by lazy { view.findViewById(R.id.usserimagerp) }
        private val sobrUser: TextView by lazy { view.findViewById(R.id.sobrenmbreusserrp) }

        fun render(pullRequestModel: PullRequestModel) {

            tittle.text = pullRequestModel.title
            description.text = pullRequestModel.body
            user.text = pullRequestModel.userModel.login
            sobrUser.text = pullRequestModel.userModel.login
            Glide.with(image)
                .load(pullRequestModel.userModel.name)
                .circleCrop()
                .into(image)
        }
    }

}
