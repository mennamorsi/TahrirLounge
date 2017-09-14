package com.menna.officialtahrirlounge.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.menna.officialtahrirlounge.R;

/**
 * Created by menna on 9/14/2017.
 */

public class AlbumAdapter extends BaseAdapter
{
    private Context context;
    private String [] imgs;
    public AlbumAdapter(Context context, String[] imgs)
    {
        this.context=context;
        this.imgs=imgs;

    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int i) {
        return imgs[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View  view, ViewGroup viewGroup)
    {
        View grid=view;
        if(grid==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            grid=inflater.inflate(R.layout.album_layout,null);
        }
        ImageView imageView = new ImageView(context);
        Glide.with(context)
                .asBitmap()
                .load(imgs[i])
                .into(imageView);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(240, 240));
        return imageView;

    }
}
