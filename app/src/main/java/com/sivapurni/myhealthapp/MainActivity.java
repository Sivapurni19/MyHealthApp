package com.sivapurni.myhealthapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    CardView menuBmi, menuBloodPressure, menuDiabetic, menuBmr;
    FloatingActionButton floatingActionButton1;

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
        floatingActionButton1 = findViewById(R.id.floatingActionButton1);


        menuBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                                "You clicked BMI Calculator",
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
                                "You clicked BMR Calculator",
                                Toast.LENGTH_LONG)
                        .show();

                Intent bmrIntent = new Intent(getApplicationContext(), BMRActivity.class);
                startActivity(bmrIntent);
            }
        });

        menuBloodPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                                "You clicked Blood Pressure Test",
                                Toast.LENGTH_LONG)
                        .show();

                Intent BPIntent = new Intent(getApplicationContext(), BPTracker.class);
                startActivity(BPIntent);
            }
        });

        menuDiabetic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                                "You clicked Diabetes Test",
                                Toast.LENGTH_LONG)
                        .show();

                Intent diabeticIntent = new Intent(getApplicationContext(), DiabetesTestActivity.class);
                startActivity(diabeticIntent);
            }
        });

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                                "User Credential",
                                Toast.LENGTH_LONG)
                        .show();

                Intent mainIntent = new Intent(getApplicationContext(), ViewUserCredentials.class);
                startActivity(mainIntent);
            }
        });
    }
}
