package com.example.observer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Log_in_Activity extends AppCompatActivity {

    private Button button;
    private EditText user_name;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.login);
        user_name=findViewById(R.id.username);
        password=findViewById(R.id.password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user_name.getText().toString().equals("admin") && password.getText().toString().equals("1234")){
                    Intent intent=new Intent(Log_in_Activity.this, Observer_Home_Activity.class);
                    startActivity(intent);
                }
            }
        });
    }
}