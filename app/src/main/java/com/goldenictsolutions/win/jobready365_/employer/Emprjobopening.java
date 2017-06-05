package com.goldenictsolutions.win.jobready365_.employer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.goldenictsolutions.win.jobready365_.R;


public class Emprjobopening extends Fragment {

    public Emprjobopening() {
        // Required empty public constructor
    }

    Button gotojopopenmod,gobackdash;
    String string;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_emprjobopening, container, false);
        gotojopopenmod=(Button)view.findViewById(R.id.empr_jopen_mod);
        gotojopopenmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Emprjobpost.class);
                string="1";
                intent.putExtra("conbackjopen",string);
                Toast.makeText(getContext(),string,Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

        gobackdash=(Button)view.findViewById(R.id.empr_jopen_back);
        gobackdash.setOnClickListener(new View.OnClickListener() {
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
