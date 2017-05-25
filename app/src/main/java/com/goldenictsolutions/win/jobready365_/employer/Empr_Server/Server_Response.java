package com.goldenictsolutions.win.jobready365_.employer.Empr_Server;

import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_City;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_Township;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.empr_company;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by zarni on 5/25/17.
 */

public class Server_Response
{
    @SerializedName("company")
    private ArrayList<empr_company> empr_companies;



    @SerializedName("city")
    private ArrayList<Empr_City> city = null;


    @SerializedName("township")
    private ArrayList<Empr_Township>townships =null;


    public ArrayList<empr_company>getEmpr_companies()
    {return empr_companies;}

    public ArrayList<Empr_City>getCity(){
        return city;
    }


    public ArrayList<Empr_Township>getTownships(){
        return townships;
    }


}
