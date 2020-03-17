package com.example.observer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Log_in_Activity extends AppCompatActivity {

    private Button button;
    private EditText user_name;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.log_in);

        button=findViewById(R.id.btLogin);
        user_name=findViewById(R.id.etUsername);
        password=findViewById(R.id.etPassword);

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
