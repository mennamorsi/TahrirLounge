package com.menna.officialtahrirlounge.Adapter;

import android.support.v4.view.PagerAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.menna.officialtahrirlounge.R;

/**
 * Created by menna on 8/15/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private int [] imgs ;
    private Context context;

    public ViewPagerAdapter(Context context,int [] imgs)
    {
        this.imgs=imgs;
        this.context=context;

    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(RelativeLayout)object);
    }


    @Override
    public Object instantiateItem(ViewGroup container,int position)
    {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v= layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView img = (ImageView)v.findViewById(R.id.img_slide);
        img.setImageResource(imgs[position]);
        container.addView(v);
        return v;
    }


    @Override
    public void destroyItem(ViewGroup container,int position,Object object)
    {
        container.invalidate();
    }



}
