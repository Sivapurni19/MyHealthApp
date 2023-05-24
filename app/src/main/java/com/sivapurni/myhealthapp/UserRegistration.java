package com.sivapurni.myhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UserRegistration extends AppCompatActivity {
    EditText name, DOB, weight, height, email, password;
    Button btnRegister, btnBack;
    RadioButton rbGender;
    RadioGroup rgGender;
    String strName, strDOB, strEmail, strPassword;
    Double berat, tinggi;
    SQLiteDatabase mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        SQLiteDatabase mDatabase = openOrCreateDatabase("Registration Data", MODE_PRIVATE, null);
        mDatabase.execSQL("CREATE TABLE IF NOT EXISTS RegisterTable(Name VARCHAR, DOB VARCHAR, Weight," +
                "Height DOUBLE, Email VARCHAR, Password VARCHAR, Gender VARCHAR)");

        name = findViewById(R.id.etName);
        DOB = findViewById(R.id.etDOB);
        weight = findViewById(R.id.etWeight);
        height = findViewById(R.id.etHeight);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        rgGender = findViewById(R.id.rgGender);
        btnRegister = findViewById(R.id.btnRegister);
        btnBack = findViewById(R.id.btnBack);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedID=rgGender.getCheckedRadioButtonId();
                rbGender=findViewById(selectedID);

                strName=name.getText().toString();
                strDOB=DOB.getText().toString();
                berat=Double.parseDouble(weight.getText().toString());
                tinggi=Double.parseDouble(height.getText().toString());
                strEmail=email.getText().toString();
                strPassword=password.getText().toString();

                    Toast.makeText(getApplicationContext(),
                                    "Registration Success!!",
                                    Toast.LENGTH_LONG)
                            .show();

                    Intent mainIntent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(mainIntent);

                String insertSQL = "INSERT INTO RegisterTable \n" +
                        "(name, DOB, weight, height, gender, email, password) \n" +
                        "VALUES \n" +
                        "(?, ?, ?, ?, ?, ?, ?);";

                mDatabase.execSQL(insertSQL, new String[]{strName, strDOB, weight.getText().toString(), height.getText().toString(),
                        rbGender.getText().toString(), strEmail, strPassword });
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Back to Login Page",
                        Toast.LENGTH_LONG)
                        .show();

                Intent mainIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(mainIntent);
            }
        });


    }
}