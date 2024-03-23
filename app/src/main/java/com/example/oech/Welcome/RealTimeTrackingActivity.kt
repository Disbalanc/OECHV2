package com.example.oech.Welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.oech.R
import com.example.oech.SignIn.LogInActivity
import com.example.oech.SignUp.CreateAccountActivity

class RealTimeTrackingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_time_tracking)
    }

    fun btn_signIn(view: View) {
        val intent = Intent(this, LogInActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun btn_signUp(view: View) {
        val intent = Intent(this, CreateAccountActivity::class.java)
        startActivity(intent)
        finish()
    }
}