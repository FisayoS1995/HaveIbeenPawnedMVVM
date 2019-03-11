package com.example.haveibeenpawnedusingmvvm.Home;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.haveibeenpawnedusingmvvm.Model.HaveIBeenPawnedRepo;
import com.example.haveibeenpawnedusingmvvm.Net.PawnedRepo;
import com.example.haveibeenpawnedusingmvvm.Repo.LocalDataSource;
import com.example.haveibeenpawnedusingmvvm.Repo.RemoteDataSource;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.sql.DataSource;

public class HomeViewModel implements Observer {

    private final DataSource haveIBeenPawnedRepo;
    private final MutableLiveData<List<HaveIBeenPawnedRepo>> liveData = new MutableLiveData<>();

    public HomeViewModel() {
        haveIBeenPawnedRepo = (DataSource) new HaveIBeenPawnedRepo(new LocalDataSource(), new RemoteDataSource());
    }

    @Override
    public void update(Observable observable, Object result) {
        List<PawnedRepo> PawnedRepos = (List<PawnedRepo>) result;
        liveData.setValue(PawnedRepo);
    }

    public LiveData<List<HaveIBeenPawnedRepo>> getResponseLiveData(){
        return liveData;
    }

    public void getDomain(String domain){
        haveIBeenPawnedRepo.setObserver(this);
        haveIBeenPawnedRepo.getDataFromSite(domain);
    }
}

