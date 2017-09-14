package com.menna.officialtahrirlounge.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.menna.officialtahrirlounge.R;

public class FullImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        final Bundle bundle = getIntent().getBundleExtra("img");
        String  img = bundle.getString("img");
        ImageView imageView = (ImageView)findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(img)
                .into(imageView);
    }
}
