package com.example.poojan.projectjpmc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class BeginnerActivity extends AppCompatActivity {

    private CardView attendance, savings, stars, activity, viewDatabase, downloadRecords;
    Button attedit, attview, attedit4, attview4;

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
        attedit = findViewById(R.id.att_edit);
        attedit4 = findViewById(R.id.att_edit4);
        attview = findViewById(R.id.att_view);
        attview4 = findViewById(R.id.att_view4);

        attedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BeginnerActivity.this, AttendanceActivity.class);
                startActivity(i);
            }
        });
        attview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BeginnerActivity.this, ViewAttendanceActivity.class);
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

        attedit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BeginnerActivity.this, ActivityPage.class);
                startActivity(i);
            }
        });

        attview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BeginnerActivity.this, ViewActivitiesActivity.class);
                startActivity(i);
            }
        });
    }
}
