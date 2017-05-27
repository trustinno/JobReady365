package com.goldenictsolutions.win.jobready365_.employer;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.goldenictsolutions.win.jobready365_.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class Emprjobpost extends AppCompatActivity {
    EditText editTextdialog;
    TextView editText;
    Button diaglogbutton,diaglogbuttoncancle,dialgoyes,dialogno;
    Dialog dialog,backdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprjobpost);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] SPINNERLIST = {"Freelance", "Full Time", "Part Time", "Contract"};
        String[] spinner={"Alone","Sanchaung"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST);
        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner)
                findViewById(R.id.android_material_design_spinner);
        materialDesignSpinner.setAdapter(arrayAdapter);
        editText=(TextView) findViewById(R.id.editquilifi);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextdialog=new EditText(Emprjobpost.this);
                  dialog = new Dialog(Emprjobpost.this);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.width=WindowManager.LayoutParams.MATCH_PARENT;
                lp.height=WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.setContentView(R.layout.empr_qul_dialog);
                TextView editText2=(TextView) findViewById(R.id.editquilifi);
                String reedit=editText2.getText().toString();
                editTextdialog.setText(reedit);
                diaglogbutton=(Button)dialog.findViewById(R.id.diaglog_button);
                diaglogbuttoncancle=(Button)dialog.findViewById(R.id.diaglog_buttoncancle);
                diaglogbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editTextdialog=(EditText)dialog.findViewById(R.id.dialogedit);
                        String dialogstr=editTextdialog.getText().toString();
                        dialog.dismiss();
                        editText.setText(dialogstr);

                    }
                });
                diaglogbuttoncancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.getWindow().setAttributes(lp);

                dialog.show();

            }
        });

        ImageView imageView=(ImageView)findViewById(R.id.empr_back_icon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Emprjobpost.this, Emprcompro.class);
                startActivity(intent);
            }
        });


//        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,
//                android.R.layout.simple_dropdown_item_1line, spinner);
//        MaterialBetterSpinner materialDesignSpinner1 = (MaterialBetterSpinner)
//                findViewById(R.id.android_material_design_spinner1);
//        materialDesignSpinner.setAdapter(arrayAdapter);
//
//        Button btn=(Button)findViewById(R.id.gotoemp);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Emprjobpost.this,Emprjobpost.class);
//                startActivity(intent);
//            }
//        });


    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exitByBackKey() {
        final Dialog backdialogg =new Dialog(Emprjobpost.this);
        backdialogg.setContentView(R.layout.empr_backpress);

    }
//    @Override
//    public void onBackPressed() {
//       final Dialog backdialogg =new Dialog(Emprjobpost.this);
//        backdialogg.setContentView(R.layout.empr_backpress);
////        dialgoyes=(Button)backdialog.findViewById(R.id.backyes);
////      dialogno=(Button)backdialog.findViewById(R.id.backyes);
////        dialgoyes.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////            }
////        });
//  return;
//    }

}
