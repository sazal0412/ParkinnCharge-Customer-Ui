package com.example.maker.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.maker.Adapter.SectionPagerAdapter;
import com.example.maker.R;
import com.example.maker.ui.privateparking;
import com.example.maker.ui.publicparking;
import com.example.maker.ui.send.SendFragment;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {


   View fragment;
   ViewPager viewPager;
   TabLayout tabLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

      fragment = inflater.inflate( R.layout.fragment_home, container, false );
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

      viewPager = fragment.findViewById(R.id.viewpager);
      // PagerAdapter mPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), 2);
       // viewPager.setAdapter(mPagerAdapter);

        tabLayout = fragment.findViewById(R.id.tab);
       // tabLayout.setupWithViewPager(viewPager);

        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void setUpViewPager(ViewPager viewPager)
    {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new privateparking(),"Parking near me");
        adapter.addFragment( new publicparking(),"Parking at malls");
        viewPager.setAdapter(adapter);
    }
}