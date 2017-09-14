package com.menna.officialtahrirlounge.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.menna.officialtahrirlounge.R;
import com.menna.officialtahrirlounge.classes.Gallery;

/**
 * Created by menna on 9/9/2017.
 */

public class GalleryAdapter extends BaseAdapter
{
    private Context context;
   private Gallery [] galleries;

    //  public int [] imgs ={R.mipmap.a,R.mipmap.b,R.mipmap.c};
  //  public String[] name={"worwshop 1","workshop 2","workshop 3"};


    public GalleryAdapter(Context context,Gallery [] galleries)
    {

        this.context=context;
        this.galleries=galleries;

    }


    @Override
    public int getCount() {
        return galleries.length;
    }

    @Override
    public Object getItem(int i) {
        return galleries[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {

        if(view==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.gallery_layout,null);
        }
            Log.d(galleries[i].getName(), "*********************getView: **************");
           // ImageView imageView = new ImageView(context);
        ImageView imageView=(ImageView)view.findViewById(R.id.galleryimg);
        TextView txt= (TextView)view.findViewById(R.id.n);
        txt.setText(galleries[i].getName());
            Glide.with(context)
                    .asBitmap()
                    .load(galleries[i].getGallery(0))
                    .into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return view;
    }




}
