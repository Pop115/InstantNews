package fr.kienanbachwa.instantnews.ui.components.newsrecycler

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import fr.kienanbachwa.instantnews.R

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val newsTitle : TextView = itemView.findViewById(R.id.news_title);
    val newsDescription : TextView = itemView.findViewById(R.id.news_description);
    val newsPicture : AppCompatImageView = itemView.findViewById(R.id.news_picture);
}