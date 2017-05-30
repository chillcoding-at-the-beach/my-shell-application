package com.chillcoding.myshellapplication.preference;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.chillcoding.myshellapplication.R;


/**
 * Created by macha on 04/04/2017.
 */

public class MyPreferencesFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.my_preferences);
    }
}
