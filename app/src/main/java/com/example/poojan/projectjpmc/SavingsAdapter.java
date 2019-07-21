package com.example.poojan.projectjpmc;

/**
 * Created by simra on 21-07-2019.
 */

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
import android.widget.EditText;
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

public class SavingsAdapter extends RecyclerView.ViewHolder {

    TextView rollno, name;
    EditText saved;
    Button reset,update;
    int saving;
    String aRollno, aName,savings;
    int savi;
    Context context;
    public SavingsAdapter(View itemView) {
        super(itemView);

        rollno = itemView.findViewById(R.id.att_rollno);
        name = itemView.findViewById(R.id.att_name);
        saved=itemView.findViewById(R.id.savings);
        update=itemView.findViewById(R.id.btn_update);
        reset=itemView.findViewById(R.id.btn_reset);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference()
                        .child("Beginners").child("Students").child(aRollno).child("saving");
                if (saved.getText().toString().length() != 0){
                    try{
                saving = Integer.parseInt(saved.getText().toString());}
                catch(Exception e){
                    Toast.makeText(context, "Please enter valid number", Toast.LENGTH_SHORT).show();
                }}
                else{
                    Toast.makeText(context, "Please enter a number", Toast.LENGTH_SHORT).show();
                }
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                                .child("Beginners").child("Students").child(aRollno).child("saving");

                        dbref.setValue(saving);
                        Toast.makeText(context, "Savings Added", Toast.LENGTH_SHORT).show();
                        }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference()
                        .child("Beginners").child("Students").child(aRollno).child("saving");
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                                .child("Beginners").child("Students").child(aRollno).child("saving");
                        dbref.setValue(0);
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
    public void setSavings(int sav){
        savi = sav;
        saved.setText(String.valueOf(savi));
    }
}


