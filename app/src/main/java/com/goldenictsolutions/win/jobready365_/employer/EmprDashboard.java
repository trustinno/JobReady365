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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.goldenictsolutions.win.jobready365_.R;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.Empr_Busprovider;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.Empr_Error_Event;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.ServerEventgetAllCompany;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.TotheCloud;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_Getter;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_getallcomp;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class EmprDashboard extends Fragment {

    public EmprDashboard() {
        // Required empty public constructor
    }

  Button addcomp_pro,dash_edit,dash_view,dash_add;
  String userid,empr_dash_userid,companyId,getCompanyId;
    Spinner empr_dash_spinner;
   private List spcompanyid=new ArrayList<>();
    private  List spcompanyname=new ArrayList<>();

  ArrayAdapter<String> empr_dash_adp;
  TotheCloud totheCloud;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_empr_dashboard, container, false);
        TextView textView=(TextView)view.findViewById(R.id.empr_dash_can);
        totheCloud=new TotheCloud();
       // userid=getArguments().getString("userid_get");

        onclikallcomp(view);


        empr_dash_userid="2388d1e90e8f4a37a657c42dc6cc30af";
         companyId="";
        getcompnaysp(empr_dash_userid,companyId);

        final Fragment fragment=new Fragment();

        final        FragmentManager fragmentManager = getFragmentManager();
     final    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        dash_edit=(Button)view.findViewById(R.id.empr_dash_comedit);
        dash_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Emprdashcompro emprdashcompro=new Emprdashcompro();
                fragmentTransaction.replace(R.id.empr_container, emprdashcompro);
                Bundle bundle=new Bundle();
                SpinnerComid spinnercom=new SpinnerComid();
                getCompanyId=spinnercom.getid();
                bundle.putString("companyid",getCompanyId);
                fragment.setArguments(bundle);
                fragmentTransaction.commit();

            }
        });

        dash_add=(Button)view.findViewById(R.id.empr_dash_add);
        dash_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addto="1";
                Intent intent=new Intent(getActivity(),Emprcompro.class);
                intent.putExtra("fromdash",addto);
                startActivity(intent);
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
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmprCandilist emprCandilist=new EmprCandilist();
                fragmentTransaction.replace(R.id.empr_container,emprCandilist);
                fragmentTransaction.commit();
            }
        });

      return view;
    }

    public  void getcompnaysp(String empr_dash_userid,String companyId)
    {
            totheCloud.getallcomp(empr_dash_userid,companyId);
    }


    ///////////////////  GETALL_COMPANY/////////////////////

    @Subscribe
    public void onServerEvent(ServerEventgetAllCompany serverEventgetAllCompany)
    {

        if (!serverEventgetAllCompany.getEmpr_server_response().equals(null))
        {


            spcompanyname.clear();
            spcompanyid.clear();
            List<Empr_getallcomp>allcom=serverEventgetAllCompany.getEmpr_server_response().getEmpr_getallcomps();
            for (int i=0;i<allcom.size();i++)
            {
                spcompanyid.add(allcom.get(i).getEmpr_compid());
                spcompanyname.add(allcom.get(i).getEmpr_compname());
                 }

            empr_dash_spinner=(Spinner)getActivity().findViewById(R.id.empr_dashboard_sp);
            empr_dash_adp=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,spcompanyname);
            //empr_dash_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            empr_dash_spinner.setAdapter(empr_dash_adp);
           // Toast.makeText(getContext(),spcompanyid.toString(),Toast.LENGTH_LONG).show();

        }
        else if (serverEventgetAllCompany.getEmpr_server_response().equals(null))
        {
            Toast.makeText(getContext(),serverEventgetAllCompany.getEmpr_server_response().toString(),Toast.LENGTH_LONG).show();
        }
    }


    public void onclikallcomp(View view)
    {
        empr_dash_spinner=(Spinner)view.findViewById(R.id.empr_dashboard_sp);
        empr_dash_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    String empr_Compid=spcompanyid.get(position).toString();

                SpinnerComid spinnerComid=new SpinnerComid();
                spinnerComid.setid(empr_Compid);
       //         Toast.makeText(view.getContext(),empr_Compid,Toast.LENGTH_LONG).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }



    ///////////////////////////// END /////////////////////////

    public static class SpinnerComid
    {
        private static  String companyid;

        public void setid(String company_Id) {
            this.companyid = company_Id;
        }
            public String getid(){
        return companyid;
    }
    }



    @Subscribe
    public void onErrorEvent(Empr_Error_Event error_event)
    {
        Toast.makeText(this.getContext(),"Error"+error_event.getErrorMsg(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Empr_Busprovider.getBus().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        Empr_Busprovider.getBus().unregister(this);
    }
}
