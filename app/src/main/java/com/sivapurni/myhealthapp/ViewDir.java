package com.sivapurni.myhealthapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;
public class ViewDir extends AppCompatActivity {
    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<dirModal> dirModalArrayList;
    private DBHelper dh;
    private DirRVAdapter dirRVAdapter;
    private RecyclerView dirRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dir);
        // initializing our all variables.
        dirModalArrayList = new ArrayList<>();
        dh = new DBHelper(ViewDir.this);
        // getting our course array
        // list from db handler class.
        dirModalArrayList = dh.readDir();
        int recordCount = dh.count();
        TextView textViewRecordCount = findViewById(R.id.tvRecord);
        textViewRecordCount.setText(recordCount +" records found.");
        // on below line passing our array list to our adapter class.
        dirRVAdapter = new DirRVAdapter(dirModalArrayList, ViewDir.this);
        dirRV = findViewById(R.id.rvDir);
        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(ViewDir.this, RecyclerView.VERTICAL, false);
        dirRV.setLayoutManager(linearLayoutManager);
        // setting our adapter to recycler view.
        dirRV.setAdapter(dirRVAdapter);
    }
}