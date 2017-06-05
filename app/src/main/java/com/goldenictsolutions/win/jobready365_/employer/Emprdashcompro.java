package com.goldenictsolutions.win.jobready365_.employer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.goldenictsolutions.win.jobready365_.R;

public class Emprdashcompro extends Fragment {
    public Emprdashcompro() {


    }
Button emr_dash_back,emr_dash_mod;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_emprdashcompro, container, false);

        final FragmentManager fragmentManager=getFragmentManager();
        final FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        emr_dash_back=(Button)view.findViewById(R.id.empr_dash_comback);
        emr_dash_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmprDashboard emprDashboard=new EmprDashboard();
                fragmentTransaction.replace(R.id.empr_container,emprDashboard);
                fragmentTransaction.commit();

            }
        });

        emr_dash_mod=(Button)view.findViewById(R.id.empr_dash_commod);
        emr_dash_mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Emprdashcomprmod emprdashcomprmod=new Emprdashcomprmod();
                fragmentTransaction.replace(R.id.empr_container,emprdashcomprmod);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
