package com.sivapurni.myhealthapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class BMIActivity extends AppCompatActivity {
    //1. declare
    EditText name,weight,height;
    TextView output;
    Button calculate,reset;
    String nama;
    double berat,tinggi,bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("BMI");
        actionBar.setSubtitle("Dashboard");
        //2. bind
        name=findViewById(R.id.etName);
        weight=findViewById(R.id.etWeight);
        height=findViewById(R.id.etHeight);
        output=findViewById(R.id.tvDisp);
        calculate=findViewById(R.id.btnCalculate);
        reset=findViewById(R.id.btnClear);
        //3. register listener
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            //onClick is the implementation method
            public void onClick(View view) {
                //4. get value
                nama=name.getText().toString();
                berat=Double.parseDouble(weight.getText().toString());
                tinggi=Double.parseDouble(height.getText().toString());
                //calculation
                bmi=berat/(tinggi*tinggi);
                //5. display output
                //String.format("%.2f",bmi) to set floating point to two decimal places
                output.setText(String.format("Hi, "+nama+"\nBMI: %.2f",bmi));
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
                weight.setText("");
                height.setText("");
                output.setText("BMI=0");
            }
        });

    }
}
