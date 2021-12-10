package com.example.examen1_alfonslorente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TrainingInfoActivity    extends AppCompatActivity {

    TrainingInfoFragment fragment = new TrainingInfoFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_info);
        Intent intent = getIntent();
        long id = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);

        fragment.setProgram(id);

    }
}