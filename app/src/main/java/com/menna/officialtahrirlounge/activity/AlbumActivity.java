package com.menna.officialtahrirlounge.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.menna.officialtahrirlounge.Adapter.AlbumAdapter;
import com.menna.officialtahrirlounge.R;

public class AlbumActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);


        final Bundle bundle = getIntent().getBundleExtra("imgs");
        final String[] imgs = bundle.getStringArray("imgs");
        GridView gridView = (GridView) findViewById(R.id.album);
        gridView.setAdapter(new AlbumAdapter(this, imgs));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), FullImageActivity.class);
                Bundle bundle1=new Bundle();
                bundle.putString("img",imgs[i]);
                intent.putExtra("img", bundle);
                startActivity(intent);
            }

        });
    }
}
