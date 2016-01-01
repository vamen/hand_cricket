package com.example.android.hand_cricket;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Vivek Balachandran on 10/13/2015.
 */
public class Outdialog extends DialogFragment implements View.OnClickListener{

    Button okbutton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         View view=inflater.inflate(R.layout.dialog, null);
        okbutton=(Button)view.findViewById(R.id.okbtn);
        setCancelable(false);
        okbutton.setOnClickListener(this);
        return view;


    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
