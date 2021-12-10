package com.example.examen1_alfonslorente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TrainingSeriesFragment.Listener{
    private String[] seriesFragmentList = new String[Entrenament.entrenaments.length];
    public static final String EXTRA_MESSAGE = "com.example.examen1_alfonslorente.INT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillSeriesFragmentList();



    }

    private void fillSeriesFragmentList() {
        for(int i = 0; i < Entrenament.entrenaments.length; i++){
            seriesFragmentList[i] = Entrenament.entrenaments[i].getNom();
        }
    }


    @Override
    public void itemClicked(long id) {
        Intent intent = new Intent(MainActivity.this, TrainingInfoActivity.class);
        intent.putExtra(EXTRA_MESSAGE, id);
        startActivity(intent);

    }


}