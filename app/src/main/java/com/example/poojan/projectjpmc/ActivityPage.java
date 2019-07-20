package com.example.poojan.projectjpmc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityPage extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    EditText theme, name, desc;
    String aTheme, aName, aDesc;
    Button btn, btnView;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        toolbar = findViewById(R.id.activity_page_toolbar);
        toolbar.setTitle("Activity Page");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        theme = findViewById(R.id.act_theme);
        name = findViewById(R.id.act_name);
        desc = findViewById(R.id.act_desc);
        btn = findViewById(R.id.btn_submit);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aTheme = theme.getText().toString().trim();
                aName = name.getText().toString().trim();
                aDesc = desc.getText().toString().trim();

                if(TextUtils.isEmpty(aTheme)){
                    Toast.makeText(ActivityPage.this, "Enter the Theme", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(aName)){
                    Toast.makeText(ActivityPage.this, "Enter the Activity Name", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(aDesc)){
                    Toast.makeText(ActivityPage.this, "Enter the description", Toast.LENGTH_SHORT).show();
                }else{
                    DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("Beginner").child("Activity");
                    db.push().setValue(aDesc);
                }
            }
        });

    }
}
