    package com.example.aparat2.webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static String baseUrl = "http://androidsupport.ir/pack/aparat/";
    private static Retrofit retrofit = null;

    private ApiClient() {

    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            return retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
