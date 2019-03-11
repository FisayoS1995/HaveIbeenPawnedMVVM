package com.example.haveibeenpawnedusingmvvm.Repo;

import com.example.haveibeenpawnedusingmvvm.Model.HaveIBeenPawnedRepo;
import com.example.haveibeenpawnedusingmvvm.Net.Constants;
import com.example.haveibeenpawnedusingmvvm.Net.PawnedRepo;
import com.example.haveibeenpawnedusingmvvm.Net.PawnedService;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource extends Observable implements DataSource {




    public RemoteDataSource() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PawnedService = retrofit.create(PawnedService.class);

        PawnedService PawnedService = retrofit.create(PawnedService.class);
    }


    @Override
    public void getDataForPawnedSite(String domain, Object throwable) {
        final List<HaveIBeenPawnedRepo> haveIBeenPawnedRepos = new ArrayList<>();

        PawnedService.getRepos(domain)
                .enqeue(new Callback<List<PawnedRepo>>() {

            @Override
            public void onResponse(Call<List<PawnedRepo>> call, Response<List<PawnedRepo>> response) {
                if(response.isSuccessful() && response.body() != null){
                    PawnedRepo.clear();
                    PawnedRepo.addAll(response.body());
                    setChanged();
                    notifyObservers(PawnedRepo);
                }
            }

                    @Override
                    public void onFailure(Call<List<PawnedRepo>> call, Throwable t) {
                throwable.printStackTrack();

                    }


        });
    }

    @Override
    public void setObserver(Observer observer) {
        addObserver(observer);
    }

    @Override
    public void setObserver(android.arch.lifecycle.Observer observer) {

    }

    @Override
    public void update(Observable observable, Object result) {

    }
}
