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

public class DiabetesTestActivity extends AppCompatActivity {
    EditText BloodSgrLvl;
    RadioGroup rgTestMeth;
    RadioButton rbSelctTstMeth;
    Button calculate;
    double BldSgrLvl, A1C, FstBldSgrLvl, GlcseTlrcTst, RndmBldSgrTst, TResult;
    String TStatus, TMethod;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetes_test);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Diabetes Test");
        actionBar.setSubtitle("Dashboard");
        rgTestMeth=findViewById(R.id.rgTestingMethod);
        BloodSgrLvl=findViewById(R.id.etEnter);
        calculate=findViewById(R.id.btnCalculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Calculating your Blood Sugar Level!",
                        Toast.LENGTH_LONG)
                        .show();

                int selectedID=rgTestMeth.getCheckedRadioButtonId();
                TResult = Double.parseDouble(BloodSgrLvl.getText().toString());

                if(selectedID == R.id.rbA1C) {
                    if(TResult >= 6.5){
                        TStatus = "Diabetes";
                        TMethod = "A1C Test";
                    }if(TResult >= 5.7 && TResult <= 6.4){
                        TStatus = "Prediabetes";
                        TMethod = "A1C Test";
                    }if(TResult < 5.7) {
                        TStatus = "Normal";
                        TMethod = "A1C Test";
                    }
                }else if (selectedID == R.id.rbFasting) {
                    if(TResult >= 126){
                        TStatus = "Diabetes";
                        TMethod = "Fasting Blood Sugar Test";
                    }if(TResult >= 100 && TResult <= 125){
                        TStatus = "Prediabetes";
                        TMethod = "Fasting Blood Sugar Test";
                    }if(TResult <= 99) {
                        TStatus = "Normal";
                        TMethod = "Fasting Blood Sugar Test";
                    }
                }else if (selectedID == R.id.rbGlucose) {
                    if(TResult >= 200){
                        TStatus = "Diabetes";
                        TMethod = "Glucose Tolerance Test";
                    }if(TResult >= 140 && TResult <= 199){
                        TStatus = "Prediabetes";
                        TMethod = "Glucose Tolerance Test";
                    }if(TResult <= 139) {
                        TStatus = "Normal";
                        TMethod = "Glucose Tolerance Test";
                    }
                }else if (selectedID == R.id.rbRandom) {
                    if (TResult >= 200) {
                        TStatus = "Diabetes";
                        TMethod = "Random Blood Sugar Test";
                    } else {
                        TStatus = "N/A";
                        TMethod = "Random Blood Sugar Test";
                    }
                }


                Intent i=new Intent(getApplicationContext(), DiabetesResultActivity.class);
                // creating a bundle object
                Bundle bundle = new Bundle();
                // storing the string value in the bundle
                // which is mapped to key
                bundle.putDouble("testResult",TResult);
                bundle.putString("testMethod",TMethod);
                bundle.putString("testStatus",TStatus);
                // passing the bundle into the intent
                i.putExtras(bundle);
                startActivity(i);

            }
        });
    }
}