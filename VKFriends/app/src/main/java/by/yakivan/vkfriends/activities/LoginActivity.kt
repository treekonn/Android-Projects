package by.yakivan.vkfriends.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import by.yakivan.vkfriends.R
import by.yakivan.vkfriends.presenters.LoginPresenter
import by.yakivan.vkfriends.views.LoginView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.github.rahatarmanahmed.cpv.CircularProgressView

class LoginActivity : MvpAppCompatActivity(), LoginView {

    private lateinit var mTxtHello: TextView
    private lateinit var mBtnButton: Button
    private lateinit var mCpvWait: CircularProgressView

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mTxtHello = findViewById(R.id.txt_login_hello)
        mBtnButton = findViewById(R.id.btn_login_enter)
        mCpvWait = findViewById(R.id.cpv_login)

        mBtnButton.setOnClickListener {
            loginPresenter.login(isSuccess = true)
        }
    }

    override fun startLoading() {
        mBtnButton.visibility = View.GONE
        mCpvWait.visibility = View.VISIBLE
    }

    override fun endLoading() {
        mBtnButton.visibility = View.VISIBLE
        mCpvWait.visibility = View.GONE
    }

    override fun showError(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
    }

    override fun openFriends() {
        startActivity(Intent(applicationContext, FriendsActivity::class.java))
    }
}
