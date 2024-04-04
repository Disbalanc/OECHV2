package com.example.oech.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import chatsData
import com.example.oech.Profile.ui.home.OneChatActivity
import com.example.oech.R
import com.example.telegram.models.CommonModel
import com.example.telegram.utilits.initContacts

class chatsRecycler:RecyclerView.Adapter<chatsRecycler.ChatHolder>(){
    val list = ArrayList<CommonModel>()
    class ChatHolder(item:View):RecyclerView.ViewHolder(item){
        fun bind(chat: CommonModel){
            val image: ImageView = itemView.findViewById(R.id.chatImage)
            val nameText: TextView = itemView.findViewById(R.id.HeadText)
            val messageText: TextView = itemView.findViewById(R.id.MessageText)
            val countNonReadMessage: TextView = itemView.findViewById(R.id.NonReadMessage)

            image.setImageResource(chat.image)
            nameText.setText(chat.fullname)
            messageText.setText(chat.lastMessage)
            countNonReadMessage.setText(chat.CountNonReadMessage.toString())

            val currentItem = chat

            // Проверяем, если количество непрочитанных сообщений отлично от 0
            if (currentItem.CountNonReadMessage != 0) {
                countNonReadMessage.visibility = View.VISIBLE
                countNonReadMessage.text = currentItem.CountNonReadMessage.toString()
            } else {
                countNonReadMessage.visibility = View.GONE
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chats, parent, false)
        return ChatHolder(view)
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
        val contact = list[position]
        holder.bind(contact)
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, OneChatActivity::class.java)
            intent.putExtra("contactName", contact.fullname)
            holder.itemView.context.startActivity(intent) // Запускаем новую Activity
        }
    }
        override fun getItemCount(): Int {
            return list.size
        }
    fun addChat(chat: CommonModel){
        list.add(chat)
        notifyDataSetChanged()
    }
}