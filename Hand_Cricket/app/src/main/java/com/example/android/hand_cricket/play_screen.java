package com.example.android.hand_cricket;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;


public class play_screen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run(){

                Intent i=new Intent(play_screen.this,toss1_screen.class);
                startActivity(i);
                finish();
            }
        },7*100);
    }
}

