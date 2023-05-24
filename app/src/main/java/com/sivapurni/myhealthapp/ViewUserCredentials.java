package com.sivapurni.myhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ViewUserCredentials extends AppCompatActivity {
    Button btnBack;
    TextView textView22, textView23, textView24, textView25, textView26, textView27, textView28;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user_credentials);

        textView22 = findViewById(R.id.textView22);
        textView23 = findViewById(R.id.textView23);
        textView24 = findViewById(R.id.textView24);
        textView25 = findViewById(R.id.textView25);
        textView26 = findViewById(R.id.textView26);
        textView27 = findViewById(R.id.textView27);
        textView28 = findViewById(R.id.textView28);



        String strEmail = "sivapurni@psp.edu.my";
        SQLiteDatabase mDatabase = openOrCreateDatabase("Registration Data", MODE_PRIVATE, null);
        Cursor cursorUser = mDatabase.rawQuery("SELECT * FROM RegisterTable WHERE email=? " , new String[]{strEmail});
        //if (cursorUser != null && cursorUser.moveToFirst()) {
            cursorUser.moveToFirst();
            String name = cursorUser.getString(0);
            String DOB = cursorUser.getString(1);
            String weight = cursorUser.getString(2);
            String height = cursorUser.getString(3);
            String email = cursorUser.getString(4);
            String password = cursorUser.getString(5);
            String gender = cursorUser.getString(6);



            textView22.setText(""+ name);
            textView23.setText(""+DOB);
            textView24.setText(""+weight);
            textView25.setText(""+height);
            textView26.setText(""+gender);
            textView27.setText(""+email);
            textView28.setText(""+password);




        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                                "Back to Main Menu",
                                Toast.LENGTH_LONG)
                        .show();

                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainIntent);
            }
        });


    }
}