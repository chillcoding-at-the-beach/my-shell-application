package com.chillcoding.myshellapplication.fragment;


import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chillcoding.myshellapplication.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyHomeFragment extends Fragment {


    private static final String TAG = "MY HOME FRAG";
    private ImageView mImage;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_home, container, false);
        mImage = (ImageView) view.findViewById(R.id.home_img);
        return view;
    }

    public void setImage(Bitmap bitmap) {
        if (mImage != null)
            mImage.setImageBitmap(bitmap);
    }
}
