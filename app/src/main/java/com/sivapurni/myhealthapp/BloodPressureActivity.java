package com.sivapurni.myhealthapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BloodPressureActivity extends AppCompatActivity {
    EditText date,time,systolic,diastolic;
    Button calculate, clear;
    String tarikh,masa,BPStatus;
    int sistolik, diastolik;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_pressure);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("BLOOD PRESSURE");
        actionBar.setSubtitle("Dashboard");
        date=findViewById(R.id.etDate);
        time=findViewById(R.id.etTime);
        systolic=findViewById(R.id.etSystolic);
        diastolic=findViewById(R.id.etDiastolic);
        calculate=findViewById(R.id.btnCalculate);
        clear=findViewById(R.id.btnClear);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                                "Calculating your Blood Pressure!",
                                Toast.LENGTH_LONG)
                        .show();

                tarikh=date.getText().toString();
                masa=time.getText().toString();
                sistolik=Integer.parseInt(systolic.getText().toString());
                diastolik=Integer.parseInt(diastolic.getText().toString());

                if(sistolik<120 && diastolik<=80){
                    BPStatus = String.format("Normal");
                }if (sistolik>=120 && diastolik<80){
                    BPStatus = String.format("Elevated");
                }if (sistolik>=130 || diastolik>=80){
                    BPStatus = String.format("High Blood Pressure"+"\nPressure - Stage 1");
                }if (sistolik>=140 || diastolik>=90){
                    BPStatus = String.format("High Blood Pressure"+"\nPressure - Stage 2");
                }if ((sistolik>180 || diastolik>120) && (sistolik>180 && diastolik>120)){
                    BPStatus = String.format("Hypertensive crisis"+"\nCONSULT YOUR DOCTOR IMMEDIATELY");
                }

                Intent i = new Intent(getApplicationContext(), BloodPressureResult.class);
                // creating a bundle object
                Bundle bundle = new Bundle();
                // storing the string value in the bundle
                // which is mapped to key
                bundle.putString("tarikh",tarikh);
                bundle.putString("masa",masa);
                bundle.putInt("sistolik",sistolik);
                bundle.putInt("diastolik",diastolik);
                bundle.putString("BPStatus",BPStatus);
                // passing the bundle into the intent
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                                "Clearing all input values!",
                                Toast.LENGTH_LONG)
                        .show();

                date.setText("");
                time.setText("");
                systolic.setText("");
                diastolic.setText("");
            }
        });
    }
}