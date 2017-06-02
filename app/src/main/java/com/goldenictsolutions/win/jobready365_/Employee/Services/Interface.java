package com.goldenictsolutions.win.jobready365_.Employee.Services;

import com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses.*;
import com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses.Applicant;
import com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses.GetResult;
import com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

public interface Interface {
    @Headers({
            "Accept: application/json",
           "Content-Type: application/json",
           //  "Authorization: Basic ZWlwaHl1cGh5dWhsYWluZ0BnbWFpbC5jb206MTIzNDU2Nzg="
    })
    //@FormUrlEncoded
    @POST("/api/login")
    //Call<ServerResponse> post(@Body @Root("email") String email,@Root("password") String password);
    Call<ServerResponse> post(@Body login body);
    //Call<ServerResponse> post(@Body login login);
   /* Call<ServerResponse> post(
            //@Field("method") String method,
            @Field("email") String username,
            @Field("password") String password
    );*/

    //@FormUrlEncoded
    @POST("/api/register")
    //Call<ServerResponse> post(@Body @Root("email") String email,@Root("password") String password);
    Call<ServerResponse> postSignUp(@Body SignUp body);
    //Call<ServerResponse> post(@Body login login);

    @POST("/api/getResult")
        //Call<ServerResponse> post(@Body @Root("email") String email,@Root("password") String password);
    Call<ServerResponse> postGetResult(@Body GetResult body, @Query("token") String apiKey);
    //Call<ServerResponse> post(@Body login login);
    @Multipart
    @POST("api/upload.php")
    Call<ServerResponse> uploadImage(@Part MultipartBody.Part file);

//    @GET("/api/jobcat")
 //   Call<ServerResponse> getJobcat(@Query("token"), @Path("JobCategory"));

 //   @GET("/api/location")
//    Call<ServerResponse> getJobLocation(@Query("token"),@Path("city"));

 //   @GET("/api/type")
 //   Call<ServerResponse> getJobtype(@Query("token"),@Path("Jobtype"));

 //   @GET("/api/type")
 //   Call<ServerResponse> getJobtype(@Query("token"),@Path("Jobtype"));




  //  @POST("/api/getResult")
  //  Call<ServerResponse> getResult(@Query("") String);

    @POST("/api/jobseeker")
    Call<ServerResponse> createApplicant(@Body Applicant body);

    @GET("/api/jobseeker/{user_id}")
    Call<ServerResponse> getApplicant(@Path("user_id") String userId, @Query("token") String apiKey);
}