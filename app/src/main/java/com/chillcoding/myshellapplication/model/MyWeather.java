package com.chillcoding.myshellapplication.model;

/**
 * Created by macha on 10/04/2017.
 */

public class MyWeather {

    String base;
    String main;
    MyWeatherDetail weather;

    public String getBase() {
        return base;
    }

    public String getMain() {
        return main;
    }

    public MyWeatherDetail getWeather() {
        return weather;
    }
}
