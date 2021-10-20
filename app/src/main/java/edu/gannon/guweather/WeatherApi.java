package edu.gannon.guweather;

import android.content.Context;

public interface WeatherApi {
    void getWeatherForZipCode(String zipCode, Callback callback);
}
