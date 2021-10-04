package edu.gannon.guweather;

public interface Callback {
    void success(double temperature);
    void error(String errorMessage);
}
