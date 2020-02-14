package com.example.observer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class Targetdata extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_targetdata);

        //Navigation Drawer
        drawerLayout=findViewById(R.id.drawerHome);
        NavigationView navigationView =(NavigationView) findViewById(R.id.navId);
        navigationView.setNavigationItemSelectedListener(this);
        toggle=new ActionBarDrawerToggle(Targetdata.this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

}
