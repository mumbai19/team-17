package com.example.poojan.projectjpmc;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.poojan.projectjpmc.Models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    public boolean closeview = false;
    private FirebaseAuth auth;
    private FirebaseUser userF;
    private TextView userName, userEmail;
    ImageView userImg;
    private CardView beginner_card, foundation_card, transit_card, discovery_card, dream_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        beginner_card = findViewById(R.id.beginner_card);
        foundation_card = findViewById(R.id.foundation_card);
        transit_card = findViewById(R.id.transit_card);
        discovery_card = findViewById(R.id.discovery_card);
        dream_card = findViewById(R.id.dream_card);

        toolbar = findViewById(R.id.feature_req_toolbar);
        toolbar.setTitle("Home");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        auth = FirebaseAuth.getInstance();

        beginner_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, BeginnerActivity.class);
                startActivity(i);
            }
        });

        foundation_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, BeginnerActivity.class);
                startActivity(i);
            }
        });

        transit_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, BeginnerActivity.class);
                startActivity(i);
            }
        });

        discovery_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, BeginnerActivity.class);
                startActivity(i);
            }
        });

        dream_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, BeginnerActivity.class);
                startActivity(i);
            }
        });

        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        drawer.closeDrawers();

                        if(menuItem.getItemId() == R.id.logout){
                            /*dbtoken = FirebaseDatabase.getInstance().getReference().child("user_details")
                                    .child(auth.getUid()).child("token");
                            dbtoken.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        dataSnapshot.getRef().removeValue();
                                    }
                                }
                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });*/
                            auth.signOut();
                            userF = FirebaseAuth.getInstance().getCurrentUser();
                            if (userF == null) {
                                // user auth state is changed - user is null
                                // launch login activity
                                Intent intent = new Intent(Home.this, Launcher.class);
                                startActivity(intent);
                                finish();
                            }
                            return true;
                        }

                        if(menuItem.getItemId() == R.id.accSetting){
                            Intent intent = new Intent(Home.this, AccountSetting.class);
                            startActivity(intent);
                        }
                        if(menuItem.getItemId() == R.id.wall){
                            //Intent intent = new Intent(Home.this, Wall.class);
                            //startActivity(intent);
                        }
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

        navigationView.setItemIconTintList(null);
        userName = navigationView.getHeaderView(0).findViewById(R.id.head_name);
        userEmail = navigationView.getHeaderView(0).findViewById(R.id.head_email);
        userImg = navigationView.getHeaderView(0).findViewById(R.id.user_image);

        DatabaseReference dbuser = FirebaseDatabase.getInstance().getReference().child("user_details").child(auth.getUid());
        dbuser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                userName.setText(user.getName());
                userEmail.setText(user.getEmail());
                if(!user.getUserImgUrl().equals("no")){
                    Glide.with(getApplicationContext()).load(user.getUserImgUrl()).into(userImg);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void onBackPressed() {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else if (closeview) {
            closeview = false;
            finish();
            startActivity(getIntent());

        } else {
            super.onBackPressed();
        }
    }

    public void closeview(Boolean value) {
        closeview = value;
    }
}
