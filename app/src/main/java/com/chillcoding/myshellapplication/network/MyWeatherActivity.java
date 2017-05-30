package com.chillcoding.myshellapplication.network;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


import com.chillcoding.myshellapplication.R;
import com.chillcoding.myshellapplication.model.MyWeather;
import com.chillcoding.myshellapplication.model.MyWeatherDetail;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by macha on 10/04/2017.
 */

public class MyWeatherActivity extends AppCompatActivity {

    private static final String TAG = "WEATHER ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_network);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://samples.openweathermap.org/data/2.5/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        MyWeatherService service = retrofit.create(MyWeatherService.class);

        Call<MyWeather> request = service.getWeather("London,uk", "b1b15e88fa797225412429c1c50c122a1");

        Log.i(TAG, "la requete : " + request.request());

        request.enqueue(new Callback<MyWeather>() {
            @Override
            public void onResponse(Call<MyWeather> call, Response<MyWeather> response) {
                Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_LONG).show();
                MyWeather weather = response.body();
                MyWeatherDetail wd = weather.getWeather();
                Log.v(TAG, "le temps est" + weather.getBase() + " temp : " + wd.getTemp());
            }

            @Override
            public void onFailure(Call<MyWeather> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ko", Toast.LENGTH_LONG).show();
                t.toString();
            }
        });
    }
}
