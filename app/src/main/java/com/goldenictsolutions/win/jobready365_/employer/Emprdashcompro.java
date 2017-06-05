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
import android.widget.TextView;
import android.widget.Toast;

import com.goldenictsolutions.win.jobready365_.R;

public class Emprdashcompro extends Fragment {
    public Emprdashcompro() {

    }
Button emr_dash_back,emr_dash_mod;
 String comp_id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_emprdashcompro, container, false);
        Bundle bundle=getArguments();
        if (bundle  != null && bundle.containsKey("companyid")) {
            comp_id = bundle.getString("companyid");
            TextView textView=(TextView)view.findViewById(R.id.mobile);
            textView.setText(comp_id);
        }
        //Toast.makeText(getContext(),bundle.get("companyid").toString()+"blabla",Toast.LENGTH_LONG).show();

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
