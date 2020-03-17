package com.example.observer;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class App_Start_Activity extends AppCompatActivity {

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_ui);

        Thread splash = new Thread() {
            public void run() {
                try {
                    StartAnimations();
                    sleep(2500);
                    Intent splash = new Intent(getBaseContext(), Log_in_Activity.class);
                    startActivity(splash);
                    finish();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        splash.start();
    }


    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        RelativeLayout l = (RelativeLayout) findViewById(R.id.splashGround);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.logo);
        TextView splashBanTxt = (TextView) findViewById(R.id.splashBanTxt);
        TextView splashTitle = (TextView) findViewById(R.id.splashTitle);

        iv.clearAnimation();
        iv.startAnimation(anim);

        splashBanTxt.clearAnimation();
        splashBanTxt.startAnimation(anim);

        splashTitle.clearAnimation();
        splashTitle.startAnimation(anim);

    }
}
