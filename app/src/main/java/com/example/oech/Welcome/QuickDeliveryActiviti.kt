package com.example.oech.Welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.oech.R

class QuickDeliveryActiviti : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quick_delivery_activiti)
    }

    fun btn_skip(view: View) {
        val intent = Intent(this, RealTimeTrackingActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun btn_next(view: View) {
        val intent = Intent(this, FlexiblePaymentActivity::class.java)
        startActivity(intent)
        finish()
    }
}