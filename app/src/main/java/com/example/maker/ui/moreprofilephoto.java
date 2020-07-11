package com.example.maker.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.maker.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class moreprofilephoto extends DialogFragment

    {


        public View onCreateView (@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.moreprofilephoto, container, false);


    return view;
        }
       }
