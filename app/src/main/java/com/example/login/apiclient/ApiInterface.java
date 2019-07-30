package com.example.login.apiclient;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("register.php")
    Call<User> performRegistration(@Field("name") String Name, @Field("user_name") String UserName, @Field("user_password") String UserPassword);

    @FormUrlEncoded
    @POST("login.php")
    Call<User> performUserLogin(@Field("user_name") String UserName, @Field("user_password") String UserPassword);


}
