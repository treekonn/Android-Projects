package by.yakivan.vkfriends.providers

import android.os.Handler
import by.yakivan.vkfriends.models.FriendModel
import by.yakivan.vkfriends.presenters.FriendsPresenter

class FriendsProvider(var presenter: FriendsPresenter) {
    fun testLoadFriend(hasFriend: Boolean) {

        Handler().postDelayed({
            val friendsList: ArrayList<FriendModel> = ArrayList()
            if (hasFriend) {
                val friend1 = FriendModel("Ivan", "Petrov", null,
                        "https://pp.userapi.com/c626220/v626220754/302ff/Ah7bXmVh_No.jpg", true)
                val friend2 = FriendModel("Jora", "Getra", "Borisov",
                        "https://pp.userapi.com/c638225/v638225761/3929f/lwZm4JSJl6s.jpg", false)
                val friend3 = FriendModel("Egor", "Ganza", "Kiev",
                        "https://pp.userapi.com/c633117/v633117965/17461/m4p7FABUbgM.jpg", true)
                friendsList.add(friend1)
                friendsList.add(friend2)
                friendsList.add(friend3)
                friendsList.add(friend1)
                friendsList.add(friend2)
            }
            presenter.friendLoaded(friendsList = friendsList)
        }, 2000)
    }
}
