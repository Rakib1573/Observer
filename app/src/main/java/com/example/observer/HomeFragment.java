package com.example.observer;


import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView rvArticles;
    AdapterArticles mAdapter;
    String articles[]={"Target Data","Confirm Fire","Confirm Fire Effect"};
    int[] images={R.drawable.target_data1,R.drawable.confirm_fire1,R.drawable.fire_effect1};
    String desc[]={"Data of the TARGET can be set manually or the observer can set the data from the map. For setting data manually select MANUAL",
                    "Confirmation of FIRE is done when Command Post asks for it.You can CONFIRM to FIRE or DISMISS to correct TARGET DATA",
                    "Confirmation of FIRE EFFECT is set to CONFIRM that TARGET is NEUTRALIZED or if not then rectify TARGET DATA"};
    String rtBtn[]={"AUTO","CONFIRM","NEUTRALIZED"};
    String ltBtn[]={"MANUAL","DISMISS","RECTIFY"};

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        rvArticles = v.findViewById(R.id.rvArticles);
        rvArticles.setHasFixedSize(true);

        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvArticles.setLayoutManager(layoutManager);

        ArrayList<String> dataArticles = new ArrayList<>();
        dataArticles.add(articles[0]);
        dataArticles.add(articles[1]);
        dataArticles.add(articles[2]);

        ArrayList<Integer> imageArticles = new ArrayList<>();
        imageArticles.add(images[0]);
        imageArticles.add(images[1]);
        imageArticles.add(images[2]);

        ArrayList<String> dataDesc = new ArrayList<>();
        dataDesc.add(desc[0]);
        dataDesc.add(desc[1]);
        dataDesc.add(desc[2]);

        ArrayList<String> datartBtn = new ArrayList<>();
        datartBtn.add(rtBtn[0]);
        datartBtn.add(rtBtn[1]);
        datartBtn.add(rtBtn[2]);

        ArrayList<String> dataltBtn = new ArrayList<>();
        dataltBtn.add(ltBtn[0]);
        dataltBtn.add(ltBtn[1]);
        dataltBtn.add(ltBtn[2]);

        mAdapter = new AdapterArticles(dataArticles,imageArticles,dataDesc,datartBtn,dataltBtn, getActivity());
        rvArticles.setAdapter(mAdapter);
        rvArticles.setPadding(130,100,130,100);

        final SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(rvArticles);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                RecyclerView.ViewHolder viewHolder = rvArticles.findViewHolderForAdapterPosition(0);
                RelativeLayout rl1 = viewHolder.itemView.findViewById(R.id.rl1);
                rl1.animate().scaleY(1).scaleX(1).setDuration(350).setInterpolator(new AccelerateInterpolator()).start();
            }
        },100);

        rvArticles.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                View v = snapHelper.findSnapView(layoutManager);
                int pos = layoutManager.getPosition(v);

                RecyclerView.ViewHolder viewHolder = rvArticles.findViewHolderForAdapterPosition(pos);
                RelativeLayout rl1 = viewHolder.itemView.findViewById(R.id.rl1);

                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    rl1.animate().setDuration(350).scaleX(1).scaleY(1).setInterpolator(new AccelerateInterpolator()).start();
                }else{
                    rl1.animate().setDuration(350).scaleX(0.75f).scaleY(0.75f).setInterpolator(new AccelerateInterpolator()).start();
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        return v;
    }

}

