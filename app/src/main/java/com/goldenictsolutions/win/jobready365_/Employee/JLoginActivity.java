package com.goldenictsolutions.win.jobready365_.Employee;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.goldenictsolutions.win.jobready365_.Employee.*;

import com.goldenictsolutions.win.jobready365_.Employee.LanguageHandler.LanguageHandler;
import com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses.User;
import com.goldenictsolutions.win.jobready365_.Employee.Services.BusProvider;
import com.goldenictsolutions.win.jobready365_.Employee.Services.Communicator;
import com.goldenictsolutions.win.jobready365_.Employee.Services.Event.ErrorEvent;
import com.goldenictsolutions.win.jobready365_.Employee.Services.Event.ServerEvent;
import com.goldenictsolutions.win.jobready365_.R;
import com.squareup.otto.Subscribe;

public class JLoginActivity extends AppCompatActivity {
    // textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;



    private Communicator communicator;
    private String username, password , token;
    private Button btnRegisterAsEmployer,btnRegisterAsEmployee;
    private Button btnLogin;
    private TabLayout tabLayoutLanguage;
    private EditText usernameET;
    private EditText passwordET;
    static User user;
  //  private RadioButton rBtnEmployee,rBtnEmployer;
    private int user_type;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jlogin);

        communicator = new Communicator();
        btnLogin = (Button) findViewById(R.id.btn_login);
       // rBtnEmployee = (RadioButton)findViewById(R.id.radioButton_employee);
       // rBtnEmployer = (RadioButton)findViewById(R.id.radioButton_employer);
       /* if(rBtnEmployee.isChecked()){
            rBtnEmployer
        }
        */

      //  addListenerOnButton();

        usernameET = (EditText) findViewById(R.id.input_email);
        passwordET = (EditText) findViewById(R.id.input_password);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameET.getText().toString();
                password = passwordET.getText().toString();
                if ((!(username.isEmpty()) & (!password.isEmpty()))) {
                    progressDialog = new ProgressDialog(JLoginActivity.this);
                    progressDialog.setMessage("logging in ...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    usePost(username, password);
                } else if (username.isEmpty() & password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter your username and password again", Toast.LENGTH_SHORT).show();
                } else if (username.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter your username again", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter your password again", Toast.LENGTH_SHORT).show();
                }
            }
        });


        tabLayoutLanguage = (TabLayout) findViewById(R.id.tab_layout_language);

        tabLayoutLanguage.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {

                    //   Toast.makeText(getApplicationContext(),"00000",Toast.LENGTH_SHORT).show();

                    case 1:
                        //  Toast.makeText(getApplicationContext(),"00000",Toast.LENGTH_SHORT).show();
                        LanguageHandler.changeLocale(getResources(), "my");
                        restartActivity();

                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        LanguageHandler.changeLocale(getResources(), "en");
                        restartActivity();
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            /*
                switch(tab.getPosition()){
                    case 0:
                        //   Toast.makeText(getApplicationContext(),"00000",Toast.LENGTH_SHORT).show();
                        LanguageHandler.changeLocale(getResources(), "my");
                        restartActivity();
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                    case 1:
                        //  Toast.makeText(getApplicationContext(),"00000",Toast.LENGTH_SHORT).show();
                        LanguageHandler.changeLocale(getResources(),"en");
                        restartActivity();
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                }

                */

            }
        });
        btnRegisterAsEmployer = (Button) findViewById(R.id.btn_as_employer);
        btnRegisterAsEmployer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JLoginActivity.this, JSignUpActivity.class);

                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });
        btnRegisterAsEmployee = (Button) findViewById(R.id.btn_as_employee);
        btnRegisterAsEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(JLoginActivity.this, JSignUpActivity.class);

                startActivity(intent1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
/*
    public void addListenerOnButton() {

        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
        btnRegisterAsEmployer = (Button) findViewById(R.id.btn_as_employer);

        rBtnEmployer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioSexGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(getApplicationContext(),
                        radioSexButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });

    }

*/

    private void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);

    }

    private void usePost(String username, String password) {
        communicator.loginPost(username, password);
    }

    @Subscribe
    public void onServerEvent(ServerEvent serverEvent) {


        // Toast.makeText(getApplicationContext(), "onServerEvent sucess " + serverEvent.getServerResponse().getToken(), Toast.LENGTH_SHORT).show();
        if (serverEvent.getServerResponse() == null) {
            Toast.makeText(getApplicationContext(),  "invalid credentials", Toast.LENGTH_SHORT).show();
        } else if(serverEvent.getServerResponse() != null){
            Toast.makeText(getApplicationContext(), serverEvent.getServerResponse().getToken(), Toast.LENGTH_SHORT).show();
            token = serverEvent.getServerResponse().getToken();
            progressDialog.hide();
            Intent intent = new Intent(this,JResumeActivity.class);
            startActivity(intent);
        }

    }

    @Subscribe
    public void onErrorEvent(ErrorEvent errorEvent) {
        Toast.makeText(this, "onErrorEvent fail " + errorEvent.getErrorMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }



    @Override
    public void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_button_sign_up_employer:
                if (checked)
                    // Pirates are the best
                    user_type = 1;
                break;
            case R.id.radio_button_sign_up_employee:
                if (checked)
                    // Ninjas rule
                    user_type = 2;
                break;
        }
    }



}
