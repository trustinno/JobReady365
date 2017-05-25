package com.goldenictsolutions.win.jobready365_.employer;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.goldenictsolutions.win.jobready365_.R;

public class Emprpostnewjob extends Fragment {

    public Emprpostnewjob() {
        // Required empty public constructor
    }

    EditText editTextdialog;
    TextView editText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_emprpostnewjob, container, false);

        String[] SPINNERLIST = {"Freelance", "Full Time", "Part Time", "Contract"};
        String[] spinner = {"Alone", "Sanchaung"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST);
   Spinner      materialDesignSpinner = (Spinner)
                view.findViewById(R.id.android_material_design_spinner);
        materialDesignSpinner.setAdapter(arrayAdapter);
        editText = (TextView) view.findViewById(R.id.editquilifi);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextdialog = new EditText(getActivity());
                final Dialog dialog = new Dialog(getActivity());
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.setContentView(R.layout.empr_qul_dialog);
                TextView editText2 = (TextView)v.findViewById(R.id.editquilifi);
                String reedit = editText2.getText().toString();
                editTextdialog.setText(reedit);
                final Button diaglogbutton = (Button) dialog.findViewById(R.id.diaglog_button);
                final Button diaglogbuttoncancle = (Button) dialog.findViewById(R.id.diaglog_buttoncancle);
                diaglogbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editTextdialog = (EditText) dialog.findViewById(R.id.dialogedit);
                        String dialogstr = editTextdialog.getText().toString();
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

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, spinner);

        Spinner materialDesignSpinner1 = (Spinner)
                view.findViewById(R.id.android_material_design_spinner);
        materialDesignSpinner1.setAdapter(arrayAdapter1);


        return view;
    }
}