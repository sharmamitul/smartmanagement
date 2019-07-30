package com.example.login.apiclient;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static retrofit2.Retrofit.*;

public class ApiClient {

    public static final String BASE_URL = "http://10.0.2.2/api/";
    public static Retrofit retrofit_service = null;

    public static Retrofit getApiClient()
    {
      //  Gson gson = new GsonBuilder().setLenient().create();
        if (retrofit_service==null)
        {

            OkHttpClient.Builder okhttpClientBuilder= new OkHttpClient.Builder();
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            okhttpClientBuilder.addInterceptor(logging);

           // retrofit = new Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

           Retrofit.Builder retrofit = new Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(okhttpClientBuilder.build());

           retrofit_service = retrofit.build();

            Log.d("login","Invoke API Client Method");
        }
        return retrofit_service;

    }

}
