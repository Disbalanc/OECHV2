package com.example.oech.SignIn.password

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.oech.R
import com.example.oech.SignIn.LogInActivity

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var btnLogIn: TextView
    private lateinit var emailText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        emailText = findViewById(R.id.et_email)
        btnLogIn = findViewById(R.id.btn_sendOTP)

        emailText.addTextChangedListener(textWatcher)
    }

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            if (emailText.text.toString().isNotEmpty()) {
                btnLogIn.isEnabled = true
                btnLogIn.backgroundTintList = resources.getColorStateList(R.color.Primary)
            } else {
                btnLogIn.isEnabled = false
                btnLogIn.backgroundTintList = resources.getColorStateList(R.color.Gray_2)
            }
        }
    }

    fun btn_signIp(view: View) {
        val intent = Intent(this, LogInActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun btn_sendOTP(view: View) {
        val intent = Intent(this, OTPVeroficationActivity::class.java)
        startActivity(intent)
        finish()
    }
}