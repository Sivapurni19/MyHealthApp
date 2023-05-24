package com.sivapurni.myhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BPTracker extends AppCompatActivity {
    Button btnCheckBP, btnViewBP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bptracker);
        btnCheckBP = findViewById(R.id.btnCheckBP);
        btnViewBP = findViewById(R.id.btnViewBP);

        btnCheckBP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                                "You clicked Check Blood Pressure",
                                Toast.LENGTH_LONG)
                        .show();

                Intent mainIntent = new Intent(getApplicationContext(), BloodPressureActivity.class);
                startActivity(mainIntent);

            }
        });

        btnViewBP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),
                        "View your Blood Pressure Result",
                        Toast.LENGTH_LONG)
                        .show();

                Intent mainIntent = new Intent(getApplicationContext(), ViewDir.class);
                startActivity(mainIntent);
            }
        });
    }
}
