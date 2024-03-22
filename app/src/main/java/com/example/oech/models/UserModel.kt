package com.example.telegram.models

/* Модель для User*/

data class UserModel(
    val id: String = "",
    var fullname: String = "",
    var email:String = "",
    var phone: String = "",
    var photoUrl: String = "empty"
)