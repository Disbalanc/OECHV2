package com.example.oech.Profile.ui.Profile
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oech.Profile.ui.track.Item
import com.example.oech.Profile.ui.track.MyAppData
import com.example.oech_v2.R


class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

//        val recyclerView: RecyclerView = findViewById(R.id.recicle)
//
//        val states: ArrayList<Item> = ArrayList<Item>()
//        states.add(Item("Origin Details","Address","State,Country","Phone number","Others"))
//        states.add(Item("Destination Details","Address","State,Country","Phone number","Others"))
//        states.add(Item("Address","State,Country","Phone number"))
//
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = MyAppData(applicationContext, states)
    }
}