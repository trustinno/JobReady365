package com.goldenictsolutions.win.jobready365_.employer.Empr_datastore;

import android.Manifest;

/**
 * Created by zarni on 5/31/17.
 */

public class empr_postjob {
    final  String user_id;
    final String company_id;
    final String contact_info;
    final  int township;
    final int city;
    final  int job_nature;
    final int job_category;
    final String job_title;
    final int salary_range;
    final String summary;
    final String description;
    final  String requirement;
    final String language_skill;
    final int accomodation;
    final int single;
    final int food_supply;
    final  int ferry_supply;
    final  int male;
    final int female;
    final int unisex;
    final int min_age;
    final int max_age;


    public empr_postjob(String User_id,String Company_id,String Contact_info,int Township,int
                        myoo,int Job_nature,int Job_category,String Job_title,int Salary_range,String Summary,String Description,String Requirement,String Language_skill,
                        int Accomodation,int Single,int Food_supply,int Ferry_supply, int Male,int Female,int Unisex,int Min_age,int Max_age )

    {
            user_id=User_id;
            company_id=Company_id;
            contact_info=Contact_info;
            township=Township;
            city=myoo;
            job_nature=Job_nature;
            job_category=Job_category;
            job_title=Job_title;
            salary_range=Salary_range;
            summary=Summary;
            description=Description;
            requirement=Requirement;
            language_skill=Language_skill;
            accomodation=Accomodation;
            single=Single;
            food_supply=Food_supply;
            ferry_supply=Ferry_supply;
            male=Male;
            female=Female;
            unisex=Unisex;
            min_age=Min_age;
            max_age=Max_age;
    }

}
