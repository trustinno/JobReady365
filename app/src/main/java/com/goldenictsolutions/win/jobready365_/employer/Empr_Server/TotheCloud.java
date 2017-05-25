package com.goldenictsolutions.win.jobready365_.employer.Empr_Server;

import android.util.Log;

import com.goldenictsolutions.win.jobready365_.employer.Empr_inter.Interface;

import okhttp3.OkHttpClient;
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

}
