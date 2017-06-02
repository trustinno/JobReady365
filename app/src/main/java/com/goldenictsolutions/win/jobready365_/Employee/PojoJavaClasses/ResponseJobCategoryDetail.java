package com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Win on 1/19/2017.
 */

public class ResponseJobCategoryDetail {
    @SerializedName("error")
    @Expose
    private Boolean error;

    @SerializedName("result")
    @Expose
    private List<JobCategoryDetail> result;





    @SerializedName("status_code")
    @Expose
    private Integer statusCode;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<JobCategoryDetail> getResult() {
        return result;
    }

    public void setResult(List<JobCategoryDetail> result) {
        this.result = result;
    }



    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

}

