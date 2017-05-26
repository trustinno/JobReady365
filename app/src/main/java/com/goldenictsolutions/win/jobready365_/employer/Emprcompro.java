package com.goldenictsolutions.win.jobready365_.employer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

    String user_id,company_name, logo, address, email, website, description, primary_contact_person, secondary_contact_person;
    int township, job_industry,telephone, citys, mobile_no, secondary_mobile, primary_mobile;
    EditText cname, ctel, cadd, cemail, cdesc, cpri_conp, csec_conp, csec_conm, cpri_conm,cweb;
    //   private   Spinner  townshipspinner,statematerialspinner;
    private List spcityid = new ArrayList<>();
    private List spcity = new ArrayList<>();
    Spinner spinner1, spinner2, spinner3;
    ArrayAdapter<String> adapter1, adapter2, adapter3;
    private List sptownshipid = new ArrayList<>();
    private List sptownship = new ArrayList<>();
    private List spbustype = new ArrayList<>();
    private List spbustypeid = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empr_comp_pro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        totheCloud = new TotheCloud();
        ///////////////////////////////////////////
        final int city_id_sp = 0;
        int bus_id = 0;
        final String jobindustry = "";
        final String city = "";
        postbustype(bus_id, jobindustry);
        postcity(city_id_sp, city);

        ///////////////////////////
        spcityspinner();
        sptownshipspinner();
        spbustypespinner();

        ////////////////////////

        cname = (EditText) findViewById(R.id.empr_compro_name);
        cadd = (EditText) findViewById(R.id.empr_compro_address);
        cemail = (EditText) findViewById(R.id.empr_compro_email);
        ctel=(EditText)findViewById(R.id.empr_compro_tel);
        cdesc = (EditText) findViewById(R.id.empr_compro_about);
        cpri_conp = (EditText) findViewById(R.id.empr_compro_prip);
        csec_conp = (EditText) findViewById(R.id.empr_compro_secp);
        csec_conm = (EditText) findViewById(R.id.empr_compro_sectel);
        cpri_conm = (EditText) findViewById(R.id.empr_compro_pritel);
//

        Button button = (Button) findViewById(R.id.gotopost);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Spcity spcity=new  Spcity();
                Sptownship sptownship=new Sptownship();
                Spbustype spbustype=new Spbustype();


                user_id="2388d1e90e8f4a37a657c42dc6cc30af";
                job_industry=spbustype.getbustypeid();
                logo="";
                website="";
                citys=spcity.getCityid();
                township=sptownship.getTownshipid();
                company_name=cname.getText().toString();
                address=cadd.getText().toString();
                email=cemail.getText().toString();
                mobile_no=Integer.parseInt(ctel.getText().toString());
                description=cdesc.getText().toString();
                primary_contact_person=cpri_conp.getText().toString();
                secondary_contact_person=csec_conp.getText().toString();
                primary_mobile=Integer.parseInt(cpri_conm.getText().toString());
                secondary_mobile=Integer.parseInt(csec_conm.getText().toString());


                postcom(user_id,company_name,logo,address,township,job_industry,citys,mobile_no,email,website,description,primary_contact_person,primary_mobile,secondary_contact_person,secondary_mobile);

            Toast.makeText(getApplicationContext(),String.valueOf(township),Toast.LENGTH_LONG).show();


            }
        });

    }


    /////////////////////////////////  POST JOB ////////////////////////////////////////////////

    public void postcity(int city_id_sp, String city) {
        totheCloud.getspcity(city_id_sp, city);
    }

    public void posttownship(int spcity_id) {
        totheCloud.gettownship(spcity_id);
    }

    public void postbustype(int bus_id, String jobindustry) {
        totheCloud.getbusindex(bus_id, jobindustry);
    }
    public void postcom(String user_id,String company_name,String logo,String address,int township,int job_industry,int citys,
                        int mobile_no,String email,String website,String description,String primary_contact_person,int primary_mobile,String secondary_contact_person,int secondary_mobile
    )
    {
        totheCloud.postcompro(user_id,company_name,logo,address,township,job_industry,citys,mobile_no,email,website,description,
                primary_contact_person,primary_mobile,secondary_contact_person,secondary_mobile);
    }




    //////////////////////////// SPINNER CITY /////////////////////////////////////

    @Subscribe
    public void onServerEvent(ServerEventSpinnercity serverEventSpinnercity) {
        if (!serverEventSpinnercity.getServerResponse().equals(null)) {
            List<Empr_City> cities = serverEventSpinnercity.getServerResponse().getCity();
            for (int i = 0; i < cities.size(); i++) {
                spcityid.add(cities.get(i).getid());
                spcity.add(cities.get(i).getcity());
            }
            spinner1 = (Spinner) findViewById(R.id.empr_state_spinner);
            adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spcity);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner1.setAdapter(adapter1);

        }
    }

    //////////////////////////// TOWNSHIPSPINNER ////////////////////////
    @Subscribe
    public void onServeerEvent(ServerEventSpinnerTownship serverEventSpinnerTownship) {

        if (!serverEventSpinnerTownship.getServerResponse().equals(null)) {
            sptownshipid.clear();
            sptownship.clear();

            List<Empr_Township> townships = serverEventSpinnerTownship.getServerResponse().getTownships();
            for (int i = 0; i < townships.size(); i++)

            {


                sptownshipid.add(townships.get(i).getid());
                sptownship.add(townships.get(i).gettown());
            }
            spinner2 = (Spinner) findViewById(R.id.empr_township_spinner);
            adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sptownship);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(adapter2);
        }
    }
    ////////////////////// END ////////////////////////////

    ////////////////////BUSINESSTYPE SPINNER///////////////////////
    @Subscribe
    public void onServeerEvent(ServerEventSpinnerBustype serverEventSpinnerBustype) {

        if (!serverEventSpinnerBustype.getServerResponse().equals(null)) {

            List<Empr_Businesstype> businesstypes = serverEventSpinnerBustype.getServerResponse().getEmpr_businesstypes();
            for (int i = 0; i < businesstypes.size(); i++)

            {


                spbustypeid.add(businesstypes.get(i).getBus_id());
                spbustype.add(businesstypes.get(i).getJob_industry());
            }
            spinner3 = (Spinner) findViewById(R.id.empr_business_type);
            adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spbustype);
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner3.setAdapter(adapter3);
        }
        else if (serverEventSpinnerBustype.getServerResponse().equals(null))
        {
            String [] spbusplaceholder = {"CONNECTION ERROR","Don't scroll Connect the internet"};
            spinner3 = (Spinner) findViewById(R.id.empr_business_type);
            adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spbusplaceholder);
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner3.setAdapter(adapter3);
        }
    }

    @Subscribe
    public void onServerEvent(Empr_Serverevent serverEvent) {

        if (!serverEvent.getServerResponse().equals(null)) {
            Intent intent = new Intent(Emprcompro.this, Emprjobpost.class);
              startActivity(intent);

            Toast.makeText(getApplicationContext(), "blabla", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"there is something error",Toast.LENGTH_LONG).show();
        }
    }


    /////////////////////////////////// END /////////////////////////////////////////



    //////////////////////////////////////   SPINNER ON CLICK GET DATA //////////////////////////////////


    public void spcityspinner() {
        spinner1 = (Spinner) findViewById(R.id.empr_state_spinner);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String bla = spcityid.get(position).toString();
                int spcity_id = Integer.parseInt(bla);
                 Spcity spcity=new Spcity();
                spcity.setCityid(spcity_id);
                    posttownship(spcity_id);

                Toast.makeText(getApplicationContext(), spcity_id + "aa", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public static class Spcity {
        private static int cityid;

        public void setCityid(int spcity_id) {
            cityid = spcity_id;
        }

        public int getCityid() {
            return cityid;
        }
    }
    ///////////////////////////////////// END ////////////////////////////////////////////////


    ///////////////////////////////  TOWINSHIP ONCLICK GET DATA //////////////////////////////

    public void sptownshipspinner() {
        spinner2 = (Spinner) findViewById(R.id.empr_township_spinner);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int sptownship_id= (int) sptownshipid.get(position);
                Sptownship sptownship = new Sptownship();
                sptownship.setTownshipid(sptownship_id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public static class Sptownship {
        private static int townshipid;

        public void setTownshipid(int sptownship_id) {
            townshipid = sptownship_id;
        }

        public int getTownshipid() {
            return townshipid;
        }
    }

    /////////////////////////////////////////// END //////////////////////////////////////

    /////////////////////////////////// BUSINESS SPINNER ON CLICK ///////////////////////

    public void spbustypespinner() {
        spinner3 = (Spinner) findViewById(R.id.empr_business_type);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object busid = spbustypeid.get(position);

                int bustype_id = (int) busid;
                Spbustype spbustype = new Spbustype();
                spbustype.setbistypeid(bustype_id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public static class Spbustype {
        private static int bustypeid;

        public void setbistypeid(int spbustype_id) {
            bustypeid = spbustype_id;
        }

        public int getbustypeid() {
            return bustypeid;
        }
    }

    //////////////////////////////// END ///////////////////////////////////////////////////////


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
