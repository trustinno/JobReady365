package com.goldenictsolutions.win.jobready365_.employer.Empr_datastore;

import java.io.Serializable;

/**
 * Created by zarni on 5/25/17.
 */

public class empr_company  {

    final String user_id;
    final  String company_name;
    final  String logo;
    final  String address;
    final  int township;
    final int job_industry;
    final int city;
    final int mobile_no;
    final String email;
    final  String website;
    final  String description;
    final String primary_contact_person;
    final  int primary_mobile;
    final  String secondary_contact_person;
    final  int secondary_mobile;



    public empr_company(String user_id, String company_name, String logo, String address, int township, int job_industry,
                        int citys, int mobile_no, String email, String website, String description, String primary_contact_person, int primary_mobile, String secondary_contact_person, int secondary_mobile) {
            this.user_id=user_id;
            this.company_name=company_name;
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
            this.primary_mobile=mobile_no;
            this.secondary_contact_person=secondary_contact_person;
            this.secondary_mobile=secondary_mobile;

    }
}
