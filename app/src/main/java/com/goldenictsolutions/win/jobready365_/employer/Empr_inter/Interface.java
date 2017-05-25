package com.goldenictsolutions.win.jobready365_.employer.Empr_inter;

import com.goldenictsolutions.win.jobready365_.employer.Empr_Server.Server_Response;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_comprodata;

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
    Call<Server_Response> post(@Body Empr_comprodata empr_compro);


    @Multipart
    @PUT("api/company/{id}")
    Call<Server_Response> postImage(@Path("id") String id, @Part MultipartBody.Part image, @Part("logo") RequestBody logo);





    @GET("/api/city")
    Call<Server_Response>getcity(
            @Query("id") int city_id_sp,
            @Query("city") String city
    );


    @GET("api/township/{city_id}")
    Call<Server_Response>gettownship(
            @Path("city_id") int spcity_id
    );

//
//    @POST("api/company/{user_id}")
//    Call<Server_Response>usepost(@Path("user_id")String user_id, @Body Empr_compro empr_compro);

    }