package com.example.observer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class AdapterArticles extends RecyclerView.Adapter<AdapterArticles.ViewHolder> {

    ArrayList<String> list;
    ArrayList<Integer>images;
    ArrayList<String> Desc;
    ArrayList<String> RtBtn;
    ArrayList<String> LtBtn;
    Context context;


    public AdapterArticles(ArrayList<String> list,ArrayList<Integer> images,ArrayList<String> Desc,
                           ArrayList<String> RtBtn,ArrayList<String> LtBtn,Context context) {
        this.list = list;
        this.images = images;
        this.Desc = Desc;
        this.RtBtn = RtBtn;
        this.LtBtn = LtBtn;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_articles, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.tvTitle.setText(list.get(i).toString());
        viewHolder.imgArticle.setImageResource(images.get(i));
        viewHolder.tvDesc.setText(Desc.get(i).toString());
        viewHolder.btAuto.setText(RtBtn.get(i).toString());
        viewHolder.btManual.setText(LtBtn.get(i).toString());
        final int duration = Toast.LENGTH_SHORT;




        if(RtBtn.get(i).toString() == "AUTO") {
            viewHolder.btAuto.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, TargetHome.class);
                    context.startActivity(intent);
                }
            }));
        }

        if(RtBtn.get(i).toString() == "CONFIRM") {
            viewHolder.btAuto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Confirm_Fire.class);
                    context.startActivity(intent);
                }
            });
        }

        if(RtBtn.get(i).toString() == "NEUTRALIZED") {
            viewHolder.btAuto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FIRE_EFFECT.class);
                    context.startActivity(intent);
                }
            });
        }

        if(LtBtn.get(i).toString() == "MANUAL") {
            viewHolder.btManual.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, TargetDataUI.class);
                    context.startActivity(intent);
                }
            }));
        }
        if(LtBtn.get(i).toString() == "DISMISS") {
            viewHolder.btManual.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, TargetDataUI.class);
                    context.startActivity(intent);
                }
            }));
        }

        if(LtBtn.get(i).toString() == "RECTIFY") {
            viewHolder.btManual.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, TargetDataUI.class);
                    context.startActivity(intent);
                }
            }));
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgArticle;
        public TextView tvTitle,tvDesc;
        public Button btAuto;
        public Button btManual;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgArticle  = itemView.findViewById(R.id.imgArticle);
            tvTitle     = itemView.findViewById(R.id.tvTitle);
            tvDesc      = itemView.findViewById(R.id.tvDesc);
            btAuto  = itemView.findViewById(R.id.btAutoMode);
            btManual  = itemView.findViewById(R.id.btManualMode);

        }
    }

}

