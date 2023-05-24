package com.sivapurni.myhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
TextView textView5;
    EditText etEmail,etPassword;

    Button btn_login;

    String strEmail, strPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SQLiteDatabase mDatabase = openOrCreateDatabase("Registration Data", MODE_PRIVATE, null);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        textView5 = findViewById(R.id.textView5);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strEmail = etEmail.getText().toString();
                strPassword = etPassword.getText().toString();

                Cursor cursorUser = mDatabase.rawQuery("SELECT * FROM RegisterTable WHERE email=? " +
                        "and password=?", new String[]{strEmail, strPassword});
                if (cursorUser != null && cursorUser.moveToFirst()) {
                    cursorUser.moveToFirst();

                    String email = cursorUser.getString(4);
                    String password = cursorUser.getString(5);

                    if(strEmail.equals(email) && strPassword.equals(password)) {
                        Toast.makeText(getApplicationContext(),
                                        "Login Success!!",
                                        Toast.LENGTH_LONG)
                                .show();

                        Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                        // taskIntent.putExtra("Name", "Sivapurni");
                        startActivity(mainIntent);

                    } else {
                        Toast.makeText(getApplicationContext(),
                                        "Invalid email or password!!",
                                        Toast.LENGTH_LONG)
                                .show();
                    }
                }
            }

        });




        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), UserRegistration.class);
                startActivity(mainIntent);
            }
        });
    }
}
