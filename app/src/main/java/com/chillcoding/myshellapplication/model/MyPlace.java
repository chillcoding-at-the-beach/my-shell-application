package com.chillcoding.myshellapplication.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by macha on 05/04/2017.
 */

public class MyPlace extends RealmObject {

    @PrimaryKey
    private long id;
    private String name;
    private double lat;
    private double longi;

    public MyPlace() {
    }

    public MyPlace(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongi() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi = longi;
    }
}
