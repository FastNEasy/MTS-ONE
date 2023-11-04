package com.example.mtsrtone

data class SpaceArticleData(
    val results: MutableList<SpaceData>,
){
    data class SpaceData(
        val id: Int,
        val title: String,
        val news_site: String
    )
}
