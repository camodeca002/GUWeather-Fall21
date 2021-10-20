package edu.gannon.guweather;

public interface Callback {
    void success(Weather weather);
    void error(ErrorType error);
}
