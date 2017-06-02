package com.goldenictsolutions.win.jobready365_.Employee;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;


import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import com.goldenictsolutions.win.jobready365_.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class JResumeActivity extends AppCompatActivity {
    // activity requestcode
    private static TextView editTextDateOfBirth;
    private ImageView imageViewTakePhoto;
    private EditText editTextTakePhoto;
    private Spinner nrcNumber;
    private Spinner nrcDivisionCode;
    private Spinner spinnerMaritalStatus;
    private Spinner spinnerReligion;
    private Spinner spinnerTownship;
    private Spinner spinnerStateDivision;
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    private static final int CAMERA_CAPTURE_VIDEO_REQUEST_CODE = 200;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;

    // directory name to store captured images and videos
    private static final String IMAGE_DIRECTORY_NAME = "Hello Camera";
    private Uri fileUri; // file url to store image/video

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jresume);
        imageViewTakePhoto = (ImageView) findViewById(R.id.imageView2);
        editTextTakePhoto = (EditText) findViewById(R.id.editText2);
        nrcNumber = (Spinner)findViewById(R.id.spinner7);
        nrcDivisionCode = (Spinner)findViewById(R.id.spinner);

        spinnerMaritalStatus = (Spinner)findViewById(R.id.spinner_marital_status);
        spinnerReligion = (Spinner) findViewById(R.id.spinner_religion);
        spinnerStateDivision = (Spinner) findViewById(R.id.spinner_state_division);
        spinnerTownship = (Spinner)findViewById(R.id.spinner_township);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.nrc_number, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        nrcNumber.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.nrc_division_code, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        nrcDivisionCode.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.spin_religion, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerReligion.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.spin_marital_status, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerMaritalStatus.setAdapter(adapter3);

        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.spin_state_division, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerStateDivision.setAdapter(adapter4);

        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.spin_township, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerTownship.setAdapter(adapter5);



        imageViewTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureImage();
            }
        });
        editTextTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureImage();
            }


        });

        // Checking camera availability
        if (!isDeviceSupportCamera()) {
            Toast.makeText(getApplicationContext(), "Sorry! Your device doesn't support camera", Toast.LENGTH_LONG).show();
            // will close the app if the device does't have camera
            finish();
        }


        editTextDateOfBirth = (TextView) findViewById(R.id.editText4);
        editTextDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DateofBirthPickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");
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

    // Checking device has camera hardware or not
    private boolean isDeviceSupportCamera() {
        if (getApplicationContext().getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA)) {
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    //      * Here we store the file url as it will be null after returning from camera
    //      * app

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // save file url in bundle as it will be null on scren orientation
        // changes
        outState.putParcelable("file_uri", fileUri);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // get the file url
        fileUri = savedInstanceState.getParcelable("file_uri");
    }


    /*
 * Capturing Camera Image will lauch camera app requrest image capture
 */
    private void captureImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        ///fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Environment.DIRECTORY_PICTURES);
        startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);



        // start the image capture Intent



    }

    /**
     *      * Receiving activity result method will be called after closing the camera
     *      *
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            // if the result is capturing Image
        if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
            // successfully captured the image
            // display it in image view
               // previewCapturedImage();
            } else if (resultCode == RESULT_CANCELED) {
            // user cancelled Image capture
                Toast.makeText(getApplicationContext(), "User cancelled image capture", Toast.LENGTH_SHORT).show();
            } else {
            // failed to capture image
                Toast.makeText(getApplicationContext(), "Sorry! Failed to capture image", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void previewCapturedImage() {
    }

    // ------------ Helper Methods ---------

    // Creating file uri to store image

    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    // returning image / video
    private static File getOutputMediaFile(int type) {

        // External sdcard location
        File mediaStorageDir = new File(Environment.DIRECTORY_PICTURES);
/*
        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create " + IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }

 */
        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());

        File mediaFile;

            mediaFile = new File( timeStamp+ ".jpg");


        return mediaFile;
    }


    // helper class for DatePicker
    public static class DateofBirthPickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            Calendar c = Calendar.getInstance();


            int year = c.get(Calendar.YEAR);

            int month = c.get(Calendar.MONTH);

            int day = c.get(Calendar.DAY_OF_MONTH);


            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }


        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            editTextDateOfBirth.setText(year + "-" + (month + 1) + "-" + day);
            //
        }


    }


}
