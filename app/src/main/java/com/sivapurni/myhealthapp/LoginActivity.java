package com.sivapurni.myhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail,etPassword;

    Button btn_login;

    String strEmail, strPassword, dummyUsername = "sivapurni@psp.edu.my", dummyPassword = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strEmail=etEmail.getText().toString();
                strPassword=etPassword.getText().toString();

                if(strEmail.equals(dummyUsername) && strPassword.equals(dummyPassword)) {
                    Toast.makeText(getApplicationContext(),
                                    "Login Success!!",
                                    Toast.LENGTH_LONG)
                            .show();

                    Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                    // taskIntent.putExtra("Name", "Sivapurni");
                    startActivity(mainIntent);

                }else{
                    Toast.makeText(getApplicationContext(),
                            "Invalid email or password!!",
                            Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }
}