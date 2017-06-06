package com.goldenictsolutions.win.jobready365_.employer.Empr_inter;

import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.Empr_Server_Response;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_JobType;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_comprodata;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.empr_company;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.empr_postjob;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by zarni on 5/23/17.
 */

public interface Interface {
//

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json",
            //  "Authorization: Basic ZWlwaHl1cGh5dWhsYWluZ0BnbWFpbC5jb206MTIzNDU2Nzg="
    })


    @POST("api/company")
    Call<Empr_Server_Response> post(@Body Empr_comprodata empr_compro);


    @Multipart
    @PUT("api/company/{id}")
    Call<Empr_Server_Response> postImage(@Path("id") String id, @Part MultipartBody.Part image, @Part("logo") RequestBody logo);

    @GET("/api/city")
    Call<Empr_Server_Response>getcity(
            @Query("id") int city_id_sp,
            @Query("city") String city
    );


    @GET("api/township/{city_id}")
    Call<Empr_Server_Response>gettownship(
            @Path("city_id") int spcity_id
    );

    @GET("api/industry")
    Call<Empr_Server_Response> getbussty(
            @Query("id") int bus_id,
            @Query("jobindustry")String jobindustry);


    @GET("api/category")
    Call<Empr_Server_Response>getjobcategory(
            @Query("id")int jocat_id,
            @Query("category")String jobcate
    );

    @GET("api/type")
    Call<Empr_Server_Response> getjobtp(
            @Query("id")int jobtp_id,
            @Query("type")String jobtp_type
    );

    @GET("api/all_company/{user_id}")
    Call<Empr_Server_Response>getallcompnay(@Path("user_id")String empr_dash_userid,
                                            @Query("id")String companyId);


    @GET("api/company/{id}")
    Call<Empr_Server_Response>getcompanybyid(@Path("id")String comp_id);

    @POST("api/company")
    Call<Empr_Server_Response> post(@Body empr_company empr_company);

    @POST("api/job")
    Call<Empr_Server_Response>postjob(@Body empr_postjob empr_postjob);



//
//    @POST("api/company/{user_id}")
//    Call<Empr_Server_Response>usepost(@Path("user_id")String user_id, @Body Empr_compro empr_compro);

    }