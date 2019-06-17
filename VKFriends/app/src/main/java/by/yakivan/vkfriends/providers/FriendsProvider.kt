package by.yakivan.vkfriends.providers

import android.os.Handler
import by.yakivan.vkfriends.models.FriendModel
import by.yakivan.vkfriends.presenters.FriendsPresenter
import by.yakivan.vkfriends.utils.VKUsersRequest
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.exceptions.VKApiExecutionException

class FriendsProvider(var presenter: FriendsPresenter) {
    fun testLoadFriend(hasFriend: Boolean) {
        Handler().postDelayed({
            val friendsList: ArrayList<FriendModel> = ArrayList()
            if (hasFriend) {
                val friend1 = FriendModel(
                    123,
                    "Ivan",
                    "Petrov",
                    "https://pp.userapi.com/c626220/v626220754/302ff/Ah7bXmVh_No.jpg"
                )
                val friend2 = FriendModel(
                    12232,
                    "Jora",
                    "Getra",
                    "https://pp.userapi.com/c638225/v638225761/3929f/lwZm4JSJl6s.jpg"
                )
                val friend3 = FriendModel(
                    342,
                    "Egor",
                    "Ganza",
                    "https://pp.userapi.com/c633117/v633117965/17461/m4p7FABUbgM.jpg"
                )
                friendsList.add(friend1)
                friendsList.add(friend2)
                friendsList.add(friend3)
                friendsList.add(friend1)
                friendsList.add(friend2)
            }
            presenter.friendLoaded(friendsList = friendsList)
        }, 2000)
    }

    fun loadFriends() {
        VK.execute(VKUsersRequest(), object : VKApiCallback<List<FriendModel>> {
            override fun success(result: List<FriendModel>) {
            }

            override fun fail(error: VKApiExecutionException) {
            }
        })
    }
}
