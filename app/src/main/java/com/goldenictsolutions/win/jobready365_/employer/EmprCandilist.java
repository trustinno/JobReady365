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

public class EmprCandilist extends Fragment {

    public EmprCandilist() {


    }

    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_empr_candilist, container, false);

        button=(Button)view.findViewById(R.id.empr_can_detail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmprViewcv  emprViewcv=new EmprViewcv();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.empr_container,emprViewcv);
                fragmentTransaction.commit();
            }
        });
            return view;

    }

}
