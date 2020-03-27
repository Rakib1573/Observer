package com.example.observer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterFavorite extends RecyclerView.Adapter<AdapterFavorite.ViewHolder> {

    ArrayList<String> list;
    ArrayList<Integer>images;
    ArrayList<String> Desc;
    Context context;

    public AdapterFavorite(ArrayList<String> list,ArrayList<Integer> images,ArrayList<String> Desc, Context context) {
        this.list = list;
        this.images = images;
        this.Desc = Desc;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_fav_article, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(context,R.anim.layoutanim);
        viewHolder.tvTitle.setText(list.get(i).toString());
        viewHolder.imgArticle.setImageResource(images.get(i));
        viewHolder.tvDesc.setText(Desc.get(i).toString());
        viewHolder.rl1.setLayoutAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgArticle;
        public TextView tvTitle,tvDesc;
        public RelativeLayout rl1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgArticle  = itemView.findViewById(R.id.imgArticle);
            tvTitle     = itemView.findViewById(R.id.tvTitle);
            tvDesc      = itemView.findViewById(R.id.tvDesc);
            rl1         = itemView.findViewById(R.id.rl1);
        }
    }
}
