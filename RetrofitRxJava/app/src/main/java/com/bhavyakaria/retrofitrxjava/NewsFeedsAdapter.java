package com.bhavyakaria.retrofitrxjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhavyakaria.retrofitrxjava.models.Article;
import com.bumptech.glide.Glide;

import java.util.List;

public class NewsFeedsAdapter extends RecyclerView.Adapter<NewsFeedsAdapter.MyViewHolder> {

    // List of Persons to be shown in RecyclerView
    public List<Article> articleList;

    // ClickListener for RecyclerView row layout
    public static ClickListener mClickListener;

    public Context context;

    public NewsFeedsAdapter(List<Article> articleList, Context context) {
        this.context = context;
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public NewsFeedsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Initialize the LayoutInflater
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Inflate the view with the row layout xml that we have created
        View listItem= layoutInflater.inflate(R.layout.layout_for_news_feeds, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsFeedsAdapter.MyViewHolder holder, int position) {
        final Article article = articleList.get(position);
        Glide.with(context)
                .load(article.getUrlToImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.feedsImage);
        holder.headline.setText(article.getTitle());
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView feedsImage;
        public TextView headline;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            feedsImage = itemView.findViewById(R.id.img_news_feeds);
            headline = itemView.findViewById(R.id.text_view_headline);
        }
    }

    // ClickListener interface with methods for detecting clicks in the activity
    public interface ClickListener {
        void onProfileClick(Article article, View v);
        void onUserNameClick(Article article, View v);
        void onRowClick(Article article, View v);
    }
}
