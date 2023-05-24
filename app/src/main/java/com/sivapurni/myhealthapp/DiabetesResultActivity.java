package com.sivapurni.myhealthapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DiabetesResultActivity extends AppCompatActivity {
    TextView TestMet, TestRslt, TestSts;
    String TStatus, TMethod;
    Double TResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetes_result);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Diabetes Test");
        actionBar.setSubtitle("Dashboard");
        TestMet=findViewById(R.id.tvTestMet);
        TestRslt=findViewById(R.id.tvTestRslt);
        TestSts=findViewById(R.id.tvTestSts);
        // getting the bundle from the intent
        Bundle bundle = getIntent().getExtras();
        // setting the text in the textview
        TResult=bundle.getDouble("testResult");
        TMethod=String.valueOf(bundle.get("testMethod"));
        TStatus=String.valueOf(bundle.get("testStatus"));

        TestMet.setText("" + TMethod);
        TestRslt.setText("" + TResult);
        TestSts.setText("" + TStatus);


    }
}