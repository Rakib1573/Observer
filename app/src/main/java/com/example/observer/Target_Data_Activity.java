package com.example.observer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Target_Data_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    private Button cancel;
    private Button submit;
    //spinner
    private Spinner ZL_bearing;
    private Spinner OT_bearing;
    EditText target_GR_easting,target_GR_Northing,gun_loc_GR_easting,gun_loc_GR_Northing,ZL_bearing_edit_text,OT_bearing_edit_text, corr_RT_LT_edit_text,corr_ADD_DROP_edit_text;
    Spinner ZL_bearing_list,OT_bearing_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.target_data);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        //Navigation Drawer
        drawerLayout = findViewById(R.id.drawerHome);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navId);
        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(Target_Data_Activity.this, drawerLayout, R.string.open, R.string.close);
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
                sendData();
            }
        });

        target_GR_easting=findViewById(R.id.target_GR_easting);
        target_GR_Northing=findViewById(R.id.target_GR_Northing);
        gun_loc_GR_easting=findViewById(R.id.gun_loc_GR_easting);
        gun_loc_GR_Northing=findViewById(R.id.gun_loc_GR_Northing);
        ZL_bearing_edit_text=findViewById(R.id.ZL_bearing_edit_text);
        OT_bearing_edit_text=findViewById(R.id.OT_bearing_edit_text);
        corr_RT_LT_edit_text=findViewById(R.id.corr_RT_LT_edit_text);
        corr_ADD_DROP_edit_text=findViewById(R.id.corr_ADD_DROP_edit_text);
        ZL_bearing_list=findViewById(R.id.ZL_bearing_list);
        OT_bearing_list=findViewById(R.id.OT_bearing_list);

    }
    //Send data to database
    private void sendData() {
        String Tgt_Easting = target_GR_easting.getText().toString();
        String Tgt_Northing = target_GR_Northing.getText().toString();
        String Gun_Easting = gun_loc_GR_easting.getText().toString();
        String Gun_nothing = gun_loc_GR_Northing.getText().toString();
        String ZLbg = ZL_bearing_edit_text.getText().toString();
        String ZL_deg_mil = ZL_bearing_list.getSelectedItem().toString();
        String OTbg = OT_bearing_edit_text.getText().toString();
        String OT_deg_mil = OT_bearing_list.getSelectedItem().toString();
        String corr_rt_lt = corr_RT_LT_edit_text.getText().toString();
        String corr_add_drop = corr_ADD_DROP_edit_text.getText().toString();

        BackgroundTaskTargetData bg = new BackgroundTaskTargetData(this);
        bg.execute(Tgt_Easting,Tgt_Northing,Gun_Easting,Gun_nothing
                ,ZLbg,ZL_deg_mil,OTbg,OT_deg_mil, corr_rt_lt,corr_add_drop);

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

    // add items into spinner dynamically

    public void addListenerOnSpinnerItemSelection() {
        ZL_bearing = (Spinner) findViewById(R.id.ZL_bearing_list);
        ZL_bearing.setOnItemSelectedListener(new spinner());

        OT_bearing = (Spinner) findViewById(R.id.OT_bearing_list);
        OT_bearing.setOnItemSelectedListener(new spinner());
    }

    //cancel,submit btn
    private void openObserverHome() {
        Intent intent=new Intent(this, Observer_Home_Activity.class);
        startActivity(intent);
    }

}
