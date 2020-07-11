package com.example.maker.ui;


import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.maker.R;
import com.example.maker.ui.Switchtoowner.Owner;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class publicparking extends Fragment implements ZXingScannerView.ResultHandler, AdapterView.OnItemSelectedListener {
    ZXingScannerView zXingScannerView;

    String[] mallNames={"Central Mall, Bhilai","Treasure Island Mall, Raipur","Orion Mall, Bilaspur","Magneto Mall, Korba","Reliance Digital, Durg"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_publicparking, container, false);
        Spinner spin = (Spinner) view.findViewById(R.id.spinner1);
        spin.setOnItemSelectedListener(this);


        ArrayAdapter aa = new ArrayAdapter(getContext(),R.layout.color_spinner_layout,mallNames);
        aa.setDropDownViewResource(R.layout.spinner_dropdown_layout);

        spin.setAdapter(aa);
        zXingScannerView = view.findViewById(R.id.zxscan);

       zXingScannerView.setResultHandler(this);

        final ImageButton flash_On = (ImageButton) view.findViewById(R.id.flashOn);
        final ImageButton flash_Off = (ImageButton) view.findViewById(R.id.flashOff);
        flash_Off.setVisibility(View.INVISIBLE);
        flash_On.setVisibility(View.VISIBLE);
        flash_On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zXingScannerView.setFlash(true);
                flash_Off.setVisibility(View.VISIBLE);
                flash_On.setVisibility(View.INVISIBLE);

            }
        });
        flash_Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("button","pressed");
                zXingScannerView.setFlash(false);
                flash_Off.setVisibility(View.INVISIBLE);
                flash_On.setVisibility(View.VISIBLE);

            }
        });

        return view;
    }




   @Override
    public void handleResult(Result result) {


        zXingScannerView.startCamera();

          try{
              ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION,100);
              tg.startTone(ToneGenerator.TONE_PROP_BEEP);
             }
          catch (Exception e) {
               e.printStackTrace();
             }


              if(result.getText().equals("hello")){
                  Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.nav_share);

    }}
      @Override
         public void onResume() {

            super.onResume();
            zXingScannerView.startCamera();
        }

   @Override
     public void onPause() {
        super.onPause();
        zXingScannerView.stopCamera();
        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}




