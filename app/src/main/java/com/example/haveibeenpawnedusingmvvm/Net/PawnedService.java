package com.example.haveibeenpawnedusingmvvm.Net;

import android.telecom.Call;

import java.util.List;

import static com.example.haveibeenpawnedusingmvvm.Net.Constants.END_POINT;

public interface PawnedService {

    @GET(END_POINT)
    static Call<List<PawnedRepo>> getRepos(@Query("domain") String domain);

}
