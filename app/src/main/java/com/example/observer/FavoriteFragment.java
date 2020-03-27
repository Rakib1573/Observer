package com.example.observer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class FavoriteFragment extends Fragment {

    RecyclerView rvFavorite;
    AdapterFavorite mAdapter;
    String articleFavorite[]={"Target Data","Confirm Fire","Confirm Fire Effect"};
    int[] images={R.drawable.target_data1,R.drawable.confirm_fire1,R.drawable.fire_effect1};
    String desc[]={"Send target data","Send fire confirmation",
                    "Fire effect report"};

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_favorite, container, false);
        rvFavorite = v.findViewById(R.id.rvFavorite);
        rvFavorite.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvFavorite.setLayoutManager(layoutManager);

        ArrayList<String> favArticle = new ArrayList<>();
        favArticle.add(articleFavorite[0]);
        favArticle.add(articleFavorite[1]);
        favArticle.add(articleFavorite[2]);

        ArrayList<Integer> imageArticles = new ArrayList<>();
        imageArticles.add(images[0]);
        imageArticles.add(images[1]);
        imageArticles.add(images[2]);

        ArrayList<String> dataDesc = new ArrayList<>();
        dataDesc.add(desc[0]);
        dataDesc.add(desc[1]);
        dataDesc.add(desc[2]);

        mAdapter = new AdapterFavorite(favArticle,imageArticles,dataDesc,getActivity());
        rvFavorite.setAdapter(mAdapter);

        rvFavorite.getAdapter().notifyDataSetChanged();
        rvFavorite.scheduleLayoutAnimation();

        return v;
    }

}