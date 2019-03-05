package com.example.weatherapp.repository;

import android.arch.lifecycle.MutableLiveData;
import android.content.res.Resources;
import android.util.Log;

import com.example.weatherapp.R;
import com.example.weatherapp.model.WeatherResponse;
import com.example.weatherapp.network.RetrofitSingleton;
import com.example.weatherapp.network.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {

    private static WeatherRepository singleInstance;
    private MutableLiveData<WeatherResponse> weatherResponseMutableLiveData;

    public static final String CLIENT_ID = "oPwjywQv3McU7J2WIABxR";
    public static final String SECRET_CLIENT = "gHqi9ucaWh3oqkAmMxUgjmUpJLDUpeF4KhTFvKYS";
    private WeatherRepository() {
        weatherResponseMutableLiveData = new MutableLiveData<>();
    }

    public static WeatherRepository getSingleInstance(){
        if(singleInstance != null){
            return singleInstance;
        }else{
            singleInstance = new WeatherRepository();
            return singleInstance;
        }
    }

    public void makeRetrofitCall(String location){
        RetrofitSingleton.getSingleInstance()
                .create(WeatherService.class)
                .getResponse(location,CLIENT_ID,SECRET_CLIENT)
                .enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                        Log.v("sasuke",response.toString());
                        Log.v("sasuke",response.body().getResponse()[0].getPeriods()[0].getIcon());
                        weatherResponseMutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t) {
                        Log.v("sasuke", t.toString());
                    }
                });
    }

    public MutableLiveData<WeatherResponse> getWeatherResponseMutableLiveData() {
        return weatherResponseMutableLiveData;
    }
}
