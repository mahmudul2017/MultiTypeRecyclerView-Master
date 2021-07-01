package ltd.apps.multityperecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.multi_recyclerview_view1.view.*
import kotlinx.android.synthetic.main.multi_recyclerview_view1.view.tvUserId
import kotlinx.android.synthetic.main.multi_recyclerview_view1.view.tvUserPost
import kotlinx.android.synthetic.main.multi_recyclerview_view2.view.*
import ltd.apps.multityperecyclerview.R
import ltd.apps.multityperecyclerview.model.UserModel

class MultiRecyclerAdapter(private var userList: ArrayList<UserModel>, private val onItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    override fun getItemViewType(position: Int): Int {
        if (userList[position].userId % 2 == 0) {
            return VIEW_TYPE_ONE
        } else {
            return VIEW_TYPE_TWO
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 1) {
            return View1ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.multi_recyclerview_view1, parent, false))
            //val view = LayoutInflater.from(parent.context).inflate(R.layout.multi_recyclerview_view1, parent, false)
            //return RecyclerView.ViewHolder(view)
        } else {
            return View2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.multi_recyclerview_view2, parent, false))
        }
    }

    override fun getItemCount() = userList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var post = userList[position]

        when (holder.itemViewType) {
            VIEW_TYPE_ONE -> (holder as View1ViewHolder).bind(position)
            VIEW_TYPE_TWO -> (holder as View2ViewHolder).bind(position)
        }
        
        /*holder.itemView.tv_userId.text = post.id.toString()
        holder.itemView.tv_userTitle.text = post.title
        holder.itemView.tv_userBody.text = post.body*/

        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(post)
        }
    }

    private inner class View1ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        //var message: TextView = itemView.findViewById(R.id.textView)
        fun bind(position: Int) {
            val recyclerViewModel = userList[position]
            itemView.tvUserId.text = recyclerViewModel.userId.toString()
            itemView.tvUserPost.text = recyclerViewModel.userPost
        }
    }

    private inner class View2ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        //var message: TextView = itemView.findViewById(R.id.textView)
        fun bind(position: Int) {
            val recyclerViewModel = userList[position]
            itemView.tvUserId.text = recyclerViewModel.userId.toString()
            itemView.tvUserPost.text = recyclerViewModel.userPost
            itemView.tvUserName.text = recyclerViewModel.userName
        }
    }
    //class MultiTypeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    interface OnItemClickListener {
        fun onItemClick(user: UserModel?)
    }
}