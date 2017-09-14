package com.menna.officialtahrirlounge.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.menna.officialtahrirlounge.R;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       Bundle bundle= getIntent().getBundleExtra("bundle");
        String title =bundle.getString("title");
        String date =bundle.getString("date");
        String trainer =bundle.getString("trainer");
        String description =bundle.getString("description");
        String image =bundle.getString("cover");
        TextView titletext= (TextView) findViewById(R.id.eventtitle);
        TextView datetext = (TextView) findViewById(R.id.eventdate);
        TextView trainertext = (TextView) findViewById(R.id.eventtrainer);
        TextView descriptiontext = (TextView) findViewById(R.id.eventdesc);
        ImageView imageview = (ImageView) findViewById(R.id.eventcover);

        titletext.setText(title);
        datetext.setText(date);
        trainertext.setText(trainer);
        descriptiontext.setText(description);
        //    imagetext.setText(image);
        Glide.with(this)
                .asBitmap()
                .load(image)
                .into(imageview);
    }


}
