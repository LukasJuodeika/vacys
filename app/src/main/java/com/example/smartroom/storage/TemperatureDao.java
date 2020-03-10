package com.example.smartroom.storage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.smartroom.entities.TemperatureData;

import java.util.List;

@Dao
public interface TemperatureDao {

    @Query("SELECT * FROM temperaturedata")
    List<TemperatureData> getAll();

    @Insert
    void add(TemperatureData temperatureData);

}
