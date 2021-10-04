package edu.gannon.guweather;

public interface Callback {
    void success(CurrentWeather currentWeather);
    void error(String errorMessage);
}
