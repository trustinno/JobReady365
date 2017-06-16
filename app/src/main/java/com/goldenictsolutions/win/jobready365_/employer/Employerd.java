package com.goldenictsolutions.win.jobready365_.employer;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.goldenictsolutions.win.jobready365_.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class Employerd extends AppCompatActivity implements OnTabSelectListener {
String userid;
    Fragment fragment=new Fragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);
//
        Bundle bundle=getIntent().getExtras();
       // userid=bundle.getString("userid_get");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(this);
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.empr_container, new EmprDashboard());
        //        bundle.putString("userid_get",userid);
        //      fragment.setArguments(bundle);
        fragmentTransaction.commit();

    }


    @Override
    public void onTabSelected(@IdRes int tabId) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (tabId == R.id.tab_dash)

        {
            fragmentTransaction.replace(R.id.empr_container, new EmprDashboard());
           // Bundle bundle=new Bundle();
            //bundle.putString("userid_get",userid);
            //fragment.setArguments(bundle);
            fragmentTransaction.commit();
        } else if (tabId == R.id.tab_post) {
            fragmentTransaction.replace(R.id.empr_container, new Emprpostnewjob());
            fragmentTransaction.commit();
        }
        else if (tabId == R.id.tab_view) {
            fragmentTransaction.replace(R.id.empr_container, new Empr_shortlist());
            fragmentTransaction.commit();
        }

        else if (tabId == R.id.tab_search) {

        }

        else if (tabId == R.id.tab_bla) {
            fragmentTransaction.replace(R.id.empr_container, new EmprOther());
            fragmentTransaction.commit();
        }
    }
}

