package com.example.observer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Log_in_Activity extends AppCompatActivity {

    private ImageButton btRegister;
    private Button button;
    private EditText user_name;
    private EditText password;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.log_in);

        btRegister  = findViewById(R.id.btRegister);
        button=findViewById(R.id.btLogin);
        user_name=findViewById(R.id.etUsername);
        password=findViewById(R.id.etPassword);
        tvLogin     = findViewById(R.id.tvLogin);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_register();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user_name.getText().toString().equals("admin") && password.getText().toString().equals("1234")){
                    Intent intent=new Intent(Log_in_Activity.this, Main_Home_Activity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void open_register() {
        Intent intent=new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
