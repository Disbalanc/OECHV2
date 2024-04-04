package com.example.oech.Profile.ui.home


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import chatsData
import com.example.oech.Adapters.chatsRecycler
import com.example.oech.R
import com.example.oech.databinding.ActivityChatBinding
import com.example.telegram.models.CommonModel
import com.example.telegram.models.UserModel
import com.example.telegram.utilits.TYPE_CHAT


class ChatActivity : AppCompatActivity() {
    lateinit var binding: ActivityChatBinding
    private val adapter = chatsRecycler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {

        }

    }
}