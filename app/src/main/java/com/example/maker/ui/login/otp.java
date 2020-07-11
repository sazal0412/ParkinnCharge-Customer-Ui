package com.example.maker.ui.login;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.maker.MainActivity;
import com.example.maker.R;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class otp extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 16000;
    private TextView mTextViewCountDown;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimerLeftInMillis = START_TIME_IN_MILLIS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_otp );
        this.getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );

        try{
            this.getSupportActionBar().hide();
        }catch (Exception e){

        }
        Button button = (Button) findViewById( R.id.button24 );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( otp.this,working.class );

                startActivity( intent );
            }

        } );
        mTextViewCountDown = (TextView) findViewById( R.id.textView129 );
        mCountDownTimer = new CountDownTimer( mTimerLeftInMillis, 1000 ) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimerLeftInMillis = millisUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {

            }
        }.start();
        mTimerRunning = true;

            }

            private void updateCountDownText(){
              int minutes = (int) (mTimerLeftInMillis/1000)/60;
                int seconds  = (int) (mTimerLeftInMillis/1000)%60;
                String timeLeftFormatted = String.format( Locale.getDefault(),"Resend OTP in %02d:%02d",minutes,seconds);
                mTextViewCountDown.setText(timeLeftFormatted);
            }


    }


