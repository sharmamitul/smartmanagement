package com.example.login.apiclient;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("register.php")
    Call<User> performRegistration(@Field("userid") String Userid,@Field("firstname") String FirstName, @Field("lastname") String LastName, @Field("email") String Email, @Field("contact") String Contact, @Field("company") String Company, @Field("designation") String designation, @Field("role") String Role, @Field("password") String Password );

    @FormUrlEncoded
    @POST("login.php")
    Call<User> performUserLogin(@Field("userid") String UserName, @Field("password") String UserPassword);

}
