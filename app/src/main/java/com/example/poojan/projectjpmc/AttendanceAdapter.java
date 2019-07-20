package com.example.poojan.projectjpmc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.afollestad.materialdialogs.DialogAction;
//import com.afollestad.materialdialogs.MaterialDialog;
//import com.google.android.gms.flags.impl.SharedPreferencesFactory;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

//import de.j4velin.mapsmeasure.R;
//import es.dmoral.toasty.Toasty;

import static android.content.Context.MODE_PRIVATE;

public class AttendanceAdapter extends RecyclerView.ViewHolder {

    TextView rollno, name, attendance, total;
    Button btnpresent, btnabsent;
    String aRollno, aName;
    Context context;
    public AttendanceAdapter(View itemView) {
        super(itemView);

        rollno = itemView.findViewById(R.id.att_rollno);
        name = itemView.findViewById(R.id.att_name);
        attendance = itemView.findViewById(R.id.att_att);
        total = itemView.findViewById(R.id.att_tot);
        btnpresent = itemView.findViewById(R.id.att_present);
        btnabsent = itemView.findViewById(R.id.att_absent);

        btnpresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference()
                        .child("Beginners").child("Students").child(aRollno).child("attendance");
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Integer att = dataSnapshot.getValue(Integer.class);
                        DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                                .child("Beginners").child("Students").child(aRollno).child("attendance");
                        dbref.setValue(att+1);
                        btnabsent.setVisibility(View.VISIBLE);
                        btnpresent.setVisibility(View.GONE);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
        btnabsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference()
                        .child("Beginners").child("Students").child(aRollno).child("attendance");
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Integer att = dataSnapshot.getValue(Integer.class);
                        DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                                .child("Beginners").child("Students").child(aRollno).child("attendance");
                        dbref.setValue(att-1);
                        btnabsent.setVisibility(View.GONE);
                        btnpresent.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
    }

    public void setContext(Context context){
        this.context = context;
    }
    public void setRollno(String roll){
        aRollno = roll;
        rollno.setText(roll);
    }
    public void setName(String xname){
        aName = xname;
        name.setText(xname);
    }

}