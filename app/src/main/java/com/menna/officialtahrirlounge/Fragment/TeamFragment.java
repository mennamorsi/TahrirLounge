package com.menna.officialtahrirlounge.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import com.menna.officialtahrirlounge.Adapter.TeamAdapter;
import com.menna.officialtahrirlounge.R;
import com.menna.officialtahrirlounge.classes.ServiceURLs;
import com.menna.officialtahrirlounge.classes.TeamList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TeamFragment extends Fragment implements View.OnClickListener
{



    public TeamFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle SavedInstanceState)
    {
        super.onViewCreated(view,SavedInstanceState);

        final RecyclerView rec = (RecyclerView)view.findViewById(R.id.teamlist);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));

        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ServiceURLs.TEAM_URL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Log.d("on response",response);
                GsonBuilder gsonBuilder=new GsonBuilder();
                Gson gson = gsonBuilder.create();
                TeamList team=   gson.fromJson(response,TeamList .class);
                Log.d(Integer.toString(team.getTeamMemberList().length), "onResponse: ");
                rec.setAdapter(new TeamAdapter(getActivity(),team));


            }

        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(getActivity(), "something went wrong", Toast.LENGTH_SHORT).show();

            }
        }
        );
        queue.add(stringRequest);
    }

    @Override
    public void onClick(View view)
    {

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu,inflater);
       inflater.inflate(R.menu.main, menu);

    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId())

        {
            case R.id.Add: {
               /* AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("alert")
                        .setMessage("Hello from another world")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getContext(), item.getTitle() + "clicked", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton(android.R.string.cancel, null);
                builder.create().show();*/

            }
            case R.id.Edit:
               /* Bitmap largeicon = BitmapFactory.decodeResource(getResources(),R.drawable.home);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext());
                builder.setContentTitle(getString(R.string.app_name))
                        .setContentText("mkmkmkmkkkmmkm")
                        .setSmallIcon(android.R.drawable.ic_notification_clear_all)
                        .setLargeIcon(largeicon)
                        .setVibrate(new long [] {1000,1000,1000})
                        .setLights(0xFF00FF00,1000,1000);
                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getContext());
                notificationManagerCompat.notify(1,builder.build());*/

        }
        return super.onOptionsItemSelected(item);
    }

/*
    @Override
    public void onStart()
    {
        super.onStart();
        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET,ServiceURLs.EVENTS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
               Log.d("eventresponse",response);
                Gson gson=new Gson();

            }
        });

    }*/
//parclible && seralizable (bundle)
    //picasso
    //glide



}
