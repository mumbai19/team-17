package com.example.poojan.projectjpmc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class BeginnerActivity extends AppCompatActivity {

    private CardView attendance, savings, stars, activity, viewDatabase, downloadRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);

        attendance = findViewById(R.id.attendance);
        savings = findViewById(R.id.savings);
        stars = findViewById(R.id.stars);
        activity = findViewById(R.id.activity);
        viewDatabase = findViewById(R.id.viewDatabase);
        downloadRecords = findViewById(R.id.downloadRecords);

        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BeginnerActivity.this, AttendanceActivity.class);
                startActivity(i);
            }
        });

        viewDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BeginnerActivity.this, Addstudent.class);
                startActivity(i);
            }
        });
    }
}
