package com.example.smartroom;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartroom.entities.TemperatureData;
import com.example.smartroom.storage.TemperatureRepository;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 1;

    private TextView textViewTemperature;
    private TextView textViewHumidity;
    private TextView textViewDate;
    private TextView textViewTime;

    private TemperatureRepository temperatureRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temperatureRepository = ((BaseApplication) getApplication()).getTemperatureRepository();
//        temperatureRepository.addTemperature(
//                new TemperatureData(69, 50, "bybis", "12:00")
//        );
        textViewTemperature = findViewById(R.id.temperature);
        textViewDate = findViewById(R.id.date);
        textViewHumidity = findViewById(R.id.humidity);
        textViewTime= findViewById(R.id.time);
        setupTemperatureView();
        connectBluetooth();
    }



    public void setupTemperatureView(){
        TemperatureData currentTemperature = temperatureRepository.getTemperature();
        textViewTemperature.setText(currentTemperature.getTemperatureCelcius() + "C");
        textViewTime.setText(currentTemperature.getTime());
        textViewDate.setText(currentTemperature.getDate());
        textViewHumidity.setText(currentTemperature.getHumidity() + "%");
    }



    public void connectBluetooth() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }

}
