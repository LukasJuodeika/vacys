package com.example.smartroom.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.smartroom.entities.TemperatureData;

@Database(entities = {TemperatureData.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TemperatureDao temperatureDao();
}
