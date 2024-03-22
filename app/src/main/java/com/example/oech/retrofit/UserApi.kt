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
    @POST("Users")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<User>


    @POST("Users") // замените на ваш роут для регистрации
    fun registerUser(@Body userData: User): Call<ApiResponse>
}