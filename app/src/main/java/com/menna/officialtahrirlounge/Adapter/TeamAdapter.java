package com.menna.officialtahrirlounge.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.menna.officialtahrirlounge.R;
import com.menna.officialtahrirlounge.classes.Team;
import com.menna.officialtahrirlounge.classes.TeamList;

/**
 * Created by menna on 8/28/2017.
 */

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder>
{
    private Context context;
    private TeamList data;
    public TeamAdapter(Context context, TeamList data)
    {
        this.context=context;
        this.data=data;
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.team_layout,parent,false);
        return new TeamAdapter.TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TeamViewHolder holder, int position)
    {
        final Team team=data.getTeamMemberList()[position];
        holder.username.setText(team.getName());
        holder.position.setText(team.getPosition());
        Glide.with(context)
                .asBitmap()
                .load("http://"+team.getImage())
                .into(holder.profile);


    }

    @Override
    public int getItemCount()
    {
        return data.getTeamMemberList().length;
    }


    public class TeamViewHolder extends RecyclerView.ViewHolder
    {
        TextView username ;
        TextView position;
        ImageView profile;

        public TeamViewHolder(View itemView)
        {

            super(itemView);
            username=itemView.findViewById(R.id.username);
            position=itemView.findViewById(R.id.position);
            profile=itemView.findViewById(R.id.userimg);
        }
    }


}
