package com.goldenictsolutions.win.jobready365_.Employee;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.goldenictsolutions.win.jobready365_.Employee.LanguageHandler.LanguageHandler;
import com.goldenictsolutions.win.jobready365_.R;

import java.util.Locale;

public class JPolicy extends AppCompatActivity {

    private Button btnNext;
    private Switch aSwitch;
    Locale myLocale;
    static int counter =1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jpolicy);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        aSwitch = (Switch) findViewById(R.id.switch4);

        btnNext = (Button) findViewById(R.id.btn_next);

        if(counter % 2 == 0) {
            aSwitch.setChecked(true);

        }else {
            aSwitch.setChecked(false);

        }



        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // LanguageHandler.changeLocale(getResources(), "my");

                ///aSwitch
               // setLocale("my");



                counter++;

                if(counter % 2 == 0) {
                   // aSwitch.setChecked(true);
                    setLocale("my");
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }else {
                   // aSwitch.setChecked(false);
                    setLocale("en");
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }

            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JPolicy.this, JLoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                //  LanguageHandler.changeLocale(getResources(), "my");
                //   restartActivity();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // refresh your views here
        super.onConfigurationChanged(newConfig);
    }
    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        Intent intent = new Intent(this, JSignUpActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

    }


    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, JPolicy.class);
        startActivity(refresh);

    }


}

