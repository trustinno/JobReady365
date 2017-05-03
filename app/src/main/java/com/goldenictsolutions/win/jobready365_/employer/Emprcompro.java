package com.goldenictsolutions.win.jobready365_.employer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.goldenictsolutions.win.jobready365_.JSignUpActivity;
import com.goldenictsolutions.win.jobready365_.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class Emprcompro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empr_comp_pro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String [] state={"Yangon","Mandalay","ShanState"};
        ArrayAdapter <String> stateadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,state);
        MaterialBetterSpinner statematerialspinner=(MaterialBetterSpinner)findViewById(R.id.township_spinner);
        statematerialspinner.setAdapter(stateadapter);




        Button button=(Button)findViewById(R.id.gotopost);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Emprcompro.this,Emprjobpost.class);
                startActivity(intent);


            }
        });

    }

}
