package com.goldenictsolutions.win.jobready365_.employer.Empr_Server;

import com.squareup.otto.Bus;

/**
 * Created by zarni on 5/25/17.
 */

public class Empr_Busprovider {
    private static final Bus BUS=new Bus();
    public static Bus getBus(){return BUS;}
    public Empr_Busprovider(){

    }



}
