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
import android.widget.Toast;

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

public class ViewActivitiesActivity extends AppCompatActivity {
    private static final String TAG = "ActivitiesActivity";
    private DatabaseReference mDatabaseRef;
    private FirebaseAuth auth;
    private RecyclerView recyclerView;
    private ActivitiesAdapter adapter;
    private ArrayList<Activities> list;
    SharedPreferences sp;
    private ArrayList<String> keylist;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_activities);
        auth = FirebaseAuth.getInstance();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        list = new ArrayList<>();
        sp = getSharedPreferences("p1", MODE_PRIVATE);


        keylist = new ArrayList<>();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Beginners").child("activities");
        Log.d(TAG, "onCreate: HERE====================================123");
        try {
            mDatabaseRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot d : dataSnapshot.getChildren()) {
                        Activities requests = d.getValue(Activities.class);
                        //Log.d(TAG, "onDataChange: " + requests.getCustId());

                        String N = requests.getActtheme();
                        String P = requests.getActname();
                        String K = requests.getActdes();
//                            SharedPreferences.Editor editor= sp.edit();
//                            editor.putString("N",N);
//                            editor.putString("P",P);
//                            editor.putString("K",K);
//                            editor.commit();

                        Log.d(TAG, "==============fnmane: " + N + P + K);
                        list.add(requests);


                    }
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            adapter = new ActivitiesAdapter(this, list, 1);
            recyclerView.setAdapter(adapter);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
        }
    }
}