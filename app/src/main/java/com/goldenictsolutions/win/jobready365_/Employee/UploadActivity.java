package com.goldenictsolutions.win.jobready365_.Employee;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.goldenictsolutions.win.jobready365_.R;

public class UploadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
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

    /**
          * Uploading the file to server
          * *
private class UploadFileToServer extends AsyncTask<Void, Integer, String> {
@Override
protected void onPreExecute() {
// setting progress bar to zero
progressBar.setProgress(0);
super.onPreExecute();
@Override
protected void onProgressUpdate(Integer...progress){
// Making progress bar visible
progressBar.setVisibility(View.VISIBLE);
// updating progress bar value
progressBar.setProgress(progress[0]);
// updating percentage value
txtPercentage.setText(String.valueOf(progress[0]) + "%");
}

@Override
protected String doInBackground(Void... params) {
return uploadFile();
}
@SuppressWarnings("deprecation")
private String uploadFile(){
String responseString = null;
HttpClient httpclient = new DefaultHttpClient();
HttpPost httppost = new HttpPost(Config.FILE_UPLOAD_URL);
try {
AndroidMultiPartEntity entity = new AndroidMultiPartEntity(new ProgressListener() {
@Override
public void transferred(long num) {
publishProgress((int) ((num / (float) totalSize) * 100));
}
});
File sourceFile = new File(filePath);
// Adding file data to http body
entity.addPart("image", new FileBody(sourceFile));
// Extra parameters if you want to pass to server
entity.addPart("website", new StringBody("www.androidhive.info"));
entity.addPart("email", new StringBody("abc@gmail.com"));
totalSize = entity.getContentLength();
httppost.setEntity(entity);
// Making server call
HttpResponse response = httpclient.execute(httppost);
HttpEntity r_entity = response.getEntity();
int statusCode = response.getStatusLine().getStatusCode();
if (statusCode == 200) {
    // Server response
responseString = EntityUtils.toString(r_entity);
} else {responseString = "Error occurred! Http Status Code: "
    + statusCode;
}
} catch (ClientProtocolException e) {
responseString = e.toString();
    } catch (IOException e) {
                responseString = e.toString();
            }
 
            return responseString;
 
        }
 
                @Override
        protected void onPostExecute(String result) {
            Log.e(TAG, "Response from server: " + result);
 
            // showing the server response in an alert dialog
            showAlert(result);
 
            super.onPostExecute(result);
        }
 
            }
 
            /**
      * Method to show alert dialog
      
            private void showAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message).setTitle("Response from Servers")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // do nothing
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
 
}
**/
}
