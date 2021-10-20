package edu.gannon.guweather;

public class Temperature {
    private double temperature;
    private TemperatureScale baseScale;

    public Temperature() {

    }

    public Temperature(double temp, TemperatureScale scale) {
        temperature = temp;
        baseScale = scale;
    }

    public double convert(TemperatureScale desiredScale) {
        if (baseScale == TemperatureScale.KELVIN &&
                desiredScale == TemperatureScale.CELSIUS) {
            return temperature - 273;
        } else if (baseScale == TemperatureScale.KELVIN &&
                desiredScale == TemperatureScale.FAHRENHEIT) {
            //(0K − 273.15) × 9/5 + 32
            return (temperature - 273) * 9 / 5 + 32;
        } else if (baseScale == TemperatureScale.FAHRENHEIT &&
                desiredScale == TemperatureScale.CELSIUS) {

        } else if (baseScale == TemperatureScale.CELSIUS &&
                desiredScale == TemperatureScale.FAHRENHEIT) {
        }
        return temperature;
    }

    public void setTemperature(double temp, TemperatureScale scale) {
        temperature = temp;
        baseScale = scale;
    }
}
