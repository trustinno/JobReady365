package com.goldenictsolutions.win.jobready365_.employer;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.goldenictsolutions.win.jobready365_.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class Employerd extends AppCompatActivity implements OnTabSelectListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);
//
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(this);
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.empr_container, new EmprDashboard());
        fragmentTransaction.commit();

    }
    @Override
    public void onTabSelected(@IdRes int tabId) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (tabId == R.id.tab_favorites)

        {
            fragmentTransaction.replace(R.id.empr_container, new EmprDashboard());
            fragmentTransaction.commit();
        } else if (tabId == R.id.tab_nearby) {
            fragmentTransaction.replace(R.id.empr_container, new Emprpostnewjob());
            fragmentTransaction.commit();
        }
        else if (tabId == R.id.tab_friends) {
            fragmentTransaction.replace(R.id.empr_container, new EmprCandilist());
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

