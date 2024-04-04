package com.example.telegram.ui.message_recycler_view.view_holders

import android.os.Environment
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.oech.R
import com.example.telegram.ui.message_recycler_view.views.MessageView
import com.example.telegram.utilits.WRITE_FILES
import com.example.telegram.utilits.asTime
import com.example.telegram.utilits.checkPermission
import com.example.telegram.utilits.showToast
import java.io.File
import java.lang.Exception

class HolderFileMessage(view: View) : RecyclerView.ViewHolder(view), MessageHolder {

    private val blocReceivedFileMessage: ConstraintLayout = view.findViewById(R.id.bloc_received_file_message)
    private val blocUserFileMessage: ConstraintLayout = view.findViewById(R.id.bloc_user_file_message)
    private val chatUserFileMessageTime: TextView = view.findViewById(R.id.chat_user_file_message_time)
    private val chatReceivedFileMessageTime: TextView = view.findViewById(R.id.chat_received_file_message_time)

    private val chatUserFilename:TextView = view.findViewById(R.id.chat_user_filename)
    private val chatUserBtnDownload:ImageView = view.findViewById(R.id.chat_user_btn_download)
    private val chatUserProgressBar:ProgressBar = view.findViewById(R.id.chat_user_progress_bar)


    private val chatReceivedFilename:TextView = view.findViewById(R.id.chat_received_filename)
    private val chatReceivedBtnDownload:ImageView = view.findViewById(R.id.chat_received_btn_download)
    private val chatReceivedProgressBar:ProgressBar = view.findViewById(R.id.chat_received_progress_bar)

    override fun drawMessage(view: MessageView) {
    }

    override fun onAttach(view: MessageView) {
    }

    private fun clickToBtnFile(view: MessageView) {

    }


    override fun onDetach() {
      chatUserBtnDownload.setOnClickListener(null)
      chatReceivedBtnDownload.setOnClickListener(null)
    }

}