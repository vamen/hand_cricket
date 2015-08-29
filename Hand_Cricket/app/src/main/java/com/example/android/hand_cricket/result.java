package com.example.android.hand_cricket;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;


public class result extends ActionBarActivity {
int game_result;
    ImageView won;
    ImageView lost;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        won= (ImageView) findViewById(R.id.wwon);
        lost= (ImageView) findViewById(R.id.llost);
        Bundle bundle = getIntent().getExtras();
        game_result= bundle.getInt("result");

        if(game_result==1)
        {
            won.setVisibility(View.VISIBLE);

            lost.setVisibility(View.INVISIBLE);
        }
        else if(game_result==0)
        {
            won.setVisibility(View.INVISIBLE);

            lost.setVisibility(View.VISIBLE);
        }

    }





}
