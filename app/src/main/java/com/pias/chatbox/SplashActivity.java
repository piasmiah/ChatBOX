package com.pias.chatbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);

        //start main screen after 3 second
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //start main screen
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        },3000);
    }
}