package com.example.maker.ui.share;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.maker.R;
import com.example.maker.ui.login.otp;

import java.io.OutputStream;

public class ShareFragment extends Fragment {



    @SuppressLint("WrongThread")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final Bitmap mBitmap = null;
        View view = inflater.inflate( R.layout.fragment_share1, container, false );
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
        Button button = (Button) view.findViewById( R.id.button23);
        final TextView textView = (TextView) view.findViewById(R.id.textView22);
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = textView.getText().toString();
                Intent mSharingIntent = new Intent(Intent.ACTION_SEND);

                mSharingIntent.setType("text/plain");
                mSharingIntent.putExtra(Intent.EXTRA_SUBJECT,"YOUR PROMOCODE");
                mSharingIntent.putExtra(Intent.EXTRA_TEXT, String.format("Hello there ! I have been enjoying using ParkInnCharge app. Download the app using the link  and use the promocode  %s .", text));
                startActivity(Intent.createChooser(mSharingIntent,"Share via"));



            }
        });

        return view;
    }



}