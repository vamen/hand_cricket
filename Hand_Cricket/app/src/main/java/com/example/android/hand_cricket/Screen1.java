package com.example.android.hand_cricket;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;


public class Screen1 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run(){

                Intent i=new Intent(Screen1.this,screen2.class);
                startActivity(i);
                finish();
            }
        },15*100);
    }
}

