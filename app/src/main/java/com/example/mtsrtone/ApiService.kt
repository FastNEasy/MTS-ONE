package com.example.mtsrtone
import retrofit2.Call
import retrofit2.http.GET

interface  ApiService {
    @GET("/v4/articles/?limit=20")
    fun getSpaceArticleData(): Call<SpaceArticleData>
}