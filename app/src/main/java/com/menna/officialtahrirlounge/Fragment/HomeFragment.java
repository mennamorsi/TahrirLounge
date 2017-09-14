package com.menna.officialtahrirlounge.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.menna.officialtahrirlounge.Adapter.ViewPagerAdapter;
import com.menna.officialtahrirlounge.R;

import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment
{

    ViewPager viewPager;
    int [] imgs;
    int count=1;


    public  class MyTimerTask extends TimerTask
    {
        @Override
        public void run() {
            if(isVisible())  {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (imgs.length != 0) {
                            if (count < imgs.length)
                                viewPager.setCurrentItem(count++);
                            else {
                                count = 0;
                                viewPager.setCurrentItem(count++);
                            }
                        }


                    }
                });
            }

        }}

    public HomeFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        viewPager =(ViewPager)view.findViewById(R.id.viewpager);
        imgs= new int[]{R.mipmap.a, R.mipmap.b, R.mipmap.c,R.mipmap.d,R.mipmap.e,R.mipmap.f,R.mipmap.h};
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getContext(),imgs);
        viewPager.setAdapter(viewPagerAdapter);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),1000,5000);

        super.onViewCreated(view, savedInstanceState);
    }

}
