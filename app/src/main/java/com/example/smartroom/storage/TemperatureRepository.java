package com.example.smartroom.storage;

import android.content.Context;

import androidx.room.Room;

import com.example.smartroom.entities.TemperatureData;

import java.util.List;

public class TemperatureRepository {

    private final Context context;

    private final AppDatabase appDatabase;

    public TemperatureRepository(Context context) {
        this.context = context;
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "bybis-database")
                .allowMainThreadQueries()
                .build();

    }

    public void addTemperature(TemperatureData temperatureData) {
        appDatabase.temperatureDao().add(temperatureData);
    }

    public TemperatureData getTemperature() {
        List<TemperatureData> temperatures = appDatabase.temperatureDao().getAll();
        if(temperatures.isEmpty())
            temperatures.add(new TemperatureData(15.0F, 100, "2020-03-10", "16:49"));

        return temperatures.get(0);
    }


}
