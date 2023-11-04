package com.example.mtsrtone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SpaceArticleDataAdapter(private val spaceItems: List<SpaceArticleData.SpaceData>) : RecyclerView.Adapter<SpaceArticleDataAdapter.PostViewHolder>() {
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.id)
        val title: TextView = itemView.findViewById(R.id.title)
        val newsSite: TextView = itemView.findViewById(R.id.newsSite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.space_article_list_item, parent, false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = spaceItems[position]
        holder.id.text = "ID: " + item.id.toString()
        holder.title.text = "Article: " + item.title
        holder.newsSite.text = "News Source: " + item.news_site
    }

    override fun getItemCount(): Int {
        return spaceItems.size
    }
}