package com.example.oech.Profile.ui.home


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import chatsData
import com.example.oech.Adapters.chatsRecycler
import com.example.oech.R
import com.example.oech.databinding.ActivityChatBinding
import com.example.telegram.database.TYPE_TEXT
import com.example.telegram.database.USER
import com.example.telegram.database.saveToMainList
import com.example.telegram.database.sendMessage
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
            recyclerViewChat.adapter = adapter

            val message = "Thank you for using our service"

            var list = CommonModel(id = USER.id,image = R.drawable.ic_avatar, fullname =  "Избранноее", CountNonReadMessage =  5)
            adapter.addChat(list)

            if (message.isEmpty()) {
            } else sendMessage(
                message,
                USER.id,
                TYPE_TEXT
            ) {
                saveToMainList(USER.id, TYPE_CHAT)
            }



        }

    }
}