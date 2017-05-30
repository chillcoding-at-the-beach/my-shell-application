package com.chillcoding.myshellapplication;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by macha on 28/04/2017.
 */

public class MyShellApplication extends Application {

    public static final String FRAGMENT_STATE = "fragment";

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);


        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(config);
    }
}
