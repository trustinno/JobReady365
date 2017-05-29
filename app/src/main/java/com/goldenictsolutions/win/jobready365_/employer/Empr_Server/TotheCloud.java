package com.goldenictsolutions.win.jobready365_.employer.Empr_Server;

import android.util.Log;

import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_comprodata;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.empr_company;
import com.goldenictsolutions.win.jobready365_.employer.Empr_inter.Interface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zarni on 5/25/17.
 */

public class TotheCloud {
    public static final String TAG="TotheCloud";
    public static final String SERVER_URL ="http://www.myanmar-online.com";

    public void getspcity(int city_id_sp,String city){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();
        Interface service = retrofit.create(Interface.class);
        //Call<ServerResponse> call = service.post("login",username,password);
        //Call<ServerResponse> call = service.post(username,password);
        Call<Empr_Server_Response> call = service.getcity(city_id_sp,city);
        //Call<ServerResponse> call = service.post(username,password);
        call.enqueue(new Callback<Empr_Server_Response>() {
            @Override
            public void onResponse(Call<Empr_Server_Response> call, Response<Empr_Server_Response> response) {
                Log.e(TAG, "Success" + response.code());
                Log.e(TAG, "Success" + response.body());
                Log.e(TAG, "Success" + response.message());
                Empr_Busprovider.getBus().post(new ServerEventSpinnercity(response.body()));
                Log.e(TAG, "Success");
            }

            @Override
            public void onFailure(Call<Empr_Server_Response> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure "+t.getMessage());
                Empr_Busprovider.getBus().post(new Empr_Error_Event(-2, t.getMessage()));
            }
        });
    }


    public void gettownship(int spcity_id) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();
        Interface service = retrofit.create(Interface.class);
        //Call<ServerResponse> call = service.post("login",username,password);
        //Call<ServerResponse> call = service.post(username,password);
        Call<Empr_Server_Response> call = service.gettownship(spcity_id);
        //Call<ServerResponse> call = service.post(username,password);
        call.enqueue(new Callback<Empr_Server_Response>() {
            @Override
            public void onResponse(Call<Empr_Server_Response> call, Response<Empr_Server_Response> response) {
                Log.e(TAG, "Success" + response.code());
                Log.e(TAG, "Success" + response.body());
                Log.e(TAG, "Success" + response.message());
                Empr_Busprovider.getBus().post(new ServerEventSpinnerTownship(response.body()));
                Log.e(TAG, "Success");
            }

            @Override
            public void onFailure(Call<Empr_Server_Response> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure " + t.getMessage());
              Empr_Busprovider.getBus().post(new Empr_Error_Event(-2, t.getMessage()));

            }

        });

    }

    public void getbusindex(int bus_id,String jobindustry) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();
        Interface service = retrofit.create(Interface.class);
        //Call<ServerResponse> call = service.post("login",username,password);
        //Call<ServerResponse> call = service.post(username,password);
        Call<Empr_Server_Response> call = service.getbussty(bus_id,jobindustry);
        //Call<ServerResponse> call = service.post(username,password);
        call.enqueue(new Callback<Empr_Server_Response>() {
            @Override
            public void onResponse(Call<Empr_Server_Response> call, Response<Empr_Server_Response> response) {
                Log.e(TAG, "Success" + response.code());
                Log.e(TAG, "Success" + response.body());
                Log.e(TAG, "Success" + response.message());
                Empr_Busprovider.getBus().post(new ServerEventSpinnerBustype(response.body()));
                Log.e(TAG, "Success");
            }

            @Override
            public void onFailure(Call<Empr_Server_Response> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure " + t.getMessage());
                Empr_Busprovider.getBus().post(new Empr_Error_Event(-2, t.getMessage()));

            }

        });

    }


    public void postcompro(String user_id,String company_name,String logo,String address,int township,int job_industry,int citys,int mobile_no,String email,String website,String description,String primary_contact_person,int primary_mobile,String secondary_contact_person,int secondary_mobile
    )
    {
        HttpLoggingInterceptor logging=new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient=new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit =new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL).build();


        Interface service=retrofit.create(Interface.class);
        Call<Empr_Server_Response>call=service.post(new empr_company(user_id,company_name,logo,address,township,job_industry,citys,mobile_no,email,website,description,primary_contact_person,primary_mobile,secondary_contact_person,secondary_mobile));
        //       logo,
        call.enqueue(new Callback<Empr_Server_Response>() {
            @Override
            public void onResponse(Call<Empr_Server_Response> call, Response<Empr_Server_Response> response) {
                Log.e(TAG,"Success"+response.code());
                Log.e(TAG,"Success"+response.body());
                Log.e(TAG,"Success"+response.message());
              Empr_Busprovider.getBus().post(new Empr_Serverevent(response.body()));
                Log.e(TAG,"Success");
            }

            @Override
            public void onFailure(Call<Empr_Server_Response> call, Throwable t) {
                Log.e(TAG,"Failure"+t.getMessage());
                Empr_Busprovider.getBus().post(new Empr_Error_Event(-2,t.getMessage()));
            }
        });

    }

    public void getjobcate(int jobcate_id, String jobcate) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
       //Gson gson = new GsonBuilder().disableHtmlEscaping().create();

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();
        Interface service = retrofit.create(Interface.class);


        //Call<ServerResponse> call = service.post("login",username,password);
        //Call<ServerResponse> call = service.post(username,password);

        //service.getjobcategory(), HttpHeaderParser.parseCharset(response.headers));
        Call<Empr_Server_Response> call = service.getjobcategory(jobcate_id,jobcate);
        //Call<ServerResponse> call = service.post(username,password);
        call.enqueue(new Callback<Empr_Server_Response>() {
            @Override
            public void onResponse(Call<Empr_Server_Response> call, Response<Empr_Server_Response> response) {
                Log.e(TAG, "Success" + response.code());
                Log.e(TAG, "Success" + response.body());
                Log.e(TAG, "Success" + response.message());
                Empr_Busprovider.getBus().post( new ServerEventSpinnerJobcate(response.body()));
                Log.e(TAG, "Success");
            }

            @Override
            public void onFailure(Call<Empr_Server_Response> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure " + t.getMessage());
                Empr_Busprovider.getBus().post(new Empr_Error_Event(-2, t.getMessage()));

            }

        });


       }
}
