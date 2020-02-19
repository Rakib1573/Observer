package com.example.observer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

public class observerHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    LinearLayout targetData;
    LinearLayout correctData;
    LinearLayout confirmFire;
    LinearLayout fireEffect;
    RecyclerView menu_list_observer_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer_home);

        //Navigation Drawer
        drawerLayout=findViewById(R.id.drawerHome);
        NavigationView navigationView =(NavigationView) findViewById(R.id.navId);
        navigationView.setNavigationItemSelectedListener(this);
        toggle=new ActionBarDrawerToggle(observerHome.this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Target Data activity
        targetData=findViewById(R.id.targetData);
        targetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_target_data();
            }
        });

        //Correct Data Activity
        correctData=findViewById(R.id.correct_Data_layout);
        correctData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_target_data();
            }
        });

        //Confirm Fire Activity
        confirmFire=findViewById(R.id.confirmFire_layout);
        confirmFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_confirm_fire();
            }
        });

        //Fire Effect Activity
        fireEffect=findViewById(R.id.fire_effect_layout);
        fireEffect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_fire_effect();
            }
        });

        //Recycler view
        menu_list_observer_home=findViewById(R.id.observer_home_recycler_view);
    }


    //Navigation Drawer
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.homeId){
            Intent intent = new Intent(this,observerHome.class);
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.notificationId){
            Intent intent = new Intent(this,observerHome.class);
            startActivity(intent);
        }

        else if(item.getItemId()==R.id.logOutId){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        return false;
    }

    //Target Data activity

    private void open_target_data() {
        Intent intent=new Intent(this,Targetdata.class);
        startActivity(intent);
    }

    //Confirm Fire activity
    private void open_confirm_fire() {
        Intent intent=new Intent(this,ConfirmFire.class);
        startActivity(intent);
    }

    //Fire Effect activity
    private void open_fire_effect() {
        Intent intent=new Intent(this,FireEffect.class);
        startActivity(intent);
    }
}
