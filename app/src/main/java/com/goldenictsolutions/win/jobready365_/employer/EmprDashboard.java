package com.goldenictsolutions.win.jobready365_.employer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.Empr_Serverevent_candidate;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.ServerEventgetAllCompany;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.TotheCloud;
import com.goldenictsolutions.win.jobready365_.employer.Empr_adapter.Candidate_adapter_employer;
import com.goldenictsolutions.win.jobready365_.employer.Empr_adapter.MoviesAdapter;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_Candidate_count;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_getallcomp;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class EmprDashboard extends Fragment {

    public EmprDashboard() {
        // Required empty public constructor
    }

  private Button addcomp_pro,dash_edit,dash_view,dash_add;
 private String userid,empr_dash_userid,companyId,getCompanyId;
  private   Spinner empr_dash_spinner;
    private RecyclerView recyclerView;
  private   TextView Disconnected;
    private  ArrayList<Empr_Candidate_count> empr_candidate_counts;
    ProgressDialog pd;
     Candidate_adapter_employer candidate_adapter_employer;
     private SwipeRefreshLayout swipeContainer;
   private List spcompanyid=new ArrayList<>();
    private  List spcompanyname=new ArrayList<>();

  private ArrayAdapter<String> empr_dash_adp;
  TotheCloud totheCloud;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_empr_dashboard, container, false);
        //TextView textView=(TextView)view.findViewById(R.id.empr_dash_can);
        totheCloud=new TotheCloud();
       // userid=getArguments().getString("userid_get");

        onclikallcomp(view);


        initview(view);

        empr_dash_userid="2388d1e90e8f4a37a657c42dc6cc30af";
         companyId="";
        getcompnaysp(empr_dash_userid,companyId);


        final        FragmentManager fragmentManager = getFragmentManager();
     final    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        swipeContainer = (SwipeRefreshLayout)view.findViewById(R.id.swipe_empr_dash);
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadJson();
                swipeContainer.setRefreshing(false);
            }
        });

        dash_edit=(Button)view.findViewById(R.id.empr_dash_comedit);
        dash_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Emprdashcompro emprdashcompro=new Emprdashcompro();
                SpinnerComid spinnercom=new SpinnerComid();
                getCompanyId=spinnercom.getid();
                Bundle bundle=new Bundle();
                bundle.putString("companyid",getCompanyId);
                emprdashcompro.setArguments(bundle);
                fragmentTransaction.replace(R.id.empr_container, emprdashcompro);
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

//        dash_view=(Button)view.findViewById(R.id.empr_dash_view);
//        dash_view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                    Emprjobopening emprjobopening=new Emprjobopening();
//                fragmentTransaction.replace(R.id.empr_container,emprjobopening);
//                fragmentTransaction.commit();
//            }
//        });
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EmprCandilist emprCandilist=new EmprCandilist();
//                fragmentTransaction.replace(R.id.empr_container,emprCandilist);
//                fragmentTransaction.commit();
//            }
//        });

      return view;
    }

    public  void getcompnaysp(String empr_dash_userid,String companyId)
    {
            totheCloud.getallcomp(empr_dash_userid,companyId);
    }


    public void initview(View view){

        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_empr_dash);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.smoothScrollToPosition(0);
        loadJson();
    }

    private void loadJson() {

        post();
    }



    public void post(){

        String id="e1e768766a9e411e9522e3e5293c7e3a";
        totheCloud.emgetcom(id);
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


    @Subscribe
    public void onServerEvent(Empr_Serverevent_candidate serverEvent) {

        if (serverEvent.getEmpr_server_response() != null) {
            empr_candidate_counts=  serverEvent.getEmpr_server_response().getCandidates();
            recyclerView=(RecyclerView)getActivity().findViewById(R.id.recycler_empr_dash);
            recyclerView.setAdapter(new Candidate_adapter_employer(getActivity(),empr_candidate_counts));

            //Toast.makeText(MainActivity5.this, movieArrayList.toString(), Toast.LENGTH_SHORT).show();
            swipeContainer.setRefreshing(false);


            //Toast.makeText(MainActivity5.this, movieArrayList.toString(), Toast.LENGTH_SHORT).show();

        }
        else if (serverEvent.getEmpr_server_response().equals(null))
        {
            TextView textView4=(TextView)getView().findViewById(R.id.empr_dash_disconnect);
            textView4.setText("Disconnected can't view recycler");
        }

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
