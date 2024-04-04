package com.example.telegram.ui.message_recycler_view.view_holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.oech.R
import com.example.telegram.ui.message_recycler_view.views.MessageView
import com.example.telegram.utilits.AppVoicePlayer
import com.example.telegram.utilits.asTime

class HolderVoiceMessage(view: View) : RecyclerView.ViewHolder(view), MessageHolder {

    private val mAppVoicePlayer = AppVoicePlayer()

    private val blocReceivedVoiceMessage: ConstraintLayout = view.findViewById(R.id.bloc_received_voice_message)
    private val blocUserVoiceMessage: ConstraintLayout = view.findViewById(R.id.bloc_user_voice_message)
    private val chatUserVoiceMessageTime: TextView = view.findViewById(R.id.chat_user_voice_message_time)
    private val chatReceivedVoiceMessageTime: TextView = view.findViewById(R.id.chat_received_voice_message_time)


    private val chatReceivedBtnPlay: ImageView = view.findViewById(R.id.chat_received_btn_play)
    private val chatReceivedBtnStop: ImageView = view.findViewById(R.id.chat_received_btn_stop)

    private val chatUserBtnPlay: ImageView = view.findViewById(R.id.chat_user_btn_play)
    private val chatUserBtnStop: ImageView = view.findViewById(R.id.chat_user_btn_stop)


    override fun drawMessage(view: MessageView) {
    }

    override fun onAttach(view: MessageView) {

    }

    private fun play(
        view: MessageView,
        function: () -> Unit
    ) {
        mAppVoicePlayer.play(view.id, view.fileUrl) {
            function()
        }
    }

    fun stop(function: () -> Unit) {
        mAppVoicePlayer.stop {
            function()
        }
    }

    override fun onDetach() {
        chatReceivedBtnPlay.setOnClickListener(null)
        chatUserBtnPlay.setOnClickListener(null)
        mAppVoicePlayer.release()
    }

}