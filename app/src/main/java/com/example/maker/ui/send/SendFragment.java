package com.example.maker.ui.send;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.maker.R;
import com.example.maker.ui.ScratchCard;
import com.example.maker.ui.Utils;


public class SendFragment extends Fragment {
    private CardView cardView;
    private ScratchCard mScratchCard;
    TextView codeTxt;
    String number;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_send, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
       // ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        cardView = view.findViewById(R.id.view);
        mScratchCard = view.findViewById(R.id.scratchCard);
        codeTxt = view.findViewById(R.id.codeTxt);
        number = codeTxt.getText().toString();
        codeTxt.setText(number);
        codeTxt.setText(Utils.generateNewCode());

            mScratchCard.setOnScratchListener(new ScratchCard.OnScratchListener() {
                @Override
                public void onScratch(ScratchCard scratchCard, float visiblePercent) {
                    if (visiblePercent > 0.2) {
                        scratch(true);
                    }
                }
            });


        //    Button btn = view.findViewById( R.id.btnScratchAgain );
        // btn.setOnClickListener( new View.OnClickListener() {
        //    @Override
        //  public void onClick(View v) {
        //    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        //   fragmentTransaction.replace(R.id.nav_host_fragment,new SendFragment());

        //  fragmentTransaction.commit();
        // }
        return view;
    }



        private void scratch ( boolean isScratched){
            if (isScratched) {
            cardView.setVisibility(View.VISIBLE);
            } else {
              cardView.setVisibility(View.INVISIBLE);
            }

        }






}



