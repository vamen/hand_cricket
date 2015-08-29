package com.example.android.hand_cricket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;


public class res_screen extends ActionBarActivity {
    int toss_res;
    ImageView twon;
    ImageView tloss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_screen);
        twon = (ImageView) findViewById(R.id.twon);
        tloss = (ImageView) findViewById(R.id.tloss);


        Bundle bundle = getIntent().getExtras();
         toss_res= bundle.getInt("res_t");



        if(toss_res==1)
        {
            //image win
            twon.setVisibility(View.VISIBLE);
            Thread delayThread = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Intent i = new Intent(res_screen.this, uwon.class);
                    startActivity(i);
                    finish();
                }
            };
            delayThread.start();

        }
        else if(toss_res==0)
        {
        //image loss
            tloss.setVisibility(View.VISIBLE);

            Thread delayThread = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Intent i = new Intent(res_screen.this, cwon.class);
                    startActivity(i);
                    finish();
                }
            };
            delayThread.start();

        }


        else{
            Thread delayThread = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Intent i = new Intent(res_screen.this, mainplayscrn.class);
                    startActivity(i);
                    finish();
                }
            };
            delayThread.start();
        }
    }
}




