package com.goldenictsolutions.win.jobready365_.Employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.goldenictsolutions.win.jobready365_.Employee.LanguageHandler.LanguageHandler;
import com.goldenictsolutions.win.jobready365_.R;

public class JPolicy extends AppCompatActivity {

    private Button btnNext;
    private Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jpolicy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    aSwitch = (Switch)findViewById(R.id.switch4);

        btnNext = (Button)findViewById(R.id.btn_next);

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageHandler.changeLocale(getResources(), "my");
                   restartActivity();
                ///aSwitch


                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);


            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JPolicy.this,JSignUpActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
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
        aSwitch.setTextOn("mm");
    }



}

