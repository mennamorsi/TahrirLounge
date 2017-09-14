package com.menna.officialtahrirlounge.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.menna.officialtahrirlounge.Adapter.EventsAdapter;
import com.menna.officialtahrirlounge.classes.Events;
import com.menna.officialtahrirlounge.R;
import com.menna.officialtahrirlounge.classes.ServiceURLs;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment
{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public EventsFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.eventlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

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
    }
}
