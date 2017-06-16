package com.goldenictsolutions.win.jobready365_.employer.Empr_datastore;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by zarni on 5/30/17.
 */
public class Empr_JobType implements Serializable{

        @SerializedName("id")
            private int id;

        @SerializedName("type")
    private String type;

    public Empr_JobType(int id,String type)
    {
        this.id=id;
        this.type=type;
    }


    public int gettypeid(){
        return id;
    }
    public  String gettypes(){
        return type;
    }

}

