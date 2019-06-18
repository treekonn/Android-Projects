package by.yakivan.vkfriends.views

import by.yakivan.vkfriends.models.FriendModel
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FriendsView : MvpView {
    fun startLoading()
    fun endLoading()
    fun showError(textResId: Int)
    fun setupFriendsList(friendsList: List<FriendModel>)
}
