package com.example.oech.SignIn

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.oech.Profile.ProfileActivity
import com.example.oech.R
import com.example.oech.SignIn.password.ForgotPasswordActivity
import com.example.oech.SignUp.CreateAccountActivity
import com.example.telegram.utilits.initContacts
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInActivity : AppCompatActivity() {
    private lateinit var btnLogIn: TextView
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        emailEditText = findViewById(R.id.et_email)
        passwordEditText = findViewById(R.id.et_pass)
        btnLogIn = findViewById(R.id.btn_logIn1)

        emailEditText.addTextChangedListener(textWatcher)
        passwordEditText.addTextChangedListener(textWatcher)

        btnLogIn.setOnClickListener {

            }
        }

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            if (emailEditText.text.toString().isNotEmpty() && passwordEditText.text.toString().isNotEmpty()) {
                btnLogIn.isEnabled = true
                btnLogIn.backgroundTintList = resources.getColorStateList(R.color.Primary)

            } else {
                btnLogIn.isEnabled = false
                btnLogIn.backgroundTintList = resources.getColorStateList(R.color.Gray_2)
            }
        }
    }
    fun btn_signUp(view: View) {
        val intent = Intent(this, CreateAccountActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun btn_forgotPass(view: View) {
        val intent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun btn_thirdAccount(view: View) {

    }
}