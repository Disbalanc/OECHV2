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
import com.example.telegram.models.CommonModel
import com.example.telegram.models.UserModel
import com.example.telegram.ui.message_recycler_view.views.AppViewFactory
import com.example.telegram.ui.screens.single_chat.SingleChatAdapter
import com.example.telegram.utilits.AppVoiceRecorder
import com.example.telegram.utilits.TYPE_CHAT
import com.example.telegram.utilits.replaceFragment
import com.example.telegram.utilits.showToast
import com.google.android.material.bottomsheet.BottomSheetBehavior

class OneChatActivity : AppCompatActivity() {
    private lateinit var contact: CommonModel
    lateinit var binding: ActivityOneChatBinding
    private lateinit var mReceivingUser: UserModel
    private lateinit var mAdapter: SingleChatAdapter
    private lateinit var mRecyclerView: RecyclerView
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
        mRecyclerView.adapter = mAdapter
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.isNestedScrollingEnabled = false
        mRecyclerView.layoutManager = mLayoutManager

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
    }

    override fun onPause() {
        super.onPause()
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
        if (message.isEmpty()) {}
    }
}