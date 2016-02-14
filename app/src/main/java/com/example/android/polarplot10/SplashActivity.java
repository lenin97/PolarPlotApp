package com.example.android.polarplot10;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       // ImageView iv= (ImageView)findViewById(R.id.id_iv_sicon);
        //iv.setBackgroundResource(R.mipmap.ic_bullrh);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//sin mascara
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, Splash2Activity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}
