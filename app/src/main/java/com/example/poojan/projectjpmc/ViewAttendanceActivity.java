package com.example.poojan.projectjpmc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.poojan.projectjpmc.Models.Student;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewAttendanceActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    FirebaseRecyclerAdapter<Student, AttendanceAdapter> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);

        toolbar = findViewById(R.id.attend_toolbar);
        toolbar.setTitle("Attendance View");
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

        adapter = new FirebaseRecyclerAdapter<Student, AttendanceAdapter>
                (Student.class, R.layout.status_cardview,
                        AttendanceAdapter.class,
                        dbref) {

            public void populateViewHolder(final AttendanceAdapter attendanceAdapter,
                                           final Student student, final int position) {
                //String key = String.valueOf(this.getRef(position).getKey());
                //Log.d("key",key);
                //Log.d("Position", String.valueOf(position));

                attendanceAdapter.setRollno(student.getRoll());
                attendanceAdapter.setContext(getApplicationContext());
                attendanceAdapter.setName(student.getName());
                attendanceAdapter.setAttendance(student.getAttendance());
            }
        };
        recyclerView.setAdapter(adapter);
    }
}
