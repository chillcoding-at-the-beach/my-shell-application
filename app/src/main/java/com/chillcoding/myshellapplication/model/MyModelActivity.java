package com.chillcoding.myshellapplication.model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import com.chillcoding.myshellapplication.R;

import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by macha on 05/04/2017.
 */

public class MyModelActivity extends AppCompatActivity {

    private static final String TAG = "MY MODEL ACTIVITY";
    private Realm mRealm;
    private RealmAsyncTask mTransaction;
    private RealmResults<MyPlace> mResults;
    private RealmChangeListener mCallBack = new RealmChangeListener() {
        @Override
        public void onChange(Object element) {
            if (!mResults.isEmpty()) {
                for (MyPlace place : mResults)
                    Log.v(TAG, "Voici un 'MyPlace' : " + place.getName());
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_model);

        mRealm = Realm.getDefaultInstance();

        findPlaces();
    }

    private void findPlaces() {
        mResults = mRealm.where(MyPlace.class).findAllAsync();
        mResults.addChangeListener(mCallBack);
    }

    public void writePlaceinDB(final MyPlace p) {
        mTransaction = mRealm.executeTransactionAsync(new Realm.Transaction() {

            @Override
            public void execute(Realm realm) {
                Log.v(TAG, "on écrit un 'MyPlace' dans la BDD");
                MyPlace place = realm.createObject(MyPlace.class, System.currentTimeMillis());
                place.setName(p.getName());
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mTransaction.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mResults.removeChangeListener(mCallBack);
        mRealm.close();
    }
}
