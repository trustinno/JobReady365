package com.goldenictsolutions.win.jobready365_.employer.Empr_Server;

/**
 * Created by zarni on 5/25/17.
 */

public class Empr_Serverevent {

    private Empr_Server_Response server_response;

    public Empr_Serverevent(Empr_Server_Response server_response){
        this.server_response=server_response;
    }
    public Empr_Server_Response getServerResponse() {
        return server_response;
    }
}
