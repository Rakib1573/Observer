package com.example.observer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TargetHome extends Activity {

    Button go_to_maps,rectify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.target_data_instr);

        go_to_maps=findViewById(R.id.btAutoMode);
        rectify=findViewById(R.id.btManualMode);
        go_to_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TargetHome.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        rectify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TargetHome.this, TargetDataUI.class);
                startActivity(intent);
            }
        });
    }
}
