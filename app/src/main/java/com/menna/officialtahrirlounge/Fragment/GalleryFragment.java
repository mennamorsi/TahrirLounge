package com.menna.officialtahrirlounge.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.menna.officialtahrirlounge.Adapter.GalleryAdapter;
import com.menna.officialtahrirlounge.R;
import com.menna.officialtahrirlounge.activity.AlbumActivity;
import com.menna.officialtahrirlounge.classes.Gallery;
import com.menna.officialtahrirlounge.classes.ServiceURLs;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {
    Gallery[] galleries;
    GridView gridView;
    //GalleryAdapter galleryAdapter;
    //ArrayList<Gallery> galleryArrayList;
    // array of images
   // int[] images = {R.mipmap.cat, R.mipmap.c, R.mipmap.b,R.mipmap.dbdob,R.mipmap.images};

    public GalleryFragment()
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
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        /*


        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ServiceURLs.EVENTS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                Log.d("onresponse",response);
                GsonBuilder gsonBuilder=new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Events[] events=   gson.fromJson(response,Events[].class);
                recyclerView.setAdapter(new EventsAdapter(getActivity(),events));


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(getActivity(), "something went wrong", Toast.LENGTH_SHORT).show();

            }
        }
        );
        queue.add(stringRequest);
         */






        final GridView gridView =view.findViewById(R.id.gallery);
      //  gridView.setAdapter(new GalleryAdapter(getContext()));
        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ServiceURLs.WORKSHOPS_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response)
            {
                Log.d("onresponse",response);
                GsonBuilder gsonBuilder=new GsonBuilder();
                Gson gson = gsonBuilder.create();
               galleries=   gson.fromJson(response,Gallery[].class);
                gridView.setAdapter(new GalleryAdapter(getActivity(), galleries));


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(getActivity(), "something went wrong", Toast.LENGTH_SHORT).show();

            }
        }
        );
        queue.add(stringRequest);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
                                                {
                                                    String [] imgs= galleries[i].getGallery();
                                                    Bundle bundle=new Bundle();
                                                    bundle.putStringArray("imgs",imgs);
                                                    Intent intent = new Intent(getContext(), AlbumActivity.class);
                                                    intent.putExtra("imgs", bundle);
                                                    startActivity(intent);


                                                }
                                            });
      //  {
         /*   @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {

                AlbumFragment fragment = new AlbumFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction ft= fragmentManager.beginTransaction();
                ft.replace(R.id.frame,fragment).commit();

            }*/

         /*    @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent = new Intent(getContext(), AlbumActivity.class);
                           // intent.putExtra("id",i);
                            startActivity(intent);
                        }


        });
        */



    }
}
