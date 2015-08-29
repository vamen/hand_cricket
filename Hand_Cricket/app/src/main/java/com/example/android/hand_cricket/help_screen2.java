package com.example.android.hand_cricket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class help_screen2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen2);
    }


    public void help_2(View v){

        startActivity(new Intent(help_screen2.this,Menu.class));
    }
}
