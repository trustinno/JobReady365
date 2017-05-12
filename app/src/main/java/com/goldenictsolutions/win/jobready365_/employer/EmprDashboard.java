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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.goldenictsolutions.win.jobready365_.R;

public class EmprDashboard extends Fragment {

    public EmprDashboard() {
        // Required empty public constructor
    }

Button addcomp_pro,dash_edit,dash_view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_empr_dashboard, container, false);
        Spinner spinner;
        String [] aa={"Golden ICT Solutions","Trustinno","ChallengerBladeSolution"};
        spinner=(Spinner)view.findViewById(R.id.businessspinner);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this.getContext(),android.R.layout.simple_dropdown_item_1line
                ,aa);
        spinner.setAdapter(arrayAdapter);
final        FragmentManager fragmentManager = getFragmentManager();
     final    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        dash_edit=(Button)view.findViewById(R.id.empr_dash_comedit);
        dash_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Emprdashcompro emprdashcompro=new Emprdashcompro();
                fragmentTransaction.replace(R.id.empr_container, emprdashcompro);
                fragmentTransaction.commit();

            }
        });

        dash_view=(Button)view.findViewById(R.id.empr_dash_view);
        dash_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Emprjobopening emprjobopening=new Emprjobopening();
                fragmentTransaction.replace(R.id.empr_container,emprjobopening);
                fragmentTransaction.commit();
            }
        });


return view;
    }
}
