package com.example.weatherapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weatherapp.R;
import com.example.weatherapp.model.BronxWeatherDays;
import com.example.weatherapp.view.WeatherViewHolder;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> {

    private BronxWeatherDays[] bronxWeatherDays;

    public WeatherAdapter(BronxWeatherDays[] bronxWeatherDays) {
        this.bronxWeatherDays = bronxWeatherDays;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weather_item_view,viewGroup,false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {
        weatherViewHolder.onBind(bronxWeatherDays[i]);
    }

    @Override
    public int getItemCount() {
        return bronxWeatherDays.length;
    }
}
