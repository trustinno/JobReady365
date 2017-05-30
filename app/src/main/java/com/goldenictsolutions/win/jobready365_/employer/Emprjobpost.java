package com.goldenictsolutions.win.jobready365_.employer;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.goldenictsolutions.win.jobready365_.JPolicy;
import com.goldenictsolutions.win.jobready365_.R;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.Empr_Busprovider;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.Empr_Serverevent;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.ServerEventSpinnerJobcate;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.ServerEventSpinnerJobtype;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.ServerEventSpinnerTownship;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.ServerEventSpinnercity;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.TotheCloud;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_City;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_JobType;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_Township;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_jobcate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;


public class Emprjobpost extends AppCompatActivity {
    EditText editTextdialog;
    TextView editText;
    Button diaglogbutton,diaglogbuttoncancle,dialgoyes,dialogno;
    Dialog dialog,backdialog;
    Spinner spcity_jobpost,sptownship_jobpost,spjobtype_jobpost,spjobcate_jobpost,spamount_jobpost;
    ArrayAdapter spcity_adp,sptownship_adp,spjobtype_adp,spjobcate_adp;
    private List spcityid = new ArrayList<>();
    private List spcity = new ArrayList<>();
    private List sptownshipid = new ArrayList<>();
    private List sptownship = new ArrayList<>();
    private List spbustype = new ArrayList<>();
    private List spbustypeid = new ArrayList<>();
    private List spjobcateid =new ArrayList<>();
    private List spjobcate=new ArrayList<>();

    String [] spamount = {"Negotiate","Less than 100000 Ks","100000 ~ 300000 Ks","300000 ~ 500000","500000 ~ 1000000","Greater than 1000000"};
    Switch  accomosw,transw,grasw,singlesw,foodsw,trainsw;
    //    String empr_checks;
    TotheCloud totheCloud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprjobpost);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        totheCloud=new TotheCloud();
        final int city_id_sp = 0;
        int jocate_id = 0;
        int jobtp_id=0;
        String jobtp_type="";
        final String jobcate = "";
        final String city = "";
        postjobcate(jocate_id, jobcate);
        postcitysp(city_id_sp, city);
        postjobtype(jobtp_id,jobtp_type);
        ///////////////////////////
        spcityspinnersp();
        sptownshipspinnersp();



        ////////////////////////

        grasw=(Switch)findViewById(R.id.empr_gra_sw);
        transw=(Switch)findViewById(R.id.empr_tran_sw);
        accomosw=(Switch)findViewById(R.id.empr_accomo_sw);
        singlesw=(Switch)findViewById(R.id.empr_single_sw);
        foodsw=(Switch)findViewById(R.id.empr_food_sw);
        trainsw=(Switch)findViewById(R.id.empr_tran_sw);

        spamount_jobpost=(Spinner)findViewById(R.id.empr_sallary);
        ArrayAdapter spamount_adp=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,spamount);
        spamount_jobpost.setAdapter(spamount_adp);

        grasw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    Toast.makeText(getApplicationContext(),"switch graduated is on",Toast.LENGTH_LONG).show();
                }
            }
        });


        transw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    Toast.makeText(getApplicationContext(),"switch tarnsportation is on",Toast.LENGTH_LONG).show();
                }
            }
        });


        accomosw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    Toast.makeText(getApplicationContext(),"switch accomodation is on",Toast.LENGTH_LONG).show();
                }
            }
        });


        foodsw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    Toast.makeText(getApplicationContext(),"switch Food is on",Toast.LENGTH_LONG).show();
                }
            }
        });




        singlesw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    Toast.makeText(getApplicationContext(),"switch FA is on",Toast.LENGTH_LONG).show();
                }
            }
        });




        trainsw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    Toast.makeText(getApplicationContext(),"switch trainning is on",Toast.LENGTH_LONG).show();
                }
            }
        });





        editText=(TextView) findViewById(R.id.editquilifi);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextdialog=new EditText(Emprjobpost.this);
                dialog = new Dialog(Emprjobpost.this);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.width=WindowManager.LayoutParams.MATCH_PARENT;
                lp.height=WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.setContentView(R.layout.empr_qul_dialog);
                TextView editText2=(TextView) findViewById(R.id.editquilifi);
                String reedit=editText2.getText().toString();
                editTextdialog.setText(reedit);
                diaglogbutton=(Button)dialog.findViewById(R.id.diaglog_button);
                diaglogbuttoncancle=(Button)dialog.findViewById(R.id.diaglog_buttoncancle);
                diaglogbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editTextdialog=(EditText)dialog.findViewById(R.id.dialogedit);
                        String dialogstr=editTextdialog.getText().toString();
                        dialog.dismiss();
                        editText.setText(dialogstr);

                    }
                });
                diaglogbuttoncancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.getWindow().setAttributes(lp);

                dialog.show();

            }
        });
        final String empr_checks=getIntent().getStringExtra("conbackjopen");
        if (empr_checks !=null)
        {

                     toemp();
        }
        else {
            gobacktocompro();
        }


        Button gotoemployer=(Button)findViewById(R.id.gotoemp);
        gotoemployer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Emprjobpost.this,Employer.class);
                startActivity(intent);

            }
        });
    }






    ///////////// POST TO GET SPINNER //////////////////////

        public void postcitysp(int city_id_sp, String city) {
            totheCloud.getspcity(city_id_sp, city);
        }

        public void  postjobtype(int jobtp_id,String jobtp_type){
            totheCloud.getjobtype(jobtp_id,jobtp_type);
        }

        public void posttownshipsp(int spcity_id) {
            totheCloud.gettownship(spcity_id);
        }

        public void postjobcate(int jocate_id, String jobcate) {
            totheCloud.getjobcate(jocate_id, jobcate);
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
            spcity_jobpost = (Spinner) findViewById(R.id.empr_city_sppost);
            spcity_adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spcity);
            spcity_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spcity_jobpost.setAdapter(spcity_adp);

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
            sptownship_jobpost = (Spinner) findViewById(R.id.empr_township_sppost);
            sptownship_adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sptownship);
            sptownship_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sptownship_jobpost.setAdapter(sptownship_adp);
        }
    }
    ////////////////////// END ////////////////////////////


    ////////////////////// AMOUT ////////////////////////////////






    //////////////////////  END /////////////////////////////////


    ///////////////////////  JOBTYPE    ///////////////////////////////
    @Subscribe
    public void onServeerEvent(ServerEventSpinnerJobtype serverEventSpinnerJobtype) {

        if (!serverEventSpinnerJobtype.getServerResponse().equals(null)) {
//            sptownshipid.clear();
//            sptownship.clear();

            List<Empr_JobType> jobTypes = serverEventSpinnerJobtype.getServerResponse().getJobTypes();
            for (int i = 0; i < jobTypes.size(); i++)

            {


                spbustypeid.add(jobTypes.get(i).gettypeid());
                spbustype.add(jobTypes.get(i).gettypes());
            }
            spjobtype_jobpost = (Spinner) findViewById(R.id.empr_spjobtype);
            spjobtype_adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spbustype);
            spjobtype_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spjobtype_jobpost.setAdapter(spjobtype_adp);
        }
    }
    ///////////////////////    END //////////////////////////////

    ////////////////////JOBCATEGORY SPINNER///////////////////////
    @Subscribe
    public void onServeerEvent(ServerEventSpinnerJobcate serverEventSpinnerJobcate) {

        if (!serverEventSpinnerJobcate.getServerResponse().equals(null)) {



            List<Empr_jobcate> jobcates =serverEventSpinnerJobcate.getServerResponse().getEmpr_jobcates();
            for (int i = 0; i < jobcates.size(); i++)
            {


                //spjobcate = (List) Html.fromHtml(String.valueOf((spjobcate)));
                spjobcateid.add(jobcates.get(i).getjobcatid());
                spjobcate.add(jobcates.get(i).getCategory());
            }
            spjobcate_jobpost = (Spinner) findViewById(R.id.empr_spjobcate);
            spjobcate_adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spjobcate);
            spjobcate_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spjobcate_jobpost.setAdapter(spjobcate_adp);
        }
        else if (serverEventSpinnerJobcate.getServerResponse().equals(null))
        {
            String [] spbusplaceholder = {"CONNECTION ERROR","Don't scroll Connect the internet"};
            spjobcate_jobpost = (Spinner) findViewById(R.id.empr_business_type);
            spjobcate_adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spbusplaceholder);
            spjobcate_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spjobcate_jobpost.setAdapter(spjobcate_adp);
        }
    }



    public void toemp(){

        Button imageView=(Button)findViewById(R.id.gotocompro);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Emprjobpost.this,Employer.class);
                startActivity(intent);

            }
        });

    }



    //////////////// EMPLOYER COMPRO EMPLOADEd RESPONSE //////////////////////
    @Subscribe
    public void onServerEvent(Empr_Serverevent serverEvent) {

        if (!serverEvent.getServerResponse().equals(null)) {



            Toast.makeText(getApplicationContext(), "blabla", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"there is something error",Toast.LENGTH_LONG).show();
        }
    }


    /////////////////////////////////// END /////////////////////////////////////////



    //////////////////////////////////////   SPINNER ON CLICK GET DATA //////////////////////////////////


    public void spcityspinnersp() {
        spcity_jobpost = (Spinner) findViewById(R.id.empr_city_sppost);
        spcity_jobpost.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String bla = spcityid.get(position).toString();
                int spcity_id = Integer.parseInt(bla);
                Emprcompro.Spcity spcity=new Emprcompro.Spcity();
                spcity.setCityid(spcity_id);
                posttownshipsp(spcity_id);

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

    public void sptownshipspinnersp() {
        sptownship_jobpost = (Spinner) findViewById(R.id.empr_township_sppost);
        sptownship_jobpost.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int sptownship_id= (int) sptownshipid.get(position);
                Emprcompro.Sptownship sptownship = new Emprcompro.Sptownship();
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

    public void spjobcategory() {
        spjobcate_jobpost  = (Spinner) findViewById(R.id.empr_spjobcate);
        spjobcate_jobpost.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object busid = spbustypeid.get(position);

                int jocacateidsp = (int) busid;
                Emprcompro.Spbustype spbustype = new Emprcompro.Spbustype();
                spbustype.setbistypeid(jocacateidsp);
                Toast.makeText(getApplicationContext(),jocacateidsp,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public static class Spjobcate {
        private static int jocacateid;

        public void setbistypeid(int jocacateidsp) {
            jocacateid =jocacateidsp;
        }


        public int getJocacateidsp() {
            return jocacateid;
        }
    }

    //////////////////////////////// END ///////////////////////////////////////////////////////











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




    public void gobacktocompro(){
        Button imageView=(Button)findViewById(R.id.gotocompro);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Emprjobpost.this,Emprcompro.class);
                startActivity(intent);

            }
        });

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exitByBackKey() {
        final Dialog backdialogg =new Dialog(Emprjobpost.this);
        backdialogg.setContentView(R.layout.empr_backpress);

    }
}