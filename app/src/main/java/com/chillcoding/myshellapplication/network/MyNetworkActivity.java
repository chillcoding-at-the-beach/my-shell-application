package com.chillcoding.myshellapplication.network;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chillcoding.myshellapplication.R;
import com.chillcoding.myshellapplication.list.MyRepoAdapter;
import com.chillcoding.myshellapplication.model.MyRepo;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by macha on 10/04/2017.
 */

public class MyNetworkActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<MyRepo> mArray;
    private MyRepoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_network);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_repo_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mArray = new ArrayList<MyRepo>();

        // initList(mArray);
        mAdapter = new MyRepoAdapter(mArray);

        mRecyclerView.setAdapter(mAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        MyGitHubService service = retrofit.create(MyGitHubService.class);

        Call<List<MyRepo>> request = service.sendHttpGet("machadacosta");

        request.enqueue(new Callback<List<MyRepo>>() {
            @Override
            public void onResponse(Call<List<MyRepo>> call, Response<List<MyRepo>> response) {
                List<MyRepo> repos = response.body();
                for (MyRepo r : repos) {
                    mArray.add(r);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<MyRepo>> call, Throwable t) {

            }
        });
    }

    private void initList(ArrayList<MyRepo> array) {
        array.add(new MyRepo("the first one", "go"));
    }
}
