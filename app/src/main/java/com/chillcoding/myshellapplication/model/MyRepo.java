package com.chillcoding.myshellapplication.model;

/**
 * Created by macha on 10/04/2017.
 */

public class MyRepo {
    final String name;
    final String language;
    MyGitHubOwner owner;

    public MyRepo(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }
}
