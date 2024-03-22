package com.example.oech.SignIn.password

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.oech_v2.R
import com.example.oech.SignIn.LogInActivity

class NewPasswordActivity : AppCompatActivity() {
    private lateinit var btnLogIn: TextView
    private lateinit var confimPass: EditText
    private lateinit var pass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_password)

        confimPass = findViewById(R.id.et_pass)
        pass = findViewById(R.id.et_confimPass)
        btnLogIn = findViewById(R.id.btn_LogIn)

        confimPass.addTextChangedListener(textWatcher)
        pass.addTextChangedListener(textWatcher)
    }

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            if (confimPass.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty()) {
                btnLogIn.isEnabled = true
                btnLogIn.backgroundTintList = resources.getColorStateList(R.color.Primary)
            } else {
                btnLogIn.isEnabled = false
                btnLogIn.backgroundTintList = resources.getColorStateList(R.color.Gray_2)
            }
        }
    }

    fun btn_LogIn(view: View) {
        val intent = Intent(this, LogInActivity::class.java)
        startActivity(intent)
        finish()
    }
}