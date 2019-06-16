package by.yakivan.vkfriends.presenters

import android.os.Handler
import by.yakivan.vkfriends.views.LoginView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {
    fun login(isSuccess: Boolean) {
        viewState.startLoading()
        Handler().postDelayed({
            viewState.endLoading()
            if (isSuccess) {
                viewState.openFriends()
            } else {
                viewState.showError(text = "Login data is incorrect!")
            }
        }, 500)
    }
}
