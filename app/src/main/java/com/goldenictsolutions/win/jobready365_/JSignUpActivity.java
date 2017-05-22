package com.goldenictsolutions.win.jobready365_;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.goldenictsolutions.win.jobready365_.employer.Emprcompro;

public class JSignUpActivity extends AppCompatActivity {

    private Button btnLogin;
    private TextView textView;
    private TabLayout tabLayout;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_jsign_up);
    btnLogin= (Button)findViewById(R.id.btn_login);
    btnLogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(JSignUpActivity.this,JResumeActivity.class);
        startActivity(intent);
      }
    });
      textView=(TextView)findViewById(R.id.gotoemp);
      textView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(JSignUpActivity.this, Emprcompro.class);
              startActivity(intent);
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

}
