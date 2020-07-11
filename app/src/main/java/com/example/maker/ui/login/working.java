package com.example.maker.ui.login;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.maker.MainActivity;
import com.example.maker.R;
import com.example.maker.ui.intropub.IntroActivity;
import com.example.maker.ui.intropub.MainIntroActivity;


public class working extends AppCompatActivity {

    public working() {
        // Required empty public constructor
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_working );
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button = (Button) findViewById( R.id.button25 );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( working.this, MainActivity.class );

                startActivity( intent );
            }

        } );
        Button button1 = (Button) findViewById( R.id.button28 );
        button1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( working.this, IntroActivity.class );
                startActivity( intent );
            }

        } );
    }}
