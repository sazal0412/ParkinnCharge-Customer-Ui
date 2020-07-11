package com.example.maker.ui.login;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.example.maker.R;


public class intro extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_intro );
        this.getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        try{
            this.getSupportActionBar().hide();
        }catch (Exception e){

        }
        Handler handler = new Handler( );
        handler.postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent a = new Intent(intro.this , loginfragment.class );
                startActivity( a );
                finish();
            }
        }, 3000);



    }

}
