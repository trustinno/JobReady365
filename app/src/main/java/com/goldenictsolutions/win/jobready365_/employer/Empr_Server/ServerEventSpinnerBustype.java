package com.goldenictsolutions.win.jobready365_.employer.Empr_Server;

/**
 * Created by zarni on 5/25/17.
 */
public class ServerEventSpinnerBustype {
    private Empr_Server_Response serverResponse;

    public ServerEventSpinnerBustype(Empr_Server_Response serverResponse) {
        this.serverResponse = serverResponse;
    }

    public Empr_Server_Response getServerResponse() {
        return serverResponse;
    }


    public void setServerResponse(Empr_Server_Response serverResponse) {
        this.serverResponse = serverResponse;
    }
}
