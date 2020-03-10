package com.example.smartroom.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TemperatureData {

    @PrimaryKey(autoGenerate = true)
    public int id;

    private float temperatureCelcius;

    private float humidity;

    private String date;

    private String time;

    public TemperatureData(float temperatureCelcius, float humidity, String date, String time) {
        this.temperatureCelcius = temperatureCelcius;
        this.humidity = humidity;
        this.date = date;
        this.time = time;
    }

    public float getTemperatureCelcius() {
        return temperatureCelcius;
    }

    public float getHumidity() {
        return humidity;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
