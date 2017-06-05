package com.goldenictsolutions.win.jobready365_.employer.Empr_Server;

import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_Businesstype;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_City;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_JobType;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_Township;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_getallcomp;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_jobcate;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.empr_company;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zarni on 5/25/17.
 */

public class Empr_Server_Response
{
//    @SerializedName("company")
//    private ArrayList<empr_company> empr_companies;

    @SerializedName("jobindustry")
    private ArrayList<Empr_Businesstype>empr_businesstypes=null;

    @SerializedName("city")
    private ArrayList<Empr_City> city = null;


    @SerializedName("township")
    private ArrayList<Empr_Township>townships =null;


    @SerializedName("jobtype")
    private ArrayList<Empr_JobType>jobTypes=null;
//

   @SerializedName("jobcategory")
    private ArrayList<Empr_jobcate> empr_jobcates=null;


    @SerializedName("company")
    private ArrayList<Empr_getallcomp>empr_getallcomps=null;




    //@SerializedName("")

    public ArrayList<Empr_jobcate>getEmpr_jobcates(){return empr_jobcates;}

    public ArrayList<Empr_JobType>getJobTypes(){return jobTypes;}

//    public ArrayList<empr_company>getEmpr_companies()
//    {return empr_companies;}

    public ArrayList<Empr_Businesstype>getEmpr_businesstypes(){return empr_businesstypes;}

    public ArrayList<Empr_City>getCity(){
        return city;
    }

    public ArrayList<Empr_Township>getTownships(){
        return townships;
    }

    public ArrayList<Empr_getallcomp>getEmpr_getallcomps()
    {
        return empr_getallcomps;
    }


}
