package com.goldenictsolutions.win.jobready365_.employer.Empr_Server;

/**
 * Created by zarni on 5/29/17.
 */

public class ServerEventSpinnerJobtype {
    private Empr_Server_Response server_response;

    public ServerEventSpinnerJobtype(Empr_Server_Response empr_server_response)
    {
            this.server_response=empr_server_response;
    }

    public Empr_Server_Response getServerResponse()
    {
        return server_response;
    }

    public void setServer_response(Empr_Server_Response empr_server_response)
    {
        this.server_response=empr_server_response;
    }


}
