package com.goldenictsolutions.win.jobready365_.employer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.goldenictsolutions.win.jobready365_.JSignUpActivity;
import com.goldenictsolutions.win.jobready365_.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class Emprcompro extends AppCompatActivity {
   private   Spinner  townshipspinner,statematerialspinner;
    public  String [] Yan={"Sanchaung","Alone"};
   public   String []Man={"Amarapuya","IDK"};
    public  String[] Shan={"Larsho","Taunggyi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empr_comp_pro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String [] state={"Yangon","Mandalay","ShanState"};
        //ArrayAdapter<String> yanadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,Yan);
       // ArrayAdapter<String>manadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,Man);
       // ArrayAdapter<String>shanadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,Shan);
        ArrayAdapter<String>townadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,Yan);
        townshipspinner=(Spinner) findViewById(R.id.township_spinner);
        townshipspinner.setAdapter(townadapter);

        ArrayAdapter <String> stateadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,state);


        statematerialspinner=(Spinner) findViewById(R.id.state_spinner);
        statematerialspinner.setAdapter(stateadapter);
        statematerialspinner.setOnItemSelectedListener(new OnClickListenervalue());


        Button button=(Button)findViewById(R.id.gotopost);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Emprcompro.this,Emprjobpost.class);
                startActivity(intent);


            }
        });

    }

    private class OnClickListenervalue implements AdapterView.OnItemSelectedListener {

        @Override

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            String bla=parent.getSelectedItem().toString();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
