package com.menna.officialtahrirlounge.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.menna.officialtahrirlounge.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment implements View.OnClickListener
{

    ImageView facebook;
    ImageView Youtube;
    ImageView twitter;



    public AboutUsFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_us, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ImageView facebook = (ImageView)view.findViewById(R.id.facebook);
        ImageView twitter = (ImageView)view.findViewById(R.id.twitter);
        ImageView youtube = (ImageView)view.findViewById(R.id.youtube);
        facebook.setOnClickListener(this);
        twitter.setOnClickListener(this);
        youtube.setOnClickListener(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View view)
    { switch (view.getId())
    {
        case (R.id.facebook):
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/TahrirLounge/"));
            startActivity(intent);
            break;
        }

        case (R.id.twitter):
        {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/tahrirlounge"));
            startActivity(intent);
            break;
        }

        case (R.id.youtube):
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/Tahrirlounge"));
            startActivity(intent);
            break;
        }

    }

    }
}
