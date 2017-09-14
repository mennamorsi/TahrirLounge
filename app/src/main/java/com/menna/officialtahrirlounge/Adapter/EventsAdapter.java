package com.menna.officialtahrirlounge.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.menna.officialtahrirlounge.R;
import com.menna.officialtahrirlounge.activity.EventActivity;
import com.menna.officialtahrirlounge.classes.Events;



/**
 * Created by menna on 8/27/2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsViewHolder> {

    private Context context;
    private Events[] data;
    private String title;
    private String date;
    private String trainer;
    private String description;
    private String cover;

    public EventsAdapter(Context context, Events[] data)
    {
        this.context=context;
        this.data=data;
    }

    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.events_layout,parent,false);
        return new EventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventsViewHolder holder, int position)
    {
        final Events events = data[position];
        holder.titleevent.setText(events.getEventName());
        holder.discevent.setText(events.getEventDetails());
        holder.trainerevent.setText(events.getEventInstractor());
        holder.dateevent.setText(events.getEventDate());
        Glide.with(context)
                .asBitmap()
                .load(events.getEventImage())
                .into(holder.imgevent);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               // Toast.makeText(context, events.getEventName()+"was clicked", Toast.LENGTH_SHORT).show();
                title = events.getEventName();
                date = events.getEventDate();
                trainer = events.getEventInstractor();
                description=events.getEventDetails();
                cover=events.getEventImage();
                Bundle bundle=new Bundle();
                bundle.putString("title",title);
                bundle.putString("date",date);
                bundle.putString("trainer",trainer);
                bundle.putString("description",description);
                bundle.putString("cover",cover);
              /*  EventFragment fragment = new EventFragment();
                fragment.setArguments(bundle);
                ((AppCompatActivity) context).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, fragment)
                        .commit();*/

                Intent in = new Intent(context, EventActivity.class);
                in.putExtra("bundle", bundle);
                context.startActivity(in);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class EventsViewHolder extends RecyclerView.ViewHolder {
        ImageView imgevent;
        TextView titleevent;
        TextView discevent;
        TextView trainerevent;
        TextView dateevent;
        public EventsViewHolder(View itemView)
        {
            super(itemView);
            imgevent=(ImageView)itemView.findViewById(R.id.img_card);
            titleevent = (TextView)itemView.findViewById(R.id.title_card);
            discevent = (TextView)itemView.findViewById(R.id.disc_card);
            trainerevent=(TextView)itemView.findViewById(R.id.trainer);
            dateevent=(TextView)itemView.findViewById(R.id.date);
        }
    }
}
