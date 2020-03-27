package com.example.observer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMyArticles extends RecyclerView.Adapter<AdapterMyArticles.ViewHolder> {

    ArrayList<String> list;
    ArrayList<Integer>images;
    Context context;

    public AdapterMyArticles(ArrayList<String> list,ArrayList<Integer>images, Context context) {
        this.list = list;
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_my_articles, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvTitle.setText(list.get(i).toString());
        viewHolder.imgArticle.setImageResource(images.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgArticle;
        public TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgArticle  = itemView.findViewById(R.id.imgArticle);
            tvTitle     = itemView.findViewById(R.id.tvTitle);
        }
    }
}

