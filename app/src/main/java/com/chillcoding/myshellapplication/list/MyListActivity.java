package com.chillcoding.myshellapplication.list;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.chillcoding.myshellapplication.R;


/**
 * Created by macha on 06/04/2017.
 */

public class MyListActivity extends ListActivity {

    String[] mArray = {"Cupcake", "Donut", "Eclair"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mArray);


        setListAdapter(adapter);
    }
}
