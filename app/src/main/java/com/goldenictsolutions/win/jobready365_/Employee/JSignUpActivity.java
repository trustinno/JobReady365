package com.goldenictsolutions.win.jobready365_.Employee;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.goldenictsolutions.win.jobready365_.Employee.Services.BusProvider;
import com.goldenictsolutions.win.jobready365_.Employee.Services.Communicator;
import com.goldenictsolutions.win.jobready365_.Employee.Services.Event.ErrorEvent;
import com.goldenictsolutions.win.jobready365_.Employee.Services.Event.ServerEvent;
import com.goldenictsolutions.win.jobready365_.R;
import com.squareup.otto.Subscribe;

public class JSignUpActivity extends AppCompatActivity {
        ProgressDialog progressDialog;
    private static String token;
    private static Switch switchAutoLogin ;
    private Button registrationButton;
    private EditText telephoneET;
    private EditText passwordET;
    private EditText verifyPasswordET;
    private String telephone;
    private String password;
    private String verifyPassword;
    private Communicator communicator;
    private int user_type =2;
    private Boolean autoLoginBoolean = false ;
    private RadioGroup radioSignUpGroup;
    private RadioButton radioSignUpButtonEmployer;
    private RadioButton radioSignUpButtonEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsign_up);
        radioSignUpButtonEmployer = (RadioButton)findViewById(R.id.radio_button_sign_up_employer);
        radioSignUpButtonEmployee = (RadioButton)findViewById(R.id.radio_button_sign_up_employee);


        communicator = new Communicator();

        radioSignUpGroup = (RadioGroup) findViewById(R.id.radio_group_sign_up);
        telephoneET = (EditText) findViewById(R.id.input_email_sign_up);
        passwordET = (EditText) findViewById(R.id.input_password_sign_up);
        verifyPasswordET = (EditText) findViewById(R.id.input_verify_password);


        switchAutoLogin = (Switch) findViewById(R.id.switch_auto_login);
        switchAutoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchAutoLogin.setChecked(true);
                autoLoginBoolean = true;
            }
        });
        registrationButton = (Button) findViewById(R.id.btn_registration);
        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telephone = telephoneET.getText().toString();
                password = passwordET.getText().toString();
                verifyPassword = verifyPasswordET.getText().toString();

                //     useSignUpPost(telephone, password, 1, "", "");

                if ((!(telephone.isEmpty()) & (!password.isEmpty()))) {
                    if (!(password.equals(verifyPassword))){
                        Toast.makeText(getApplicationContext(), "Verify your password again", Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog = new ProgressDialog(JSignUpActivity.this);
                        progressDialog.setMessage("logging in ...");
                        progressDialog.setCancelable(false);
                        progressDialog.show();
                        useSignUpPost(telephone, password, user_type, " ", " ");
                    }
                } else if (telephone.isEmpty() & password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter your username and password again", Toast.LENGTH_SHORT).show();
                } else if (telephone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter your username again", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter your password again", Toast.LENGTH_SHORT).show();
                }
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
*/


    private void useSignUpPost(String telephone, String password, int type, String email, String userName) {
        communicator.SignUpPost(telephone, password, type, email, userName);
    }

    @Subscribe
    public void onServerEvent(ServerEvent serverEvent) {


        // Toast.makeText(getApplicationContext(), "onServerEvent sucess " + serverEvent.getServerResponse().getToken(), Toast.LENGTH_SHORT).show();
        if (serverEvent.getServerResponse() == null) {
            Toast.makeText(getApplicationContext(), "invalid credentials", Toast.LENGTH_SHORT).show();
        } else if (serverEvent.getServerResponse() != null) {
            progressDialog.hide();
            Toast.makeText(getApplicationContext(), "respond from server autoLogin ??? "+ autoLoginBoolean, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(JSignUpActivity.this,JPolicy.class);
            startActivity(intent);
        }

    }

    @Subscribe
    public void onErrorEvent(ErrorEvent errorEvent) {
        Toast.makeText(getApplicationContext(), "onErrorEvent fail " + errorEvent.getErrorMsg(), Toast.LENGTH_LONG).show();
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
