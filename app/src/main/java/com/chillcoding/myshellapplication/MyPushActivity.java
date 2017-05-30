package com.chillcoding.myshellapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.chillcoding.myshellapplication.preference.MyPreferencesFragment;


/**
 * Created by macha on 27/04/2017.
 */

public class MyPushActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_shell);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setFragment(new MyPreferencesFragment());
    }

    public void setFragment(Fragment frag) {
        getFragmentManager().beginTransaction()
                .replace(R.id.my_content, frag)
                .commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
