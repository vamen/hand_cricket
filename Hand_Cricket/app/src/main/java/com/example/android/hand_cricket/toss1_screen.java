package com.example.android.hand_cricket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;


public class toss1_screen extends ActionBarActivity {



    ImageView tossm;
    ImageView tossh;
    ImageView tosst;
    ImageView res;
    ImageView headt;
    ImageView tailt;
Random r;
    int rn;
    int u_ch;
    int c_ch;
    int t_win;

     public void tossfn() {
         if (rn % 2 == 0)
         {
            c_ch=2;//tails
             Thread delayThread = new Thread() {
                 @Override
             public void run()
                 {
                     try {
                         Thread.sleep(1000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }

             };
             delayThread.start();
             res.setVisibility(View.VISIBLE);

             tossm.setVisibility(View.INVISIBLE);

             tossh.setVisibility(View.INVISIBLE);

             tosst.setVisibility(View.VISIBLE);

         }
         else{
             c_ch=1;//heads
             Thread delayThread = new Thread() {
                 @Override
             public void run()
                 {
                     try {
                         Thread.sleep(1000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             };
             delayThread.start();
             res.setVisibility(View.VISIBLE);

             tossm.setVisibility(View.INVISIBLE);

             tossh.setVisibility(View.VISIBLE);

             tosst.setVisibility(View.INVISIBLE);

         }
        if(c_ch==u_ch) {
            t_win=1;
            Thread delayThread = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }

                    Intent i=new Intent(toss1_screen.this,res_screen.class);
                    Bundle b = new Bundle();

                    b.putInt("res_t",t_win);
                    i.putExtras(b);
                    startActivity(i);
                    finish();
                }
            };
            delayThread.start();
        }
         else
        {
            t_win=0;

            Thread delayThread = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }

                    Intent i=new Intent(toss1_screen.this,res_screen.class);

                    Bundle b = new Bundle();

                    b.putInt("res_t",t_win);
                    i.putExtras(b);
                    startActivity(i);
                    finish();
                }
            };
            delayThread.start();
        }

     }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss1_screen);
        tossm = (ImageView) findViewById(R.id.tossm);
        tossh = (ImageView) findViewById(R.id.tossh);
        tosst = (ImageView) findViewById(R.id.tosst);
        headt = (ImageView) findViewById(R.id.headt);
        tailt = (ImageView) findViewById(R.id.tailt);
        res = (ImageView) findViewById(R.id.res);
        r=new Random();
        rn=r.nextInt(5-1);
    }










public void choose_head(View v){
u_ch=1;

    tailt.setVisibility(View.INVISIBLE);
    headt.setVisibility(View.INVISIBLE);
    tossfn();
}

public void choose_tail(View v)
{
    u_ch=2;
    tailt.setVisibility(View.INVISIBLE);
    headt.setVisibility(View.INVISIBLE);
    tossfn();
}




}
