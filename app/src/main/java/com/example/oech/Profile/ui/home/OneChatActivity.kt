package com.example.oech.Profile.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AbsListView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oech.R
import com.example.oech.databinding.ActivityChatBinding
import com.example.oech.databinding.ActivityOneChatBinding
import com.example.telegram.database.CURRENT_UID
import com.example.telegram.database.NODE_MESSAGES
import com.example.telegram.database.REF_DATABASE_ROOT
import com.example.telegram.database.TYPE_TEXT
import com.example.telegram.database.clearChat
import com.example.telegram.database.deleteChat
import com.example.telegram.database.getCommonModel
import com.example.telegram.database.initFirebase
import com.example.telegram.database.saveToMainList
import com.example.telegram.database.sendMessage
import com.example.telegram.models.CommonModel
import com.example.telegram.models.UserModel
import com.example.telegram.ui.message_recycler_view.views.AppViewFactory
import com.example.telegram.ui.screens.single_chat.SingleChatAdapter
import com.example.telegram.utilits.AppChildEventListener
import com.example.telegram.utilits.AppValueEventListener
import com.example.telegram.utilits.AppVoiceRecorder
import com.example.telegram.utilits.TYPE_CHAT
import com.example.telegram.utilits.replaceFragment
import com.example.telegram.utilits.showToast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class OneChatActivity : AppCompatActivity() {
    private lateinit var contact: CommonModel
    lateinit var binding: ActivityOneChatBinding

    private lateinit var mListenerInfoToolbar: AppValueEventListener
    private lateinit var mReceivingUser: UserModel
    private lateinit var mToolbarInfo: com.google.firebase.database.core.view.View
    private lateinit var mRefUser: DatabaseReference
    private lateinit var mRefMessages: DatabaseReference
    private lateinit var mAdapter: SingleChatAdapter
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mMessagesListener: AppChildEventListener
    private var mCountMessages = 10
    private var mIsScrolling = false
    private var mSmoothScrollToPosition = true
    private lateinit var mLayoutManager: LinearLayoutManager
    private lateinit var mAppVoiceRecorder: AppVoiceRecorder
    private lateinit var mBottomSheetBehavior: BottomSheetBehavior<*>
    override fun onResume() {
        super.onResume()
        initRecycleView()
    }
    private fun initRecycleView() {
        mRecyclerView = binding.recyclerViewChat
        mAdapter = SingleChatAdapter()
        mRefMessages = REF_DATABASE_ROOT
            .child(NODE_MESSAGES)
            .child(CURRENT_UID)
            .child(contact.id)
        mRecyclerView.adapter = mAdapter
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.isNestedScrollingEnabled = false
        mRecyclerView.layoutManager = mLayoutManager
        mMessagesListener = AppChildEventListener {
            val message = it.getCommonModel()

            if (mSmoothScrollToPosition) {
                mAdapter.addItemToBottom(AppViewFactory.getView(message)) {
                    mRecyclerView.smoothScrollToPosition(mAdapter.itemCount)
                }
            } else {
                mAdapter.addItemToTop(AppViewFactory.getView(message)) {
                }
            }

        }
        mRefMessages.limitToLast(mCountMessages).addChildEventListener(mMessagesListener)

        mRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                println(mRecyclerView.recycledViewPool.getRecycledViewCount(0))
                if (mIsScrolling && dy < 0 && mLayoutManager.findFirstVisibleItemPosition() <= 3) {
                    updateData()
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    mIsScrolling = true
                }
            }
        })

    }

    private fun updateData() {
        mSmoothScrollToPosition = false
        mIsScrolling = false
        mCountMessages += 10
        mRefMessages.removeEventListener(mMessagesListener)
        mRefMessages.limitToLast(mCountMessages).addChildEventListener(mMessagesListener)
    }

    override fun onPause() {
        super.onPause()
        mRefUser.removeEventListener(mListenerInfoToolbar)
        mRefMessages.removeEventListener(mMessagesListener)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOneChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contact = CommonModel()
        mLayoutManager = LinearLayoutManager(this)

        val contactName = intent.getStringExtra("contactName")
        val tvNameMess = findViewById<TextView>(R.id.tv_name_mess)
        tvNameMess.text = contactName // Установка данных в TextView
    }

    fun btn_sentMessage(view: android.view.View) {
        mSmoothScrollToPosition = true
        val message = binding.AddMessage.text.toString()
        if (message.isEmpty()) {
        } else sendMessage(
            message,
            contact.id,
            TYPE_TEXT
        ) {
            saveToMainList(contact.id, TYPE_CHAT)
            binding.AddMessage.setText("")
        }
    }
}