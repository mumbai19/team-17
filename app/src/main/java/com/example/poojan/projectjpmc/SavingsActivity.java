package com.example.poojan.projectjpmc;

/**
 * Created by simra on 21-07-2019.
 */

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.poojan.projectjpmc.Models.Student;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SavingsActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    FirebaseRecyclerAdapter<Student, SavingsAdapter> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings);

        toolbar = findViewById(R.id.attend_toolbar);
        toolbar.setTitle("Savings Update");
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

        adapter = new FirebaseRecyclerAdapter<Student, SavingsAdapter>
                (Student.class, R.layout.status_cardviewsav,
                        SavingsAdapter.class,
                        dbref) {

            public void populateViewHolder(final SavingsAdapter savingsAdapter,
                                           final Student student, final int position) {
                //String k ey = String.valueOf(this.getRef(position).getKey());
                //Log.d("key",key);
                //Log.d("Position", String.valueOf(position));

                savingsAdapter.setRollno(student.getRoll());
                savingsAdapter.setContext(getApplicationContext());
                savingsAdapter.setName(student.getName());
                Log.d("", "-----------------------------------------------"+student.getSaving());
                //Toast.makeText(SavingsActivity.this, "-----------------------------------------------"+student.getSaving(), Toast.LENGTH_SHORT).show();
                savingsAdapter.setSavings(student.getSaving());
            }
        };
        recyclerView.setAdapter(adapter);
    }
}




