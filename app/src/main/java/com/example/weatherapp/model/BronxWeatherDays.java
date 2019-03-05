package com.example.weatherapp.model;

public class BronxWeatherDays {

    private String dateTimeISO;
    private int avgTempF;
    private String icon;
    private String weatherPrimary;
    private int minTempF;
    private int maxTempF;


    public String getDateTimeISO() {
        return dateTimeISO;
    }

    public int getAvgTempF() {
        return avgTempF;
    }

    public String getIcon() {
        return icon;
    }

    public String getWeatherPrimary() {
        return weatherPrimary;
    }

    public int getMinTempF() {
        return minTempF;
    }

    public int getMaxTempF() {
        return maxTempF;
    }
}
