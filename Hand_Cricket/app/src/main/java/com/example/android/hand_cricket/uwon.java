package com.example.android.hand_cricket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;


public class uwon extends ActionBarActivity {
    int u_bat;
    ImageView batm;
    ImageView bowlm;
    ImageView img;
    ImageView choto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uwon);
        batm = (ImageView) findViewById(R.id.batm);
        choto = (ImageView) findViewById(R.id.choto);
        bowlm = (ImageView) findViewById(R.id.bowlm);
        img = (ImageView) findViewById(R.id.imageView5);

    }

public void bat_mtd(View v){

    u_bat=1;

    batm.setVisibility(View.VISIBLE);

    bowlm.setVisibility(View.INVISIBLE);
    img.setVisibility(View.INVISIBLE);
    choto.setVisibility(View.VISIBLE);

    Thread delayThread = new Thread() {
        @Override
        public void run() {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent i = new Intent(uwon.this, mainplayscrn.class);
            Bundle b = new Bundle();

            b.putInt("choice", u_bat);
            i.putExtras(b);
            startActivity(i);
            finish();
        }
    };
    delayThread.start();
}

    public void bowl_mtd(View v){
        u_bat=0;

        batm.setVisibility(View.INVISIBLE);

        bowlm.setVisibility(View.VISIBLE);
        img.setVisibility(View.INVISIBLE);
        choto.setVisibility(View.VISIBLE);
        Thread delayThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent i = new Intent(uwon.this, mainplayscrn.class);
                Bundle b = new Bundle();

                b.putInt("choice", u_bat);
                i.putExtras(b);
                startActivity(i);
                finish();
            }
        };
        delayThread.start();
    }


}
