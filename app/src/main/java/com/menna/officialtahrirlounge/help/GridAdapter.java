package com.menna.officialtahrirlounge.help;

import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.menna.officialtahrirlounge.R;


/**
 * Created by menna on 8/17/2017.
 */

public class GridAdapter extends BaseAdapter
{

    Context context;
    int[] images = { R.mipmap.e,R.mipmap.a,R.mipmap.c,R.mipmap.d };


    public GridAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

return view;

    }
}
