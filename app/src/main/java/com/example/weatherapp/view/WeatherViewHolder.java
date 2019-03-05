package com.example.weatherapp.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.model.BronxWeatherDays;
import com.squareup.picasso.Picasso;

public class WeatherViewHolder extends RecyclerView.ViewHolder {

    private ImageView iconImageView;
    private TextView dateTextView;
    private TextView minimumWeatherTextView;
    private TextView maximumWeatherTextView;
    private TextView weatherDescriptionTextView;

    public WeatherViewHolder(@NonNull View itemView) {
        super(itemView);
        findViews(itemView);

    }

    private void findViews(@NonNull View itemView) {
        iconImageView = itemView.findViewById(R.id.icon_image_view);
        dateTextView = itemView.findViewById(R.id.date_text_view);
        minimumWeatherTextView = itemView.findViewById(R.id.minimum_weather_text_view);
        weatherDescriptionTextView = itemView.findViewById(R.id.weather_description_text_view);
        maximumWeatherTextView = itemView.findViewById(R.id.maximum_weather_text_view);
    }

    public void onBind(final BronxWeatherDays bronxWeatherDay) {
        setViews(bronxWeatherDay);
    }

    private void setViews(@NonNull BronxWeatherDays bronxWeatherDay) {
        setIcon(bronxWeatherDay);
        dateTextView.setText(bronxWeatherDay.getDateTimeISO().substring(0,10));
        minimumWeatherTextView.setText("Low: " + String.valueOf(bronxWeatherDay.getMinTempF()));
        maximumWeatherTextView.setText(new StringBuilder().append("High: ").append(String.valueOf(bronxWeatherDay.getMaxTempF())).toString());
        weatherDescriptionTextView.setText(bronxWeatherDay.getWeatherPrimary());
    }

    private void setIcon(@NonNull BronxWeatherDays bronxWeatherDay) {
        int drawable = itemView.getResources().getIdentifier(bronxWeatherDay.getIcon().substring(0,bronxWeatherDay.getIcon().length() - 4),
                        "drawable",
                        itemView.getContext().getPackageName());
        Picasso.get().load(drawable).into(iconImageView);
    }
}
