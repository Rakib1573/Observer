package com.example.observer;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AccountFragment extends Fragment {

    private RecyclerView rvMyArticle;
    private AdapterMyArticles mAdapter;
    String articles[]={"Airborne","Sniper","Marksman"};
    int[] images={R.drawable.airborne,R.drawable.sniper,R.drawable.marksman};

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account, container, false);
        rvMyArticle = v.findViewById(R.id.rvMyArticle);
        rvMyArticle.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        rvMyArticle.setLayoutManager(layoutManager);

        ArrayList<String> dataArticles = new ArrayList<>();
        dataArticles.add(articles[0]);
        dataArticles.add(articles[1]);
        dataArticles.add(articles[2]);

        ArrayList<Integer> imageArticles = new ArrayList<>();
        imageArticles.add(images[0]);
        imageArticles.add(images[1]);
        imageArticles.add(images[2]);

        mAdapter    = new AdapterMyArticles(dataArticles,imageArticles,getActivity());
        rvMyArticle.setAdapter(mAdapter);

        return v;
    }

}

