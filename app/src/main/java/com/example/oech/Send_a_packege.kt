package com.example.oech

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oech.Profile.ui.track.Item
import com.example.oech.Profile.ui.track.MyAppData
import com.example.oech.R

class Data {
    var statesClon: ArrayList<Item>? = null
    var recyclerViewClon: RecyclerView? = null

    fun setData(states: ArrayList<Item>, recyclerView: RecyclerView) {
        recyclerViewClon = recyclerView
        statesClon = states
    }
}
class Send_a_packege : AppCompatActivity() {
    private val asd = Data()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_apackege)

        val states: ArrayList<Item> = ArrayList<Item>()
        val recyclerView: RecyclerView = findViewById(R.id.recicle)

        asd.setData(states, recyclerView)

        asd.statesClon!!.add(
            Item(
                "Origin Details",
                "Address",
                "State,Country",
                "Phone number",
                "Others"
            )
        )
        asd.statesClon!!.add(
            Item(
                "Destination Details",
                "Address",
                "State,Country",
                "Phone number",
                "Others"
            )
        )
        asd.statesClon!!.add(
            Item(
                "Package Details",
                "package items",
                "Weight of item(kg)",
                "Worth of Items"
            )
        )

        asd.recyclerViewClon!!.layoutManager = LinearLayoutManager(this)
        asd.recyclerViewClon!!.adapter = MyAppData(applicationContext, states)
    }
    fun addElements(view: View) {
        //asd.recyclerViewClon!!.getIt
    }
}

