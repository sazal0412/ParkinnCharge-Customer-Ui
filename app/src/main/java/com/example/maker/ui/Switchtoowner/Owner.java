package com.example.maker.ui.Switchtoowner;

import android.Manifest;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.maker.R;
import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


//public class Owner extends AppCompatActivity {
  //  TextView tvData;
   // Button btnQRScan;

    //@Override
   // protected void onCreate(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);

      //  setContentView(R.layout.fragment_owner);
        //Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.owner123");
        //  if (launchIntent != null) {
        //    startActivity(launchIntent);//null pointer check in case package name was not found
        //  }
        // tvData=findViewById(R.id.tvData);
        //btnQRScan=findViewById(R.id.btnQRScan);

        //btnQRScan.setOnClickListener(this);
   // }
//}


public class Owner extends AppCompatActivity  {





    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.fragment_owner);


    }




}
