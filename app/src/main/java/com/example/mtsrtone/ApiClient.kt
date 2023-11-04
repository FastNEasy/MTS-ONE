package com.example.mtsrtone
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  ApiClient {
    private const val BASE_URL = "https://api.spaceflightnewsapi.net"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}