package com.example.weatherapp.network;

import com.example.weatherapp.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("/forecasts/{location}?")
    Call<WeatherResponse> getResponse(@Path("location") String location,
                                      @Query("client_id") String client_id,
                                      @Query("client_secret") String secret_client);

}
