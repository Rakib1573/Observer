package com.example.observer;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Main_Home_Activity extends AppCompatActivity implements View.OnClickListener{

    ImageView btFavorite,btAccount;
    ImageButton btHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);

        loadFragment(new HomeFragment());

        btHome      = findViewById(R.id.btHome);
        btFavorite  = findViewById(R.id.btFavorite);
        btAccount   = findViewById(R.id.btAccount);

        btHome.setOnClickListener(this);
        btFavorite.setOnClickListener(this);
        btAccount.setOnClickListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment!=null){
            FragmentManager fragmentManager         = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container,fragment);
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
            fragmentTransaction.commit();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btHome :
                loadFragment(new HomeFragment());
                break;
            case R.id.btFavorite:
                loadFragment(new FavoriteFragment());
                break;
            case R.id.btAccount :
                loadFragment(new AccountFragment());
                break;
        }
    }
}

