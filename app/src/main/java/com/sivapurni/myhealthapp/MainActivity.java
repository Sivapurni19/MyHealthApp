package com.sivapurni.myhealthapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CardView menuBmi, menuBloodPressure, menuDiabetic, menuBmr;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("My Health App");
        actionBar.setSubtitle("Dashboard");

        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        menuBmi = findViewById(R.id.menuBmi);
        menuBloodPressure = findViewById(R.id.menuBloodPressure);
        menuDiabetic = findViewById(R.id.menuDiabetic);
        menuBmr = findViewById(R.id.menuBmr);


        menuBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                                "You click BMI Calculator",
                                Toast.LENGTH_LONG)
                        .show();

                Intent bmiIntent = new Intent(getApplicationContext(), BMIActivity.class);
                startActivity(bmiIntent);
            }
        });




        menuBmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                                "You click BMR Calculator",
                                Toast.LENGTH_LONG)
                        .show();

                Intent bmrIntent = new Intent(getApplicationContext(), BMRActivity.class);
                startActivity(bmrIntent);
            }
        });
    }
}