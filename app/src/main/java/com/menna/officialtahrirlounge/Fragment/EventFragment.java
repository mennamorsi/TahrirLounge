package com.menna.officialtahrirlounge.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.menna.officialtahrirlounge.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {


    public EventFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                            @Nullable Bundle savedInstanceState)
    {
        View rootview=inflater.inflate(R.layout.fragment_event, container, false);
        // Inflate the layout for this fragment
        Bundle bundle=getArguments();
        String title =bundle.getString("title");
        String date =bundle.getString("date");
        String trainer =bundle.getString("trainer");
        String description =bundle.getString("description");
        String image =bundle.getString("cover");
        TextView titletext=rootview.findViewById(R.id.eventtitle);
        TextView datetext = rootview.findViewById(R.id.eventdate);
        TextView trainertext = rootview.findViewById(R.id.eventtrainer);
        TextView descriptiontext = rootview.findViewById(R.id.eventdesc);
        ImageView imageview = rootview.findViewById(R.id.eventcover);

        titletext.setText(title);
        datetext.setText(date);
        trainertext.setText(trainer);
        descriptiontext.setText(description);
    //    imagetext.setText(image);
        Glide.with(getContext())
                .asBitmap()
                .load(image)
                .into(imageview);
        return rootview;

    }

}
