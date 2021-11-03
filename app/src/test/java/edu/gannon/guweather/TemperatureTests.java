package edu.gannon.guweather;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TemperatureTests {
    @Test
    public void shouldConvertKelvinToCelsius(){
        Temperature tempInKelvin=
                new Temperature (273, TemperatureScale.KELVIN);
        double tempInCelsius = tempInKelvin. convert (TemperatureScale.CELSIUS);
        assertEquals(0.0, tempInCelsius, 0.001);
    }
    @Test
    public void shouldConvertCelsiusToKelvin() {
        Temperature temperature = new Temperature (0, TemperatureScale.CELSIUS);
        double temperatureInKelvin = temperature.convert (TemperatureScale.KELVIN);
        assertEquals(273, temperatureInKelvin, 0.001);
    }


}
