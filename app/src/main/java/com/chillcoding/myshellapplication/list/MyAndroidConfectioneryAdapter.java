package com.chillcoding.myshellapplication.list;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chillcoding.myshellapplication.R;
import com.chillcoding.myshellapplication.model.MyAndroidConfectionery;

import java.util.ArrayList;

/**
 * Created by macha on 06/04/2017.
 */

public class MyAndroidConfectioneryAdapter extends RecyclerView.Adapter<MyAndroidConfectioneryAdapter.ViewHolder> {


    private final ArrayList<MyAndroidConfectionery> mAndroidConfectioneryList;

    public MyAndroidConfectioneryAdapter(ArrayList<MyAndroidConfectionery> arrayList) {
        mAndroidConfectioneryList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_my_confectionery, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAndroidConfectioneryAdapter.ViewHolder holder, int position) {
        MyAndroidConfectionery myAndroidConfectionery = mAndroidConfectioneryList.get(position);

        holder.mTextName.setText(myAndroidConfectionery.getName());
        holder.mTextVersion.setText(myAndroidConfectionery.getNameVersion());
        Resources mRes = holder.mTextName.getContext().getResources();
        holder.mTextApi.setText(String.format(mRes.getString(R.string.api_text), myAndroidConfectionery.getApi()));
        holder.mImgVersion.setImageResource(myAndroidConfectionery.getResImg());

    }

    @Override
    public int getItemCount() {
        return mAndroidConfectioneryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextName;
        public TextView mTextVersion;
        public TextView mTextApi;
        public ImageView mImgVersion;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextName = (TextView) itemView.findViewById(R.id.text_name);
            mTextVersion = (TextView) itemView.findViewById(R.id.text_version);
            mTextApi = (TextView) itemView.findViewById(R.id.text_api);
            mImgVersion = (ImageView) itemView.findViewById(R.id.img_version);
        }
    }
}
