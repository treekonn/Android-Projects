package by.yakivan.vkfriends.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import by.yakivan.vkfriends.R
import by.yakivan.vkfriends.models.FriendModel
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class FriendsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mSourceList: ArrayList<FriendModel> = ArrayList()
    var mFriendsList: ArrayList<FriendModel> = ArrayList()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val itemView = layoutInflater.inflate(R.layout.cell_friend, p0, false)

        return FriendsViewHolder(itemView = itemView)
    }

    override fun getItemCount(): Int {
        return mFriendsList.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        if (p0 is FriendsViewHolder) {
            p0.bind(mFriendsList[p1])
        }
    }

    fun setupFriends(friendsList: ArrayList<FriendModel>) {
        mSourceList.clear()
        mSourceList.addAll(friendsList)
        filter("")
    }

    fun filter(query: String) {
        mFriendsList.clear()
        mSourceList.forEach { it ->
            if (it.name.contains(query, ignoreCase = false)
                || it.surname.contains(query, ignoreCase = false)
            ) {
                mFriendsList.add(it)
            } else {
                it.city?.let { city ->
                    if (city.contains(query, ignoreCase = false)) {
                        mFriendsList.add(it)
                    }
                }
            }
        }
        notifyDataSetChanged()
    }

    class FriendsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var mCivAvatar: CircleImageView = itemView.findViewById(R.id.friend_civ_avatar)
        private var mTxtUsername: TextView = itemView.findViewById(R.id.friend_txt_username)
        private var mTxtCity: TextView = itemView.findViewById(R.id.friend_txt_city)
        private var mImgOnline: View = itemView.findViewById(R.id.friend_img_online)


        fun bind(friendModel: FriendModel) {
            friendModel.avatar?.let { url ->
                Picasso.with(itemView.context)
                    .load(url)
                    .into(mCivAvatar)
            }

            mTxtUsername.text = "${friendModel.name} ${friendModel.surname}"

            mTxtCity.text = friendModel.city

//            friendModel.city?.let { city -> mTxtCity.text = city }
//            friendModel.city?.let { mTxtCity.text = it }

            if (friendModel.isOnline) {
                mImgOnline.visibility = View.VISIBLE
            } else {
                mImgOnline.visibility = View.GONE
            }
        }
    }
}
