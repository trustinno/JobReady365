package com.goldenictsolutions.win.jobready365_.employer.Empr_datastore;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by zarni on 5/25/17.
 */
public class Empr_Township implements Serializable{
    @SerializedName("id")
    private int id;
    @SerializedName("township")
    private String township;
    @SerializedName("city_id")
    private String country_id;


    public Empr_Township(int id, String city,String country_id) {
        this.id = id;
        this.township = city;
        this.country_id=country_id;
    }
    public String gettown(){
        return township;
    }
    public int getid(){
        return id;
    }



}
