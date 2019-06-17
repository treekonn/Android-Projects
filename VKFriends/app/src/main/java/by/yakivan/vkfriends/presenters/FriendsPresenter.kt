package by.yakivan.vkfriends.presenters

import by.yakivan.vkfriends.R
import by.yakivan.vkfriends.models.FriendModel
import by.yakivan.vkfriends.providers.FriendsProvider
import by.yakivan.vkfriends.views.FriendsView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import kotlinx.android.synthetic.main.activity_friends.view.*

@InjectViewState
class FriendsPresenter : MvpPresenter<FriendsView>() {
    fun loadFriends() {
        viewState.startLoading()
//        FriendsProvider(presenter = this).testLoadFriend(hasFriend = true)
        FriendsProvider(presenter = this).loadFriends()
    }

    fun friendLoaded(friendsList: List<FriendModel>) {
        viewState.endLoading()

        if (friendsList.size == 0) {
            viewState.showError(R.string.friends_no_item)
            viewState.setupEmptyList()
        } else
            viewState.setupFriendsList(friendsList)
    }
}
