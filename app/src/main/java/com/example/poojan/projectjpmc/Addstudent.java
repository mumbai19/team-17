package com.example.poojan.projectjpmc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.poojan.projectjpmc.Models.Student;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Addstudent extends AppCompatActivity {

    EditText name, mobile, rollno, age;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);
        name = findViewById(R.id.student_name);
        mobile = findViewById(R.id.student_phone);
        rollno = findViewById(R.id.student_rollno);
        age = findViewById(R.id.student_age);
        submit = findViewById(R.id.btn_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = new Student(name.getText().toString(), Long.parseLong(mobile.getText().toString()),
                        rollno.getText().toString(), Integer.parseInt(age.getText().toString()), 0, 0 ,0);
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("Beginners")
                        .child("Students").child(rollno.toString());
                db.setValue(student);
            }
        });
    }
}
