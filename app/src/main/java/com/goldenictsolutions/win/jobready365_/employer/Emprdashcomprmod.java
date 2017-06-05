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

public class Emprdashcomprmod extends Fragment {

    public Emprdashcomprmod() {
        // Required empty public constructor
    }
Button empr_mod;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_emprdashcomprmod, container, false);

        empr_mod=(Button)view.findViewById(R.id.empr_dash_commod_save);
        empr_mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmprDashboard emprDashboard=new EmprDashboard();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.empr_container,emprDashboard);
                fragmentTransaction.commit();
            }
        });



                return view;
    }

}
