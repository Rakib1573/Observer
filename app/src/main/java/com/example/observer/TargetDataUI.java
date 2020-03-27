package com.example.observer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TargetDataUI extends Activity {

    private EditText OEast,ONorth,EEast,ENorth,OTBG,Rt,Add;
    private Button submit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.target_data_ui);
        OEast = findViewById(R.id.etOwnEast);
        ONorth = findViewById(R.id.etOwnNorth);
        EEast = findViewById(R.id.etTargetEast);
        ENorth = findViewById(R.id.etTargetNorth);
        OTBG = findViewById(R.id.etOTbg);
        Rt = findViewById(R.id.etAdd);
        Add = findViewById(R.id.etDrop);
        submit=findViewById(R.id.btAutoMode);
        Bundle bundle = getIntent().getExtras();
        if (bundle!= null) {
            OEast = findViewById(R.id.etOwnEast);
            ONorth = findViewById(R.id.etOwnNorth);
            EEast = findViewById(R.id.etTargetEast);
            ENorth = findViewById(R.id.etTargetNorth);
            OTBG = findViewById(R.id.etOTbg);
            String ownEast = bundle.getString("et1");
            String ownNorth = bundle.getString("et2");
            String enEast = bundle.getString("et3");
            String enNorth = bundle.getString("et4");
            String otBg = bundle.getString("et5");
            OEast.setText(ownEast);
            ONorth.setText(ownNorth);
            EEast.setText(enEast);
            ENorth.setText(enNorth);
            OTBG.setText(otBg);
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }

    //Send data to database
    private void sendData() {
        String Own_Easting = OEast.getText().toString();
        String Own_Northing = ONorth.getText().toString();
        String En_Easting = EEast.getText().toString();
        String En_nothing = ENorth.getText().toString();
        String OTbg = OTBG.getText().toString();
        String rt=Rt.getText().toString();
        String add=Add.getText().toString();

        DB bg = new DB(this);
        bg.execute(Own_Easting,Own_Northing,En_Easting,En_nothing
                ,OTbg,rt,add);

    }
}
