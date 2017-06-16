package com.goldenictsolutions.win.jobready365_.employer.Empr_datastore;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by zarni on 5/29/17.
 */

public class Empr_jobcate implements Serializable{
        @SerializedName("id")
        private int id;

        @SerializedName("category")
        private String category;


        public Empr_jobcate(int id,String category)
        {
            this.id=id;
            this.category=category;
        }

        public int getjobcatid()
        {
            return id;
        }

        public String getCategory()
        {
            return category;
        }
}
