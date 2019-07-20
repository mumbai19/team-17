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

//        toolbar = findViewById(R.id.accout_setting);
//        toolbar.setTitle("Activity Page");
       // setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        databaseReference = FirebaseDatabase.getInstance().getReference("Beginners").child("activities");

        theme = findViewById(R.id.act_theme);
        name = findViewById(R.id.act_name);
        desc = findViewById(R.id.act_desc);
        btn = findViewById(R.id.btn_submit);
        btnView = findViewById(R.id.btn_view_act);

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
                    String key = databaseReference.push().getKey();
                    Activities activity = new Activities(aTheme, aName, aDesc);
                    databaseReference.child(key).setValue(activity);
                    Toast.makeText(ActivityPage.this, "Activity Added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityPage.this, ViewActivitiesActivity.class);
                startActivity(i);
            }
        });
    }
}
