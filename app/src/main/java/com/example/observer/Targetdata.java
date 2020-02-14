package com.example.observer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Targetdata extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    private Button cancel;
    private Button submit;
    //spinner
    private Spinner ZL_bearing;
    private Spinner OT_bearing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_targetdata);

        //Navigation Drawer
        drawerLayout = findViewById(R.id.drawerHome);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navId);
        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(Targetdata.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Spinner ZL bearing
        addListenerOnSpinnerItemSelection();

        //cancel,submit button
        cancel=findViewById(R.id.target_data_cancel_btn);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openObserverHome();
            }
        });

        submit=findViewById(R.id.target_data_submit_btn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openObserverHome();
            }
        });

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

    // add items into spinner dynamically

    public void addListenerOnSpinnerItemSelection() {
        ZL_bearing = (Spinner) findViewById(R.id.ZL_bearing_list);
        ZL_bearing.setOnItemSelectedListener(new spinner());

        OT_bearing = (Spinner) findViewById(R.id.OT_bearing_list);
        OT_bearing.setOnItemSelectedListener(new spinner());
    }

    //cancel,submit btn
    private void openObserverHome() {
        Intent intent=new Intent(this,observerHome.class);
        startActivity(intent);
    }

}
