package com.sivapurni.myhealthapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BloodPressureResult extends AppCompatActivity {
    Button back, saverecord;
    TextView disp;
    String date, time, BPStatus;
    int systolic, diastolic;

    SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_pressure_result);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Blood Pressure");
        actionBar.setSubtitle("Dashboard");
        back=findViewById(R.id.btnBack);
        saverecord=findViewById(R.id.btnSaveRecord);
        disp=findViewById(R.id.tvDisp);
        // getting the bundle from the intent
        Bundle bundle = getIntent().getExtras();
        // setting the text in the textview
        date=bundle.getString("tarikh");
        time=bundle.getString("masa");
        systolic=bundle.getInt("sistolik");
        diastolic=bundle.getInt("diastolik");
        BPStatus= bundle.getString("BPStatus");
        disp.setText("Date: "+date+"\n\nTime: "+time+"\n\nSystolic Value: "+systolic+
                " mm Hg\n\nDiastolic Value: "+diastolic+" mm Hg"+
                        "\nBP Status: Result: "+BPStatus);

        SQLiteDatabase mDatabase = openOrCreateDatabase("healthDB", MODE_PRIVATE, null);
        mDatabase.execSQL("CREATE TABLE IF NOT EXISTS BPRecord(id INTEGER PRIMARY KEY AUTOINCREMENT,Date VARCHAR, Time VARCHAR," +
                " Systolic INT, Diastolic INT, BPStatus VARCHAR)");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                                "Back to Blood Pressure Page",
                                Toast.LENGTH_LONG)
                        .show();

                Intent intent=new Intent(getApplicationContext(), BloodPressureActivity.class);
                startActivity(intent);
            }
        });

        saverecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String insertSQL = "INSERT INTO BPRecord \n" +
                        "(date, time, systolic, diastolic, bpstatus) \n" +
                        "VALUES \n" +
                        "(?, ?, ?, ?, ?);";

                mDatabase.execSQL(insertSQL, new String[]{date, time, String.valueOf(systolic),
                        String.valueOf(diastolic), BPStatus});
                Toast.makeText(getApplicationContext(),
                        "Data successfully saved!!", Toast.LENGTH_LONG)
                        .show();
                //etName.setText("");
                //etPassword.setText("");


            }
        });

    }
}

