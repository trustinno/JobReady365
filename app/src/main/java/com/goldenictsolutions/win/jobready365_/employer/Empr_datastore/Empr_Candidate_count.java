package com.goldenictsolutions.win.jobready365_.employer.Empr_datastore;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by zarni on 6/13/17.
 */

public class Empr_Candidate_count implements Serializable {

    @SerializedName("job_count")
    private int job_count;

    @SerializedName("id")
    private  String id;

    @SerializedName("job_title")
    private String job_tile;

    @SerializedName("job_id")
    private String job_id;


    public Empr_Candidate_count(int job_count,String id,String job_tile,String jobid){
        this.job_count=job_count;
        this.id=id;
        this.job_tile=job_tile;
        this.job_id=jobid;
    }

    public int getJob_count(){
        return job_count;
    }

    public String getdashJob_id(){return job_id;}

    public String getId(){return id;}

    public String getJob_tile(){
        return job_tile;
    }

}
