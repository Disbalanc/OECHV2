package com.example.oech.Profile


import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oech.Adapters.MyAds
import com.example.oech.Adapters.adsData
import com.example.oech.Adapters.chatsRecycler
import com.example.oech.Profile.ui.Profile.EditProfileActivity
import com.example.oech.Profile.ui.home.ChatActivity
import com.example.oech.Profile.ui.home.HomeFragment
import com.example.oech.Welcome.RealTimeTrackingActivity
import com.example.oech.R
import com.example.oech.databinding.ActivityProfileBinding
import com.example.telegram.database.AUTH
import com.example.telegram.models.CommonModel
import com.example.telegram.models.UserModel
import com.example.telegram.utilits.APP_ACTIVITY
import com.example.telegram.utilits.initContacts
import com.example.telegram.utilits.replaceFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_profile)
        navView.setupWithNavController(navController)
    }


    fun btn_editProfile(view: View) {
        val intent = Intent(this, EditProfileActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun btn_StatementsAndReport(view: View) {
        val intent = Intent(this, EditProfileActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun btn_Notification(view: View) {

    }
    fun btn_Card(view: View) {

    }
    fun btn_AboutUs(view: View) {

    }
    fun btn_LogOut(view: View) {

    }
    fun cards(){
        val cards = findViewById<LinearLayout>(R.id.cards1)
        cards.setBackgroundResource(R.drawable.round_cards)
        val cards1 = findViewById<LinearLayout>(R.id.cards2)
        cards1.setBackgroundResource(R.drawable.round_cards)
        val cards2 = findViewById<LinearLayout>(R.id.cards3)
        cards2.setBackgroundResource(R.drawable.round_cards)
        val cards3 = findViewById<LinearLayout>(R.id.cards4)
        cards3.setBackgroundResource(R.drawable.round_cards)

        val img = findViewById<ImageView>(R.id.cards1_img)
        img.setColorFilter(ContextCompat.getColor(this, R.color.Primary), PorterDuff.Mode.SRC_IN)
        val img1 = findViewById<ImageView>(R.id.cards2_img)
        img1.setColorFilter(ContextCompat.getColor(this, R.color.Primary), PorterDuff.Mode.SRC_IN)
        val img2 = findViewById<ImageView>(R.id.cards3_img)
        img2.setColorFilter(ContextCompat.getColor(this, R.color.Primary), PorterDuff.Mode.SRC_IN)
        val img3 = findViewById<ImageView>(R.id.cards4_img)
        img3.setColorFilter(ContextCompat.getColor(this, R.color.Primary), PorterDuff.Mode.SRC_IN)

        val HeadText = findViewById<TextView>(R.id.cards1_HeaderText)
        val Text = findViewById<TextView>(R.id.cards1_text)
        HeadText.setTextColor(ContextCompat.getColor(this, R.color.Primary))
        Text.setTextColor(ContextCompat.getColor(this, R.color.Gray_3))
        val HeadText1 = findViewById<TextView>(R.id.cards2_HeaderText)
        val Text1 = findViewById<TextView>(R.id.cards2_text)
        HeadText1.setTextColor(ContextCompat.getColor(this, R.color.Primary))
        Text1.setTextColor(ContextCompat.getColor(this, R.color.Gray_3))
        val HeadText2 = findViewById<TextView>(R.id.cards3_HeaderText)
        val Text2 = findViewById<TextView>(R.id.cards3_text)
        HeadText2.setTextColor(ContextCompat.getColor(this, R.color.Primary))
        Text2.setTextColor(ContextCompat.getColor(this, R.color.Gray_3))
        val HeadText3 = findViewById<TextView>(R.id.cards4_HeaderText)
        val Text3 = findViewById<TextView>(R.id.cards4_text)
        HeadText3.setTextColor(ContextCompat.getColor(this, R.color.Primary))
        Text3.setTextColor(ContextCompat.getColor(this, R.color.Gray_3))
    }

    fun btn_chats(view: View) {
        cards()
        val cards = findViewById<LinearLayout>(R.id.cards4)
        val img = findViewById<ImageView>(R.id.cards4_img)
        val HeadText = findViewById<TextView>(R.id.cards4_HeaderText)
        val Text = findViewById<TextView>(R.id.cards4_text)
        HeadText.setTextColor(ContextCompat.getColor(this, R.color.white))
        Text.setTextColor(ContextCompat.getColor(this, R.color.white))
        img.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN)
        cards.setBackgroundResource(R.drawable.round_select_cards)
        val intent = Intent(this, ChatActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun btn_care(view: View) {
        Toast.makeText(this, "Cooming Soon",Toast.LENGTH_LONG).show()
        cards()
        val cards = findViewById<LinearLayout>(R.id.cards1)
        val img = findViewById<ImageView>(R.id.cards1_img)
        val HeadText = findViewById<TextView>(R.id.cards1_HeaderText)
        val Text = findViewById<TextView>(R.id.cards1_text)
        HeadText.setTextColor(ContextCompat.getColor(this, R.color.white))
        Text.setTextColor(ContextCompat.getColor(this, R.color.white))
        img.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN)
        cards.setBackgroundResource(R.drawable.round_select_cards)
    }
    fun btn_wallet(view: View) {
        cards()
        Toast.makeText(this, "Cooming Soon",Toast.LENGTH_LONG).show()
        val cards = findViewById<LinearLayout>(R.id.cards3)
        val img = findViewById<ImageView>(R.id.cards3_img)
        val HeadText = findViewById<TextView>(R.id.cards3_HeaderText)
        val Text = findViewById<TextView>(R.id.cards3_text)
        HeadText.setTextColor(ContextCompat.getColor(this, R.color.white))
        Text.setTextColor(ContextCompat.getColor(this, R.color.white))
        img.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN)
        cards.setBackgroundResource(R.drawable.round_select_cards)
    }
    fun btn_package(view: View) {
        cards()
        Toast.makeText(this, "Cooming Soon",Toast.LENGTH_LONG).show()
        val cards = findViewById<LinearLayout>(R.id.cards2)
        val img = findViewById<ImageView>(R.id.cards2_img)
        val HeadText = findViewById<TextView>(R.id.cards2_HeaderText)
        val Text = findViewById<TextView>(R.id.cards2_text)
        HeadText.setTextColor(ContextCompat.getColor(this, R.color.white))
        Text.setTextColor(ContextCompat.getColor(this, R.color.white))
        img.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN)
        cards.setBackgroundResource(R.drawable.round_select_cards)
    }

    fun btn_special(view: View) {
        val recyclerView: RecyclerView = findViewById(R.id.RecyclerViewAds)
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager

// Получаем позицию первого видимого элемента
        val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()

// Получаем позицию последнего видимого элемента
        val lastVisiblePosition = layoutManager.findLastVisibleItemPosition()

// Выполняем прокрутку к следующему элементу
        if (lastVisiblePosition < MyAds().list.size - 1) {
            recyclerView.smoothScrollToPosition(lastVisiblePosition + 1)
    }
    }
}