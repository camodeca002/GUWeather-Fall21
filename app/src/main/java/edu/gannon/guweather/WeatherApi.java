package edu.gannon.guweather;

public interface WeatherApi {
    void getWeatherForZipCode(String zipCode, Callback callback);
}
