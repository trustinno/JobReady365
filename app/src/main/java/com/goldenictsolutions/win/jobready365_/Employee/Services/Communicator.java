package com.goldenictsolutions.win.jobready365_.Employee.Services;

import android.util.Log;

import com.goldenictsolutions.win.jobready365_.Employee.*;

import com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses.Applicant;
import com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses.Education;
import com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses.Experience;
import com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses.GetResult;
import com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses.Refree;
import com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses.Skill;
import com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses.login;
import com.goldenictsolutions.win.jobready365_.Employee.Services.Event.ErrorEvent;
import com.goldenictsolutions.win.jobready365_.Employee.Services.Event.ServerEvent;
import com.squareup.otto.Produce;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Communicator {
    private static  final String TAG = "Communicator";
    private static final String SERVER_URL = "http://goldenictsolutions.com/";

    public void loginPost(String login_name, String password){

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
            Call<ServerResponse> call = service.post(new login(login_name,password));
            //Call<ServerResponse> call = service.post(username,password);
            call.enqueue(new Callback<ServerResponse>() {
                @Override
                public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                    // response.isSuccessful() is true if the response code is 2xx
                    Log.e(TAG, "Success"+response.code());
                    Log.e(TAG, "Success"+response.body());
                    Log.e(TAG, "Success"+response.message());
                    BusProvider.getInstance().post(new ServerEvent(response.body()));
                    Log.e(TAG, "Success");

                }

                @Override
                public void onFailure(Call<ServerResponse> call, Throwable t) {
                    // handle execution failures like no internet connectivity
                    Log.e(TAG, "Failure "+t.getMessage());
                    BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
                }
            });
    }

    public void loginGet(String username, String password){

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

        //Call<ServerResponse> call = service.get("login",username,password);
        Call<ServerResponse> call = service.get(username,password);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                // response.isSuccessful() is true if the response code is 2xx
                BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG,"Success");
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                BusProvider.getInstance().post(new ErrorEvent(-2,t.getMessage()));
            }
        });
    }

    public void getResult( String category, String location, String type, String api_key){

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


        Call<ServerResponse> call = service.postGetResult(new GetResult(category,location,type), api_key);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                // response.isSuccessful() is true if the response code is 2xx
                Log.e(TAG, "Success"+response.code());
                Log.e(TAG, "Success"+response.body());
               Log.e(TAG, "Success"+response.message());
                BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG, "Success");

            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure "+t.getMessage());
                BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });
    }

    public void createApplicant(String userId, String firstName, String lastName,
                                String maritalStatus, String gender, String dateOfBirth,
                                String mobileNo, String email, String address, String township,
                                String postalCode, String city, String country, List<Education> educationList,
                                List<Skill> skillList, List<Experience> experienceList,
                                List<Refree> refreeList){

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


        Call<ServerResponse> call = service.createApplicant(new Applicant(userId,firstName,lastName,maritalStatus,
                gender,dateOfBirth,mobileNo,email,address,township,postalCode,city,country,educationList,skillList,
                experienceList,refreeList));

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                // response.isSuccessful() is true if the response code is 2xx
                Log.e(TAG, "Success"+response.code());

                Log.e(TAG, "Success"+response.body());
                Log.e(TAG, "Success"+response.message());
                BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG, "Success");

            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure "+t.getMessage());
                BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });
    }

    public void getApplicant(String userId, String api_key){

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


        Call<ServerResponse> call = service.getApplicant(userId,api_key);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                // response.isSuccessful() is true if the response code is 2xx
                Log.e(TAG, "Success"+response.code());

                Log.e(TAG, "Success"+response.body());
                Log.e(TAG, "Success"+response.message());
                BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG, "Success");

            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure "+t.getMessage());
                BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });
    }


    @Produce
    public ServerEvent produceServerEvent(ServerResponse serverResponse) {
        return new ServerEvent(serverResponse);
    }

    @Produce
    public ErrorEvent produceErrorEvent(int errorCode, String errorMsg) {
        return new ErrorEvent(errorCode, errorMsg);
    }
}
