package com.goldenictsolutions.win.jobready365_.Employee.Services;

import com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses.*;
import com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses.Employer;
import com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses.User;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServerResponse implements Serializable{
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("message")
    private String message;
    @SerializedName("error_code")
    private int errorCode;
    private int status;
    @SerializedName("error")
    private String error;

    @SerializedName("result")
   private ArrayList<Employer> employerList= null;


    @SerializedName("user")
    private List<User> userList = null;



    private String token;


    public ServerResponse(String email, String password, String message, int errorCode, int status, String error){
        this.email = email;
        this.password = password;
        this.message = message;
        this.errorCode = errorCode;
        this.status = status;
        this.error = error;

    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public ArrayList<Employer> getEmployerList() {
        return employerList;
    }

    public void setEmployerList(ArrayList<Employer> employerList) {
        this.employerList = employerList;
    }
}