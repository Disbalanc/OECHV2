package com.example.telegram.database

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.oech.Profile.ui.home.OneChatActivity
import com.example.oech.R
import com.example.telegram.models.CommonModel
import com.example.telegram.models.UserModel
import com.example.telegram.utilits.APP_ACTIVITY
import com.example.telegram.utilits.TYPE_GROUP
import com.example.telegram.utilits.showToast
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch
import java.io.File
import java.util.ArrayList
import java.util.HashMap

suspend fun getData() {
        val client = getClient()
        val supabaseResponsable = client.postgrest["profiles"].select()
        val data = supabaseResponsable.decodeList<UserModel>(
        )
        Log.e("supabase",data.toString())
}

fun getClient() : SupabaseClient {
    return createSupabaseClient(
        supabaseUrl = "https://xvmyejvdecvsgidtganp.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Inh2bXllanZkZWN2c2dpZHRnYW5wIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTEzODAwMDEsImV4cCI6MjAyNjk1NjAwMX0.-R2815MwBROvruqKo21EMjEE67BdyjqflQEYsjJw6GU"
    ) {
        install(Postgrest)
    }
}
