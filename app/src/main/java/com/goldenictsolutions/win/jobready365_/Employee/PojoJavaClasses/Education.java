package com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses;

/**
 * Created by Win on 2/6/2017.
 */
public class Education {
    private String university;
    private String degree;
    private String year;


    public Education(String year, String university, String degree) {
        this.year = year;
        this.university = university;
        this.degree = degree;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }



}
