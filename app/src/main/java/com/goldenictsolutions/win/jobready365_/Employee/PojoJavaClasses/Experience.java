package com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses;

/**
 * Created by Win on 2/6/2017.
 */
public class Experience {
    private String organization;
    private String rank;
    private String startDate;
    private String endDate;


    public Experience(String organization, String rank, String startDate, String endDate) {
        this.organization = organization;
        this.rank = rank;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }



}



