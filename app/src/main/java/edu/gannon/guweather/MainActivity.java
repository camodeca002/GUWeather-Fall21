package edu.gannon.guweather;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // add this comment
    TextView tvTemperature;
    TextView tvCondition;
    Button btnGetWeather;
    EditText etZipcode;
    WeatherApi weatherApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        weatherApi = new OpenWeatherMapApi(context);
        tvTemperature  = findViewById(R.id.tvTemperature);
        tvCondition  = findViewById(R.id.tvCondition);
        etZipcode = findViewById(R.id.etZipcode);
        btnGetWeather = findViewById(R.id.btnGetWeather);

        btnGetWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zipCode = etZipcode.getText().toString();
                weatherApi.getWeatherForZipCode(zipCode, new Callback() {
                    @Override
                    public void success(Weather weather) {
                        Temperature temperature = weather.getTemperature();
                        int temperatureForDisplay =
                                (int) temperature.convert(
                                        TemperatureScale.FAHRENHEIT);

                        tvTemperature.setText(temperatureForDisplay + "");
                        tvCondition.setText(weather.getCondition());
                    }

                    @Override
                    public void error(ErrorType error) {
                        String errorMessage = "";

                        if (error == ErrorType.NETWORK) {
                            errorMessage = "Please check your internet connection!";
                        } else if (error == ErrorType.JSON) {
                            errorMessage = "Sorry! Please try again in a few minutes!";
                        } else {
                            errorMessage = "Sorry! An error occurred! Try again!";
                        }


                        Toast toast = Toast.makeText(getApplicationContext(),
                                errorMessage,
                                Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
            }
        });
    }
}