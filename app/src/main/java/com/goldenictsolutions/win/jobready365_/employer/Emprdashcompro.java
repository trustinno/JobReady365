package com.goldenictsolutions.win.jobready365_.employer;

import android.content.Context;
import android.graphics.drawable.RippleDrawable;
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
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.Empr_Busprovider;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.Empr_Error_Event;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.ServerEventgetAllCompany;
import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.TotheCloud;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_getallcomp;
import com.squareup.otto.Subscribe;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Emprdashcompro extends Fragment {
    TotheCloud totheCloud;
    public Emprdashcompro() {
        totheCloud=new TotheCloud();

    }


    Button emr_dash_back,emr_dash_mod;
    String comp_id;
    String empr_compro2name;
    String empr_compro2_email;
    String empr_compro2_primob;
    String empr_compro2_secmob;
    String empr_compro2_bustype;
    String empr_compro2_pricon;
    int empr_compro2_primobile;
    String empr_compro2_seccon;
    int empr_compro2_secmobile;
    String empr_compro2_des;
    private TextView company_name,businesstype,pri_mob,sec_mob,primary_mobiel,secondary_mobile,primary_person,secondary_person,email,description;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_emprdashcompro, container, false);
        Bundle argument=getArguments();
        comp_id = argument.getString("companyid");

        getcomprodash(comp_id);
        //Toast.makeText(getContext(), comp_id + "blabla", Toast.LENGTH_LONG).show();
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

        company_name=(TextView)view.findViewById(R.id.empr_compro2_cname);
        pri_mob=(TextView)view.findViewById(R.id.empr_compro2_primob);
        primary_mobiel=(TextView)view.findViewById(R.id.empr_compro2_primobile);
        secondary_mobile=(TextView)view.findViewById(R.id.empr_compro2_secmobile);
        primary_person=(TextView)view.findViewById(R.id.empr_compro2_pricon);
        secondary_person=(TextView)view.findViewById(R.id.empr_compro2_seccon);
        email=(TextView)view.findViewById(R.id.empr_compro2_email);
        businesstype=(TextView)view.findViewById(R.id.empr_compro2_bustype);
        description=(TextView)view.findViewById(R.id.empr_compro2_desc);

        return view;

    }

    public void  getcomprodash(String comp_id)
    {
        totheCloud.getcompbyid(comp_id);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Subscribe
    public void onServerEvent(ServerEventgetAllCompany serverEventgetAllCompany)
    {
        if (!serverEventgetAllCompany.getEmpr_server_response().equals(null))
        {
            List<Empr_getallcomp>empr_getallcomps=serverEventgetAllCompany.getEmpr_server_response().getEmpr_companies();
            Empr_getallcomp emprGetallcomp=empr_getallcomps.get(0);
                empr_compro2name=emprGetallcomp.getEmpr_compname();
                empr_compro2_bustype=emprGetallcomp.getbusinesstype();
                empr_compro2_des=emprGetallcomp.getDescription();
                empr_compro2_primob=emprGetallcomp.getMobile_no();
                empr_compro2_email=emprGetallcomp.getemail();
                empr_compro2_primobile=emprGetallcomp.getprimarymobile();
                empr_compro2_pricon=emprGetallcomp.getprimaryperson();
                empr_compro2_seccon=emprGetallcomp.getsecondaryperson();
                empr_compro2_secmobile=emprGetallcomp.getsecondarymobile();

                company_name.setText(empr_compro2name);
                pri_mob.setText(empr_compro2_primob);
                primary_person.setText(empr_compro2_pricon);
                secondary_person.setText(empr_compro2_seccon);
                primary_mobiel.setText(String.valueOf(empr_compro2_secmobile));
                secondary_mobile.setText(String.valueOf(empr_compro2_secmobile));
                description.setText(empr_compro2_des);
                businesstype.setText(empr_compro2_bustype);
                email.setText(empr_compro2_email);


            //Toast.makeText(getContext(),bla,Toast.LENGTH_LONG).show();
        }
        else if (serverEventgetAllCompany.getEmpr_server_response().equals(null))

        {

            Toast.makeText(getContext(),"Please connect network and check your connection ",Toast.LENGTH_LONG).show();

        }


    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Subscribe
    public void onErrorEvent(Empr_Error_Event empr_error_event)
    {
        Toast.makeText(getContext(),"Something error "+empr_error_event.toString(),Toast.LENGTH_LONG).show();
    }

    @Override
    public  void  onResume(){
        super.onResume();
        Empr_Busprovider.getBus().register(this);
    }


    @Override
    public void onPause()
    {
        super.onPause();
        Empr_Busprovider.getBus().unregister(this);
    }


}
