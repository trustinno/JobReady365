package com.goldenictsolutions.win.jobready365_.employer.Empr_Server;

/**
 * Created by zarni on 6/5/17.
 */

public class ServerEventgetAllCompany {

    private  Empr_Server_Response empr_server_response;

    public ServerEventgetAllCompany(Empr_Server_Response empr_server_response)
    {
        this.empr_server_response=empr_server_response;
    }
    public Empr_Server_Response getEmpr_server_response(){
        return empr_server_response;
    }

    public void setEmpr_server_response(Empr_Server_Response empr_server_response){
        this.empr_server_response=empr_server_response;
    }
}
