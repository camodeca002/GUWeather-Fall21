package edu.gannon.guweather;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTemperature  = findViewById(R.id.tvTemperature);
        etZipcode = findViewById(R.id.etZipcode);
        btnGetWeather = findViewById(R.id.btnGetWeather);
        btnGetWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zipCode = etZipcode.getText().toString();
                getWeatherForZipCode(zipCode);
            }
        });

        queue = Volley.newRequestQueue(this);
    }

    private void getWeatherForZipCode(String zipCode) {
        String weather_api_url = getString(R.string.weather_api_url);
        String weather_api_key = getString(R.string.weather_api_key);
        String url = String.format(weather_api_url, zipCode, weather_api_key);
        StringRequest stringRequest =
                new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("example.com response", response);
                                try {
                                    JSONObject weather = new JSONObject(response);
                                    JSONObject main = weather.getJSONObject("main");
                                    Double temperature = main.getDouble("temp");
                                    Log.d("temperature", temperature.toString());
                                    tvTemperature.setText(temperature + "");
                                } catch (JSONException e) {
                                    Log.d("weatherrequestexception", e.toString());
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        queue.add(stringRequest);
    }
}