package com.chillcoding.myshellapplication.network;

import com.chillcoding.myshellapplication.model.MyWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by macha on 10/04/2017.
 */

public interface MyWeatherService {

    @GET("weather/")
    Call<MyWeather> getWeather(@Query("q") String q, @Query("appid") String api);
}
