package com.example.haveibeenpawnedusingmvvm.Repo;

import java.util.Observable;
import java.util.Observer;

public interface DataSource {
    void getDataForPawnedSite(String domain, Object throwable);
    void setObserver(Observer observer);

    void setObserver(android.arch.lifecycle.Observer observer);

    void update(Observable observable, Object result);
}

