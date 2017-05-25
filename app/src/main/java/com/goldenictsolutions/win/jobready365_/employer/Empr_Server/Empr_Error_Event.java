package com.goldenictsolutions.win.jobready365_.employer.Empr_Server;

/**
 * Created by zarni on 5/25/17.
 */

public class Empr_Error_Event {
    private int errorCode;
    private String errorMsg;
    public Empr_Error_Event(int errorCode,String errorMsg){

        this.errorCode=errorCode;
        this.errorMsg=errorMsg;

    }
    public int getErrorCode(){
        return errorCode;
    }
    public String getErrorMsg(){
        return errorMsg;
    }
}
