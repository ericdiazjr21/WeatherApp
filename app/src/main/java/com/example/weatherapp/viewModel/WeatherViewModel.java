package com.example.weatherapp.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.weatherapp.model.WeatherResponse;
import com.example.weatherapp.repository.WeatherRepository;

public class WeatherViewModel extends ViewModel {

    private WeatherRepository weatherRepository;
    private LiveData<WeatherResponse> weatherResponseLiveData;

    public WeatherViewModel() {
        this.weatherRepository = WeatherRepository.getSingleInstance();
        this.weatherResponseLiveData = weatherRepository.getWeatherResponseMutableLiveData();
    }

    public void requestNewLocationWeather(String location){
        weatherRepository.makeRetrofitCall(location);
    }

    public LiveData<WeatherResponse> getWeatherResponseLiveData() {
        return weatherResponseLiveData;
    }
}
