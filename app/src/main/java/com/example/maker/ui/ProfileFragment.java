package com.example.maker.ui;

import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.maker.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment  {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
        CardView cardView = view.findViewById(R.id.pro);
        cardView.setBackgroundResource(R.drawable.customcard1);

        final CardView textView1 = (CardView) view.findViewById(R.id.textView128);
        final CardView textView2 = (CardView) view.findViewById(R.id.pro);
        final TextView textView = (TextView) view.findViewById(R.id.imageView10);
        textView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textView1.setVisibility(View.VISIBLE);
                    }
                    //Dialog.setContentView( R.layout.fragment_more );
                    // Dialog.show();}
                });
                textView2.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textView1.setVisibility(View.INVISIBLE);
                    }
                    //Dialog.setContentView( R.layout.fragment_more );
                    // Dialog.show();}
                });

                return view;
            }

        }