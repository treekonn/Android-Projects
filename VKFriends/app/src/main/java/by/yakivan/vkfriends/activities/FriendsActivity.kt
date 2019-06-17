package by.yakivan.vkfriends.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import by.yakivan.vkfriends.R
import by.yakivan.vkfriends.adapters.FriendsAdapter
import by.yakivan.vkfriends.models.FriendModel
import by.yakivan.vkfriends.presenters.FriendsPresenter
import by.yakivan.vkfriends.views.FriendsView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.github.rahatarmanahmed.cpv.CircularProgressView

class FriendsActivity : MvpAppCompatActivity(), FriendsView {

    @InjectPresenter
    lateinit var friendsPresenter: FriendsPresenter

    private lateinit var mAdapter: FriendsAdapter
    private lateinit var mRvFriends: RecyclerView
    private lateinit var mTxtNoItem: TextView
    private lateinit var mCvpFriends: CircularProgressView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)

        mRvFriends = findViewById(R.id.recycler_friends)
        mTxtNoItem = findViewById(R.id.txt_friends_no_item)
        mCvpFriends = findViewById(R.id.cpv_friends)

        val mTxtSearch: EditText = findViewById(R.id.txt_friends_search)
        mTxtSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                mAdapter.filter(query = s.toString())
            }
        })

        friendsPresenter.loadFriends()
        mAdapter = FriendsAdapter()

        mRvFriends.adapter = mAdapter
        mRvFriends.layoutManager =
            LinearLayoutManager(applicationContext, OrientationHelper.VERTICAL, false)
        mRvFriends.setHasFixedSize(true)
    }

    override fun showError(textResource: Int) {
        mTxtNoItem.text = getString(textResource)
        Toast.makeText(applicationContext, getString(textResource), Toast.LENGTH_LONG).show()
    }

    override fun setupEmptyList() {
        mRvFriends.visibility = View.GONE
        mTxtNoItem.visibility = View.VISIBLE
    }

    override fun setupFriendsList(friendsList: List<FriendModel>) {
        mRvFriends.visibility = View.VISIBLE
        mTxtNoItem.visibility = View.GONE

        mAdapter.setupFriends(friendsList = friendsList)
    }

    override fun startLoading() {
        mRvFriends.visibility = View.GONE
        mTxtNoItem.visibility = View.GONE
        mCvpFriends.visibility = View.VISIBLE
    }

    override fun endLoading() {
        mCvpFriends.visibility = View.GONE
    }
}
