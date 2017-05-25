package com.goldenictsolutions.win.jobready365_.employer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.goldenictsolutions.win.jobready365_.R;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.Empr_Busprovider;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.Empr_Error_Event;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.Empr_Serverevent;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.ServerEventSpinnerBustype;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.ServerEventSpinnerTownship;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.ServerEventSpinnercity;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.TotheCloud;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_Businesstype;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_City;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_Township;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class Emprcompro extends AppCompatActivity {

    TotheCloud totheCloud;
    private   Spinner  townshipspinner,statematerialspinner;
    private List spcityid=new ArrayList<>();
    private List spcity=new ArrayList<>();
    Spinner spinner1,spinner2,spinner3;
    ArrayAdapter<String> adapter1,adapter2,adapter3;
    private   List sptownshipid=new ArrayList<>();
    private   List sptownship=new ArrayList<>();
    private   List spbustype=new ArrayList<>();
    private   List spbustypeid=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empr_comp_pro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        totheCloud = new TotheCloud();

        int city_id_sp=0;
        int bus_id=0;
        String jobindustry="";
        String city="";

        postcity(city_id_sp,city);
        spcityspinner();
        postbustype(bus_id,jobindustry);


        Button button=(Button)findViewById(R.id.gotopost);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Emprcompro.this,Emprjobpost.class);
                startActivity(intent);


            }
        });

    }

    public void postcity(int city_id_sp,String city)
    {
        totheCloud.getspcity(city_id_sp,city);
    }
    public void posttownship(int spcity_id)
    {
        totheCloud.gettownship(spcity_id);
    }
    public void postbustype(int bus_id,String jobindustry){
        totheCloud.getbusindex(bus_id,jobindustry);
    }


    //////////////////////////// SPINNER CITY /////////////////////////////////////

    @Subscribe
    public void onServerEvent(ServerEventSpinnercity serverEventSpinnercity)
    {
        if (!serverEventSpinnercity.getServerResponse().equals(null))
        {
            List<Empr_City> cities=serverEventSpinnercity.getServerResponse().getCity();
            for (int i=0;i<cities.size();i++)
            {
                spcityid.add(cities.get(i).getid());
                spcity.add(cities.get(i).getcity());
            }
            spinner1=(Spinner)findViewById(R.id.empr_state_spinner);
            adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,spcity);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner1.setAdapter(adapter1);

        }
    }

       //////////////////////////// TOWNSHIPSPINNER ////////////////////////
    @Subscribe
    public void onServeerEvent(ServerEventSpinnerTownship serverEventSpinnerTownship)
    {

        if (!serverEventSpinnerTownship.getServerResponse().equals(null))
        {
            sptownshipid.clear();
            sptownship.clear();

            List<Empr_Township>townships=serverEventSpinnerTownship.getServerResponse().getTownships();
            for (int i=0;i<townships.size();i++)

            {


                sptownshipid.add(townships.get(i).getid());
                sptownship.add(townships.get(i).gettown());
            }
            spinner2=(Spinner)findViewById(R.id.empr_township_spinner);
            adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,sptownship);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(adapter2);
        }
    }

           ////////////////////BUSINESSTYPE SPINNER///////////////////////
    @Subscribe
    public void onServeerEvent(ServerEventSpinnerBustype serverEventSpinnerBustype)
    {

        if (!serverEventSpinnerBustype.getServerResponse().equals(null))
        {

            List<Empr_Businesstype>businesstypes=serverEventSpinnerBustype.getServerResponse().getEmpr_businesstypes();
            for (int i=0;i<businesstypes.size();i++)

            {


                spbustypeid.add(businesstypes.get(i).getBus_id());
                spbustype.add(businesstypes.get(i).getJob_industry());
            }
            spinner3=(Spinner)findViewById(R.id.empr_business_type);
            adapter3=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,spbustype);
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner3.setAdapter(adapter3);
        }
    }
    @Subscribe
    public void onServerEvent(Empr_Serverevent serverEvent) {

        if (!serverEvent.getServerResponse().equals(null)) {
            Toast.makeText(getApplicationContext(),"blabla",Toast.LENGTH_LONG).show();
        }
    }

    public void spcityspinner( )
    {
        spinner1=(Spinner)findViewById(R.id.empr_state_spinner);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object bla= spcityid.get(position);
                int spcity_id=(int)bla;
//                String bal=spcity.toString();
                // Spcity spcity=new Spcity();
//                spcity.setCityid(spcity_id);
                if (spcity_id !=0)
                {
                    posttownship(spcity_id);

                }

                else
                {
                    String [] aki={"","",""};
                    spinner2=(Spinner)findViewById(R.id.empr_township_spinner);
                    adapter2=new ArrayAdapter<String>(Emprcompro.this,android.R.layout.simple_spinner_dropdown_item,aki);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter2);
                }

                Toast.makeText(getApplicationContext(),spcity_id+"aa",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public static class Spcity{
        private static int cityid;
        public void setCityid(int spcity_id){
            cityid=spcity_id;
        }
        public int getCityid()
        {
            return cityid;
        }
    }


    @Subscribe
    public void onErrorEvent(Empr_Error_Event errorEvent) {
        Toast.makeText(this, "onErrorEvent fail " + errorEvent.getErrorMsg(), Toast.LENGTH_SHORT).show();
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
