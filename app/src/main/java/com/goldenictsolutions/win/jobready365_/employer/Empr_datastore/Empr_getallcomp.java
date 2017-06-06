package com.goldenictsolutions.win.jobready365_.employer.Empr_datastore;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by zarni on 6/5/17.
 */

public class Empr_getallcomp implements Serializable {
    @SerializedName("id")
    private   String empr_compid;

    @SerializedName("user_id")
    private  String empr_userid;

    @SerializedName("company_name")
    private String empr_compname;

    @SerializedName("logo")
    private String logo;

    @SerializedName("address")
    private String address;

    @SerializedName("township")
    private  String township;

    @SerializedName("job_industry")
    private  String job_industry;

    @SerializedName("city")
    private String city;

    @SerializedName("mobile_no")
    private String mobile_no;

    @SerializedName("email")
    private String email;

    @SerializedName("website")
    private String website;

    @SerializedName("description")
    private String description;

    @SerializedName("primary_contact_person")
    private String primary_contact_person;

    @SerializedName("primary_mobile_no")
    private int primary_mobile;

    @SerializedName("secondary_contact_person")
    private String secondary_contact_person;

    @SerializedName("secondry_mobile")
    private int secondary_mobile;

    @SerializedName("is_active")
    private int is_active;

    @SerializedName("is_feature")
    private int is_feature;

    public Empr_getallcomp(String empr_compid,String empr_userid,String empr_compname,String logo, String address, String township, String job_industry,
                           String citys, String mobile_no, String email, String website, String description, String primary_contact_person, int primary_mobile, String secondary_contact_person, int secondary_mobile,int is_active,int is_feature)
    {
        this.empr_compid=empr_compid;
        this.empr_userid=empr_userid;
        this.empr_compname=empr_compname;
        this.logo=logo;
        this.address=address;
        this.township=township;
        this.job_industry=job_industry;
        this.city=citys;
        this.mobile_no=mobile_no;
        this.email=email;
        this.website=website;
        this.description=description;
        this.primary_contact_person=primary_contact_person;
        this.primary_mobile=primary_mobile;
        this.secondary_contact_person=secondary_contact_person;
        this.secondary_mobile=secondary_mobile;
        this.is_active=is_active;
        this.is_feature=is_feature;

    }

    public String getEmpr_compid(){
        return empr_compid;
    }

    public String getEmpr_compname(){
        return empr_compname;
    }

    public String getbusinesstype(){
        return job_industry;
    }
    public String getemprdescription(){
        return description;
    }
    public  String getMobile_no(){
        return mobile_no;
    }
    public String getemail(){
        return email;
    }
    public String getWebsite(){
        return website;
    }
    public String getDescription()
    {
        return description;
    }
    public String getprimaryperson(){
        return primary_contact_person;
    }
    public int getprimarymobile(){
        return primary_mobile;
    }
    public int getsecondarymobile()
    {
        return secondary_mobile;
    }
    public String getsecondaryperson(){
        return secondary_contact_person;
    }



}



