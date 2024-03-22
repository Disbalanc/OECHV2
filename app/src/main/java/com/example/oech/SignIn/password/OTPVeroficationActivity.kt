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

class OTPVeroficationActivity : AppCompatActivity() {
    private lateinit var btnSendOTP: TextView
    private lateinit var charNumOne: EditText
    private lateinit var charNumTwo: EditText
    private lateinit var charNumThree: EditText
    private lateinit var charNumFour: EditText
    private lateinit var charNumFive: EditText
    private lateinit var charNumSix: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otpverofication)

        charNumOne = findViewById(R.id.et_oeNum)
        charNumTwo = findViewById(R.id.et_twoNum)
        charNumThree = findViewById(R.id.et_threeNum)
        charNumFour = findViewById(R.id.et_fourNum)
        charNumFive = findViewById(R.id.et_fiveNum)
        charNumSix = findViewById(R.id.et_sixNum)
        btnSendOTP = findViewById(R.id.btn_setNewPass)

        charNumOne.addTextChangedListener(textWatcher)
        charNumTwo.addTextChangedListener(textWatcher)
        charNumThree.addTextChangedListener(textWatcher)
        charNumFour.addTextChangedListener(textWatcher)
        charNumFive.addTextChangedListener(textWatcher)
        charNumSix.addTextChangedListener(textWatcher)
    }

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            if (charNumOne.text.toString().isNotEmpty() && charNumTwo.text.toString().isNotEmpty() && charNumThree.text.toString().isNotEmpty() && charNumFour.text.toString().isNotEmpty() && charNumFive.text.toString().isNotEmpty() && charNumSix.text.toString().isNotEmpty()) {
                val code = charNumOne.text.toString() + charNumTwo.text.toString() + charNumThree.text.toString() +
                        charNumFour.text.toString() + charNumFive.text.toString() + charNumSix.text.toString()
                btnSendOTP.isEnabled = true
                btnSendOTP.backgroundTintList = resources.getColorStateList(R.color.Primary)
            } else {
                btnSendOTP.isEnabled = false
                btnSendOTP.backgroundTintList = resources.getColorStateList(R.color.Gray_2)
            }
        }
    }

    fun btn_setNewPass(view: View) {
        val intent = Intent(this, NewPasswordActivity::class.java)
        startActivity(intent)
        finish()
    }
}