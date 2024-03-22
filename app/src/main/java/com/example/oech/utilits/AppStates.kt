package com.example.telegram.utilits

import com.example.telegram.database.*

enum class AppStates(val state:String) {
   /* Класс перечисление состояний приложения*/

    ONLINE("в сети"),
    OFFLINE("был недавно"),
    TYPING("печатает");

    companion object{

    }
}