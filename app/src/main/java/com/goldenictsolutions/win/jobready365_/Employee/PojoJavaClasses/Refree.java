package com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses;


public class Refree {

    private String firstName;
    private String lastName;
    private String company;
    private String rank;
    private String email;
    private String mobileNo;


    public Refree(String firstName, String lastName, String company, String rank, String email, String mobileNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.rank = rank;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }


}