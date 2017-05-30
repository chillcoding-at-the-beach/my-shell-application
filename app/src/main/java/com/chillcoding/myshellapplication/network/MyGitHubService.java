package com.chillcoding.myshellapplication.network;


import com.chillcoding.myshellapplication.model.MyRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by macha on 10/04/2017.
 */

public interface MyGitHubService {

    @GET("users/{user}/repos")
    Call<List<MyRepo>> sendHttpGet(@Path("user") String user);
}
