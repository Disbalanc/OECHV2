package com.example.telegram.ui.message_recycler_view.view_holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.oech.R
import com.example.telegram.ui.message_recycler_view.views.MessageView
import com.example.telegram.utilits.asTime
import com.example.telegram.utilits.downloadAndSetImage

class HolderImageMessage(view: View) : RecyclerView.ViewHolder(view), MessageHolder {
    private  val blocReceivedImageMessage: ConstraintLayout = view.findViewById(R.id.bloc_received_image_message)
    private  val blocUserImageMessage: ConstraintLayout = view.findViewById(R.id.bloc_user_image_message)
    private  val chatUserImage: ImageView = view.findViewById(R.id.chat_user_image)
    private  val chatReceivedImage: ImageView = view.findViewById(R.id.chat_received_image)
    private  val chatUserImageMessageTime: TextView = view.findViewById(R.id.chat_user_image_message_time)
    private  val chatReceivedImageMessageTime: TextView = view.findViewById(R.id.chat_received_image_message_time)


    override fun drawMessage(view: MessageView) {

    }

    override fun onAttach(view: MessageView) {
    }

    override fun onDetach() {
    }
}