package com.chillcoding.myshellapplication.list;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chillcoding.myshellapplication.R;
import com.chillcoding.myshellapplication.model.MyAndroidConfectionery;

import java.util.List;

/**
 * Created by macha on 06/04/2017.
 */

public class MyAndroidConfectioneryOldAdapter extends ArrayAdapter<MyAndroidConfectionery> {

    private Resources mRes;
    private List<MyAndroidConfectionery> mAndroidConfectioneryList;
    private Context mCtxt;
    private int mViewRes;

    public MyAndroidConfectioneryOldAdapter(Context context, int resource, List<MyAndroidConfectionery> objects) {
        super(context, resource, objects);
        mAndroidConfectioneryList = objects;
        mCtxt = context;
        mViewRes = resource;
        mRes = context.getResources();
    }

    @Override
    public int getCount() {
        return mAndroidConfectioneryList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mCtxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(mViewRes, parent, false);
            MyAndroidConfectionery myAndroidConfectionery = mAndroidConfectioneryList.get(position);
            if (myAndroidConfectionery != null) {
                TextView textName = (TextView) view.findViewById(R.id.text_name);
                textName.setText(myAndroidConfectionery.getName());
                TextView textVersion = (TextView) view.findViewById(R.id.text_version);
                textVersion.setText(String.format(mRes.getString(R.string.version_text), myAndroidConfectionery.getNameVersion()));
                ImageView imgVersion = (ImageView) view.findViewById(R.id.img_version);
                imgVersion.setImageResource(myAndroidConfectionery.getResImg());
                TextView textApi = (TextView) view.findViewById(R.id.text_api);
                textApi.setText(String.format(mRes.getString(R.string.api_text), myAndroidConfectionery.getApi()));
            }
        }
        return view;
    }
}
