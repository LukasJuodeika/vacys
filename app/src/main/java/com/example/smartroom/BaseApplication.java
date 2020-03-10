package com.example.smartroom;

import android.app.Application;

import com.example.smartroom.storage.TemperatureRepository;

public class BaseApplication extends Application {

    private TemperatureRepository temperatureRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        temperatureRepository = new TemperatureRepository(getApplicationContext());
    }

    public TemperatureRepository getTemperatureRepository() {
        return temperatureRepository;
    }
}
