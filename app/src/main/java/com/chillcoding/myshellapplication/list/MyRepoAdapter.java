package com.chillcoding.myshellapplication.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.chillcoding.myshellapplication.R;
import com.chillcoding.myshellapplication.model.MyRepo;

import java.util.ArrayList;

/**
 * Created by macha on 10/04/2017.
 */

public class MyRepoAdapter extends RecyclerView.Adapter<MyRepoAdapter.ViewHolder> {


    public MyRepoAdapter(ArrayList<MyRepo> repoList) {
        this.mRepoList = repoList;
    }

    private final ArrayList<MyRepo> mRepoList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_my_repo, parent, false);
        return new MyRepoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyRepo r = mRepoList.get(position);
        holder.mTextName.setText(r.getName());
        holder.mTextLang.setText(r.getLanguage());
    }

    @Override
    public int getItemCount() {
        return mRepoList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextName;
        TextView mTextLang;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextLang = (TextView) itemView.findViewById(R.id.lang_repo);
            mTextName = (TextView) itemView.findViewById(R.id.name_repo);
        }
    }
}

