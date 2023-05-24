package com.sivapurni.myhealthapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BMRResult extends AppCompatActivity {
    Button back;
    TextView disp;
    double weight,height,bmr;
    int umur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmrresult);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("BLOOD PRESSURE");
        actionBar.setSubtitle("Dashboard");
        back=findViewById(R.id.btnBack);
        disp=findViewById(R.id.tvDisp);
        // getting the bundle from the intent
        Bundle bundle = getIntent().getExtras();
        // setting the text in the textview
        weight=bundle.getDouble("berat");
        height=bundle.getDouble("tinggi");
        bmr=bundle.getDouble("bmr");
        umur=bundle.getInt("umur");
        disp.setText("Weight: "+weight+"kg\nHeight: "+height+"cm\nAge: "+umur+"yrs\nBMR: "+bmr+" calories/day");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),
                                        "Back to BMR Page",
                                        Toast.LENGTH_LONG)
                                .show();

                Intent intent=new Intent(getApplicationContext(), BMRActivity.class);
                startActivity(intent);
            }
        });
    }
}