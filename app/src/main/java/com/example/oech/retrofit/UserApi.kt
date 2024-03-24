package com.example.oech.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {
    @FormUrlEncoded
    @POST("register")  // URL для регистрации
    fun register(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<RegistrationResponse>

    @FormUrlEncoded
    @POST("login")  // URL для логина
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>
}

data class RegistrationResponse(val success: Boolean, val message: String)
data class LoginResponse(val success: Boolean, val token: String)