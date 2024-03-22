package com.example.telegram.models

/* Общая модель для всех сущностей приложения*/

data class CommonModel(
    val id: String = "",
    var fullname: String = "",
    var phone: String = "",
    val image:Int = 0,
    val CountNonReadMessage:Int = 0,
    var photoUrl: String = "empty",

    var text: String = "",
    var type: String = "",
    var from: String = "",
    var timeStamp: Any = "",
    var fileUrl: String = "empty",

    var lastMessage:String = "",
    var choice:Boolean = false
) {
    override fun equals(other: Any?): Boolean {
        return (other as CommonModel).id == id
    }
}