package by.yakivan.vkfriends.presenters

import by.yakivan.vkfriends.R
import by.yakivan.vkfriends.models.FriendModel
import by.yakivan.vkfriends.providers.FriendsProvider
import by.yakivan.vkfriends.views.FriendsView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class FriendsPresenter : MvpPresenter<FriendsView>() {
    fun loadFriendsVk() {
        viewState.startLoading()
        FriendsProvider(presenter = this).loadFriendsVk()
    }

    fun friendLoaded(friendsList: List<FriendModel>) {
        viewState.endLoading()

        if (friendsList.size == 0) {
            viewState.showError(textResId = R.string.friends_no_item)
        } else
            viewState.setupFriendsList(friendsList = friendsList)
    }

    fun loadFriendsTEST() {
        viewState.startLoading()
        FriendsProvider(presenter = this).loadFriendsTEST(hasFriend = true)
    }
}
