package com.example.oech.SignUp

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.oech.Profile.ProfileActivity
import com.example.oech_v2.R
import com.example.oech.SignIn.LogInActivity
import com.example.oech.retrofit.ApiHelper
import com.example.oech.retrofit.ApiResponse
import com.example.oech.retrofit.User
import com.example.telegram.database.initFirebase
import com.example.telegram.database.initUser
import com.example.telegram.utilits.initContacts
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CreateAccountActivity : AppCompatActivity() {

    private lateinit var  cb_terms : CheckBox
    private lateinit var btn_signUp: TextView
    private lateinit var et_name: EditText
    private lateinit var et_phone: EditText
    private lateinit var et_email: EditText
    private lateinit var et_password: EditText
    private lateinit var et_confimPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        cb_terms = findViewById(R.id.cb_terms)
        et_name = findViewById(R.id.et_name)
        et_phone = findViewById(R.id.et_phone)
        et_email = findViewById(R.id.et_email)
        et_password = findViewById(R.id.et_password)
        et_confimPassword = findViewById(R.id.et_confimPassword)
        btn_signUp = findViewById(R.id.btn_signUp)

        et_name.addTextChangedListener(textWatcher)
        et_phone.addTextChangedListener(textWatcher)
        et_email.addTextChangedListener(textWatcher)
        et_password.addTextChangedListener(textWatcher)
        et_confimPassword.addTextChangedListener(textWatcher)

        btn_signUp.setOnClickListener{
            val api = ApiHelper.apiService
            val userData = User(et_name.text.toString(), et_phone.text.toString(), et_email.text.toString(), et_password.text.toString())
            val intent = Intent(this, ProfileActivity::class.java)

            CoroutineScope(Dispatchers.IO).launch {
                api.registerUser(userData).enqueue(object : Callback<ApiResponse> {
                    override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                        if (response.isSuccessful) {
                            val apiResponse = response.body()
                            if (apiResponse?.success == true) {
                                Toast.makeText(applicationContext, "Registration successful", Toast.LENGTH_SHORT).show()
                                Log.w(ContentValues.TAG, "Registration successful")
                                startActivity(intent)
                                finish()
                                // Обработка успешной регистрации
                            } else {
                                Toast.makeText(applicationContext, apiResponse?.message, Toast.LENGTH_SHORT).show()
                                Log.w(ContentValues.TAG, apiResponse?.message.toString())
                            }
                        } else {
                            Toast.makeText(applicationContext, "Error registering user", Toast.LENGTH_SHORT).show()
                            Log.w(ContentValues.TAG, "Error registering user")
                        }
                    }

                    override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.toString(), Toast.LENGTH_SHORT).show()
                        Toast.makeText(applicationContext, "Error: ${t.message}", Toast.LENGTH_SHORT).show()

                    }
                })
            }
        }
    }

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            if (et_name.text.toString().isNotEmpty() && et_phone.text.toString().isNotEmpty()&& et_email.text.toString().isNotEmpty()&& et_password.text.toString().isNotEmpty()&& et_confimPassword.text.toString().isNotEmpty()) {
                if (cb_terms.isActivated) {
                    if (et_password.text.toString() == et_confimPassword.text.toString()){

                    }else {

                    }
                } else {

                }
                btn_signUp.isEnabled = true
                btn_signUp.backgroundTintList = resources.getColorStateList(R.color.Primary)
            } else {
                btn_signUp.isEnabled = false
                btn_signUp.backgroundTintList = resources.getColorStateList(R.color.Gray_2)
            }
        }
    }

    var booleanPass: Boolean = false
    var booleanConfimPass: Boolean = false
    fun iv_passVisible(view: View) {
        var pass:EditText = findViewById(R.id.et_password)
        var image: ImageView = findViewById(R.id.iv_visiblePass)
        if (booleanPass){
            pass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD)
            image.setImageResource(R.drawable.eye_slash)
            booleanPass = false
        }else{
            pass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
            image.setImageResource(R.drawable.eye)
            booleanPass = true
        }
    }
    fun iv_passVisible2(view: View) {
        var confimPass:EditText = findViewById(R.id.et_confimPassword)
        var image: ImageView = findViewById(R.id.iv_visiblePass2)
        if (booleanConfimPass){
            confimPass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD)
            image.setImageResource(R.drawable.eye_slash)
            booleanConfimPass = false
        }else{
            confimPass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
            image.setImageResource(R.drawable.eye)
            booleanConfimPass = true
        }
    }

    fun btn_signUp(view: View) {

    }
    fun btn_signIn(view: View) {
        val intent = Intent(this, LogInActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun btn_thirdAccount(view: View) {

    }
}