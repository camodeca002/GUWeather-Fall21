package edu.gannon.guweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView tvTemperature;
    Button btnGetWeather;
    EditText etZipcode;
    RequestQueue queue;
    WeatherApi weatherApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        weatherApi = new OpenWeatherMapApi(context);
        tvTemperature  = findViewById(R.id.tvTemperature);
        etZipcode = findViewById(R.id.etZipcode);
        btnGetWeather = findViewById(R.id.btnGetWeather);
        btnGetWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zipCode = etZipcode.getText().toString();
                weatherApi.getWeatherForZipCode(zipCode, new Callback() {
                    @Override
                    public void execute(double response) {
                        int temperature = (int) (response - 273);
                        tvTemperature.setText(temperature + "");
                    }
                });
            }
        });
    }
}