package com.menna.officialtahrirlounge.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by menna on 8/29/2017.
 */

public class TeamList
{
    @SerializedName("teamMembersList")
    @Expose
    private Team [] teamMemberList;

    public Team[] getTeamMemberList()
    {
        return teamMemberList;
    }

    public void setTeamMemberList(Team[] teamMemberList) {
        this.teamMemberList = teamMemberList;
    }
}
