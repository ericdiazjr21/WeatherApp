package com.example.weatherapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static Retrofit singleInstance;

    private RetrofitSingleton(){}

    public static Retrofit getSingleInstance(){
        if(singleInstance == null){
            singleInstance = new Retrofit.Builder()
                    .baseUrl("http://api.aerisapi.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return singleInstance;
        }else{
            return singleInstance;
        }
    }

}
