package com.example.maker.ui;

import android.os.Bundle;
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
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.maker.R;
import com.example.maker.premium_proceedbook;
import com.example.maker.ui.login.loginfragment;

public class PremiumparkingFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_premiumparking, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
        CardView cardView = view.findViewById(R.id.card13);
        cardView.setBackgroundResource(R.drawable.customcard);
        CardView cardView1 = view.findViewById(R.id.card14);
        cardView1.setBackgroundResource(R.drawable.customcard1);
        Button button = (Button) view.findViewById( R.id.proceedtobook );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.premium_proceedbook);


            }
        });
        return view;


    }

}
