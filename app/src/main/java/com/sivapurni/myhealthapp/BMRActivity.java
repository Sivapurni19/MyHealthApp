package com.sivapurni.myhealthapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BMRActivity extends AppCompatActivity {
    RadioButton rbGender;
    RadioGroup rgGender;
    EditText weight,height,age;
    Button calculate, clear;
    double berat,tinggi,bmr;
    int umur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("BMR");
        actionBar.setSubtitle("Dashboard");
        rgGender=findViewById(R.id.rgGender);
        weight=findViewById(R.id.etWeight);
        height=findViewById(R.id.etHeight);
        age=findViewById(R.id.etAge);
        calculate=findViewById(R.id.btnCalculate);
        clear=findViewById(R.id.btnClear);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                                "Calculating your BMR!",
                                Toast.LENGTH_LONG)
                        .show();

                int selectedID=rgGender.getCheckedRadioButtonId();
                rbGender=findViewById(selectedID);

                berat=Double.parseDouble(weight.getText().toString());

                tinggi=Double.parseDouble(height.getText().toString());
                umur=Integer.parseInt(age.getText().toString());
                if(rbGender.getText().toString()=="Male"){
                    bmr=(10*berat)+(6.25*tinggi)-(5*umur)+5;
                }else{
                    bmr=(10*berat)+(6.25*tinggi)-(5*umur)-161;
                }
                Intent i = new Intent(getApplicationContext(), BMRResult.class);
                // creating a bundle object
                Bundle bundle = new Bundle();
                // storing the string value in the bundle
                // which is mapped to key
                bundle.putDouble("bmr", bmr);
                bundle.putDouble("berat",berat);
                bundle.putDouble("tinggi",tinggi);
                bundle.putInt("umur",umur);
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

                rgGender.clearCheck();
                weight.setText("");
                height.setText("");
                age.setText("");
            }
        });
    }
}