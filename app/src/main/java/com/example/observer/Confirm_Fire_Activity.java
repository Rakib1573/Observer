package com.example.observer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Confirm_Fire_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Dialog myDialog;
    Dialog myDialog_cancel_fire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_fire);
        myDialog = new Dialog(this);
        myDialog_cancel_fire = new Dialog(this);

        //Navigation Drawer
        drawerLayout = findViewById(R.id.drawerHome);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navId);
        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(Confirm_Fire_Activity.this, drawerLayout, R.string.open, R.string.close);
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
            Intent intent = new Intent(this, Observer_Home_Activity.class);
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.notificationId){
            Intent intent = new Intent(this, Observer_Home_Activity.class);
            startActivity(intent);
        }

        else if(item.getItemId()==R.id.logOutId){
            Intent intent = new Intent(this, Log_in_Activity.class);
            startActivity(intent);
        }
        return false;
    }

    //pop up message confirm FIre
    public void ShowPopup(View v) {
        TextView txtclose;
        Button btnFollow;

        myDialog.setContentView(R.layout.pop_up_message_confirm_fire);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        btnFollow = (Button) myDialog.findViewById(R.id.pop_target_data_submit_btn);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }


    public void pop_submit(View view) {
        Intent intent = new Intent(this, Observer_Home_Activity.class);
        startActivity(intent);
    }


    //pop up cancel Fire
    public void pop_cancel_fire(View view) {

        TextView txtclose_cancel_fire;
        Button pop_confirm_cancel_fire;

        myDialog_cancel_fire.setContentView(R.layout.popup_msg_cancel_fire);
        txtclose_cancel_fire =(TextView) myDialog_cancel_fire.findViewById(R.id.txtclose_cancel_fire);
        txtclose_cancel_fire.setText("X");
        pop_confirm_cancel_fire= (Button) myDialog_cancel_fire.findViewById(R.id.pop_cancel_fire_submit_btn);
        txtclose_cancel_fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog_cancel_fire.dismiss();
            }
        });
        myDialog_cancel_fire.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog_cancel_fire.show();
    }

    public void pop_cancel_fire_confirm(View view) {
        Intent intent = new Intent(this, Observer_Home_Activity.class);
        startActivity(intent);
    }
}
