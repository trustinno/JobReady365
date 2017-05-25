package com.goldenictsolutions.win.jobready365_.employer.Empr_datastore;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by zarni on 5/25/17.
 */

public class Empr_Businesstype implements Serializable{
    @SerializedName("id")
    private int bus_id;

    @SerializedName("job_industry")
    private String job_industry;

    public Empr_Businesstype(int id,String job_industry)
    {
        this.bus_id=id;
        this.job_industry=job_industry;
    }

    public int getBus_id()
    {
        return bus_id;

    }

    public  String getJob_industry()
    {
        return getJob_industry();
    }
}
