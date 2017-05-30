package com.chillcoding.myshellapplication.model;

/**
 * Created by macha on 06/04/2017.
 */

public class MyAndroidConfectionery {
    private String name;
    private String nameVersion;
    private int resImg;
    private int api;

    public MyAndroidConfectionery() {
    }

    public MyAndroidConfectionery(String name, String nameVersion, int resImg, int api) {
        this.name = name;
        this.nameVersion = nameVersion;
        this.resImg = resImg;
        this.api = api;
    }

    public MyAndroidConfectionery(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameVersion() {
        return nameVersion;
    }

    public void setNameVersion(String nameVersion) {
        this.nameVersion = nameVersion;
    }

    public int getResImg() {
        return resImg;
    }

    public void setResImg(int resImg) {
        this.resImg = resImg;
    }

    public int getApi() {
        return api;
    }

    public void setApi(int api) {
        this.api = api;
    }
}
