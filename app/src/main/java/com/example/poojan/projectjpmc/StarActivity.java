package com.example.poojan.projectjpmc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.poojan.projectjpmc.Models.Student;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StarActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    FirebaseRecyclerAdapter<Student, StarAdapter> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);
        toolbar = findViewById(R.id.activity_view_toolbar);
        toolbar.setTitle("Star Update");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        layoutManager = new LinearLayoutManager(this);
        //layoutManager.setReverseLayout(true);
        //layoutManager.setStackFromEnd(true);
        recyclerView = findViewById(R.id.viewActivityRecycler);
        loaddata();
    }

    public void loaddata(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        DatabaseReference dbref = FirebaseDatabase.getInstance().getReference().child("Beginners").child("Students");
        dbref.keepSynced(true);

        adapter = new FirebaseRecyclerAdapter<Student, StarAdapter>
                (Student.class, R.layout.star_cardview,
                        StarAdapter.class,
                        dbref) {

            public void populateViewHolder(final StarAdapter starAdapter,
                                           final Student student, final int position) {
                String key = String.valueOf(this.getRef(position).getKey());
                Log.d("key",key);
                //Log.d("Position", String.valueOf(position));

                starAdapter.setRollno(student.getRoll());
                starAdapter.setContext(getApplicationContext());
                starAdapter.setName(student.getName());
            }
        };
        recyclerView.setAdapter(adapter);
    }
}
