package com.example.poojan.projectjpmc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Launcher extends AppCompatActivity {

    ProgressDialog loginProgress;
    private FirebaseAuth auth;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        auth = FirebaseAuth.getInstance();
        loginProgress = ProgressDialog.show(this, null, "Please wait...", true);
        loginProgress.setCancelable(false);
        btn = findViewById(R.id.launcher_next);

        if (auth.getCurrentUser() != null) {
            loginProgress.dismiss();
            startActivity(new Intent(Launcher.this, Home.class));
            finish();
            return;
        }
        loginProgress.dismiss();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Launcher.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
