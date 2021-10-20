package edu.gannon.guweather;

public class Weather {
    private Temperature temperature;
    private String condition;
    private double windSpeed;

    // YAGNI -> You Ain't Gonna Need It

    public void setTemperature(Temperature temp) {
        temperature = temp;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String cond) {
        condition = cond;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double speed) {
        windSpeed = speed;
    }
}
