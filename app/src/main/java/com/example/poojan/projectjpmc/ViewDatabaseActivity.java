package com.example.poojan.projectjpmc;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.poojan.projectjpmc.Models.Student;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;

//import de.j4velin.mapsmeasure.R;
//import maes.tech.intentanim.CustomIntent;

public class ViewDatabaseActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    FirebaseRecyclerAdapter<Student, DatabaseAdapter> adapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_database);

        toolbar = findViewById(R.id.attend_toolbar);
        toolbar.setTitle("Student database View");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        layoutManager = new LinearLayoutManager(this);
        //layoutManager.setReverseLayout(true);
        //layoutManager.setStackFromEnd(true);
        recyclerView = findViewById(R.id.rv_studentlist);
        loaddata();
    }

    public void loaddata(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        DatabaseReference dbref = FirebaseDatabase.getInstance().getReference().child("Beginners").child("Students");
        dbref.keepSynced(true);

        adapter = new FirebaseRecyclerAdapter<Student, DatabaseAdapter>
                (Student.class, R.layout.student_cardview,
                        DatabaseAdapter.class,
                        dbref) {

            public void populateViewHolder(final DatabaseAdapter databaseAdapter,
                                           final Student student, final int position) {
                //String key = String.valueOf(this.getRef(position).getKey());
                //Log.d("key",key);
                //Log.d("Position", String.valueOf(position));

                databaseAdapter.setRollno(student.getRoll());
                databaseAdapter.setContext(getApplicationContext());
                databaseAdapter.setName(student.getName());
                databaseAdapter.setNumber(student.getMobile());
                databaseAdapter.setAge(student.getAge());
            }
        };
        recyclerView.setAdapter(adapter);
    }

}