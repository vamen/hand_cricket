package com.example.android.hand_cricket;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class mainplayscrn extends ActionBarActivity {
    private static int u_score;
    private static int c_score;
    int p_bat;
    int scoree_u;
    int scoree_c;
    boolean first;
    String yablimage = "yabl";
    String yabtimage = "yabt";
    TextView yscore;
    TextView cscore;
    ImageView u;
    ImageView c;
    ImageView yab;
    GridView mBgrid;
    Random r;
    String mNum[] = {"1", "2", "3", "4", "5", "6"};
    String mUser[] = {"uone", "utwo", "uthree", "ufour", "ufive", "usix"};
    String mDevice[] = {"cone", "ctwo", "cthree", "cfour", "cfive", "csix"};
    int win;
    int ran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainplayscrn);
        Bundle bundle = getIntent().getExtras();
        p_bat = bundle.getInt("choice");
        first = true;
        scoree_c = 0;
        scoree_u = 0;
        win = 0;
        yscore = (TextView) findViewById(R.id.yscore);
        cscore = (TextView) findViewById(R.id.cscore);
        yscore.setText(String.valueOf(scoree_u));
        cscore.setText(String.valueOf(scoree_c));
        u = (ImageView) findViewById(R.id.u);
        c = (ImageView) findViewById(R.id.c);
        yab = (ImageView) findViewById(R.id.yab);
        mBgrid = (GridView) findViewById(R.id.buttonview);
        ArrayList<String> marrayList = new ArrayList<>(Arrays.asList(mNum));
        ArrayAdapter mAdapter = new ArrayAdapter(getApplicationContext(), R.layout.button, marrayList);
        mBgrid.setAdapter(mAdapter);
        if (p_bat == 1) {
            int res = getResources().getIdentifier(yabtimage, "drawable", this.getPackageName());
            yab.setImageResource(res);
        } else if (p_bat == 0) {
            int res = getResources().getIdentifier(yablimage, "drawable", this.getPackageName());
            yab.setImageResource(res);
        }
        mBgrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int res1 = getResources().getIdentifier(mUser[position], "drawable", getPackageName());
                u.setImageResource(res1);
                ran = selectran();
                int res2 = getResources().getIdentifier(mDevice[ran - 1], "drawable", getPackageName());
                c.setImageResource(res2);
                if (first) {
                    if (p_bat == 1) {
                        if (ran - 1 == position) {
                            Log.d("WAIT", "**" + position + "**" + ran + "**");
                            FragmentManager manager = getFragmentManager();
                            Outdialog outdialog = new Outdialog();
                            outdialog.show(manager, "out");
                            if (p_bat == 1) {
                                p_bat = 0;
                                int res = getResources().getIdentifier(yablimage, "drawable", getPackageName());
                                yab.setImageResource(res);
                            }
                            first = false;
                        } else {
                            u_score = u_score + (position + 1);
                            yscore.setText(u_score + " ");
                        }
                    } else {
                        if (ran - 1 == position) {
                            Log.d("WAIT", "**" + position + "**" + ran + "**");
                            FragmentManager manager = getFragmentManager();
                            Outdialog outdialog = new Outdialog();
                            outdialog.show(manager, "out");
                            p_bat = 1;
                            first = false;
                            int res = getResources().getIdentifier(yabtimage, "drawable", getPackageName());
                            yab.setImageResource(res);
                        } else {
                            c_score = c_score + ran;
                            cscore.setText(c_score + " ");
                        }
                    }
                } else if (!first) {

                    if (p_bat == 1) {
                        Log.d("Match", "end");
                        if (ran - 1 == position) {
                            c_score = 0;
                            u_score = 0;
                            Intent i = new Intent(mainplayscrn.this, result.class);
                            Bundle b = new Bundle();
                            b.putInt("result", 0);
                            i.putExtras(b);
                            startActivity(i);
                            finish();
                        }
                        if (c_score <= u_score) {
                            c_score = 0;
                            u_score = 0;
                            Intent i = new Intent(mainplayscrn.this, result.class);
                            Bundle b = new Bundle();
                            b.putInt("result", 1);
                            i.putExtras(b);
                            startActivity(i);
                            finish();
                        } else {
                            u_score = u_score + (position + 1);
                            yscore.setText(u_score + " ");
                        }

                    } else {
                        if (c_score >= u_score) {
                            c_score = 0;
                            u_score = 0;
                            Intent i = new Intent(mainplayscrn.this, result.class);
                            Bundle b = new Bundle();
                            b.putInt("result", 0);
                            i.putExtras(b);
                            startActivity(i);
                            finish();
                        } else {

                            c_score = c_score + ran;
                            cscore.setText(c_score + " ");
                        }
                        if (ran - 1 == position) {
                            Log.d("Match", "end");
                            c_score = 0;
                            u_score = 0;
                            Intent i = new Intent(mainplayscrn.this, result.class);
                            Bundle b = new Bundle();
                            b.putInt("result", 1);
                            i.putExtras(b);
                            startActivity(i);
                            finish();
                        }
                    }
                }
            }
        });
    }

    public int selectran() {
        r = new Random();
        return r.nextInt(7 - 1) + 1;
    }
}
