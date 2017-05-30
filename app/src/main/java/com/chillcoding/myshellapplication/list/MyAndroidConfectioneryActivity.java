package com.chillcoding.myshellapplication.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chillcoding.myshellapplication.R;
import com.chillcoding.myshellapplication.model.MyAndroidConfectionery;

import java.util.ArrayList;

/**
 * Created by macha on 06/04/2017.
 */

public class MyAndroidConfectioneryActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_android_conf);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<MyAndroidConfectionery> array = new ArrayList<MyAndroidConfectionery>();

        initList(array);

        // MyAndroidConfectioneryOldAdapter adapter = new MyAndroidConfectioneryOldAdapter(this, R.layout.item_my_confectionery, array);
        MyAndroidConfectioneryAdapter adapter = new MyAndroidConfectioneryAdapter(array);

        mRecyclerView.setAdapter(adapter);
    }

    private void initList(ArrayList<MyAndroidConfectionery> array) {
        MyAndroidConfectionery kitkat = new MyAndroidConfectionery("Kikat");
        kitkat.setNameVersion("4.4");
        kitkat.setResImg(R.drawable.kitkat);
        kitkat.setApi(21);

        MyAndroidConfectionery lollipop = new MyAndroidConfectionery("Lollipop");
        lollipop.setNameVersion("5.0");
        lollipop.setResImg(R.drawable.lollipop);
        lollipop.setApi(22);

        MyAndroidConfectionery iceCreamSand = new MyAndroidConfectionery("Ice CReam Sandwich");
        iceCreamSand.setNameVersion("4.0");
        iceCreamSand.setResImg(R.drawable.icecreamsandwich);
        iceCreamSand.setApi(15);


        MyAndroidConfectionery honeyComb = new MyAndroidConfectionery("Honeycomb", "3.0", R.drawable.honeycomb, 13);

        MyAndroidConfectionery donut = new MyAndroidConfectionery("Donut", "1.6", R.drawable.donut, 4);

        MyAndroidConfectionery eclair = new MyAndroidConfectionery("Eclair", "2.1", R.drawable.eclair, 7);

        MyAndroidConfectionery froyo = new MyAndroidConfectionery("Froyo", "2.2", R.drawable.froyo, 8);

        MyAndroidConfectionery ginger = new MyAndroidConfectionery("Gingerbread", "2.3", R.drawable.gingerbread, 10);

        MyAndroidConfectionery jelly = new MyAndroidConfectionery("JellyBean", "4.1", R.drawable.jellybean, 18);

        MyAndroidConfectionery marshma = new MyAndroidConfectionery("Marshmallow", "6.0", R.drawable.marshmallow, 23);

        array.add(eclair);
        array.add(froyo);
        array.add(ginger);
        array.add(honeyComb);
        array.add(lollipop);
        array.add(kitkat);
        array.add(iceCreamSand);
        array.add(jelly);
        array.add(marshma);
        array.add(new MyAndroidConfectionery("Nougat", "7.1", R.drawable.nougat, 25));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_bis, R.anim.slide_out_bis);
    }
}
