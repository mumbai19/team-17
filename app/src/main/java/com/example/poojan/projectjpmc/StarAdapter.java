package com.example.poojan.projectjpmc;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StarAdapter extends RecyclerView.ViewHolder {
    Context context;
    TextView rollno, name, gr1, gr2, gr3, gr4, gr5;
    String aRollno, aName;
    Button b1,b2,b3,b4,b5;
    public StarAdapter(View itemView) {
        super(itemView);
        rollno = itemView.findViewById(R.id.att_rollno);
        name = itemView.findViewById(R.id.att_name);
        b1 = itemView.findViewById(R.id.gr1);
        b2 = itemView.findViewById(R.id.gr2);
        b3 = itemView.findViewById(R.id.gr3);
        b4 = itemView.findViewById(R.id.gr4);
        b5 = itemView.findViewById(R.id.gr5);

        gr1 = itemView.findViewById(R.id.mr1);
        gr2 = itemView.findViewById(R.id.mr2);
        gr3 = itemView.findViewById(R.id.mr3);
        gr4 = itemView.findViewById(R.id.mr4);
        gr5 = itemView.findViewById(R.id.mr5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1.setBackgroundResource(R.color.red);
                DatabaseReference db = FirebaseDatabase.getInstance().getReference()
                        .child("Beginners").child("Students").child(aRollno).child("gr1");
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            int temp = dataSnapshot.getValue(Integer.class);
                            DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                                    .child("Beginners").child("Students").child(aRollno).child("gr1");
                            dbref.setValue(temp+1);
                        }else{
                            DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                                    .child("Beginners").child("Students").child(aRollno).child("gr1");
                            dbref.setValue(1);
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b2.setBackgroundResource(R.color.red);
                DatabaseReference db = FirebaseDatabase.getInstance().getReference()
                        .child("Beginners").child("Students").child(aRollno).child("gr2");
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            int temp = dataSnapshot.getValue(Integer.class);
                            DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                                    .child("Beginners").child("Students").child(aRollno).child("gr2");
                            dbref.setValue(temp+1);
                        }else{
                            DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                                    .child("Beginners").child("Students").child(aRollno).child("gr2");
                            dbref.setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b3.setBackgroundResource(R.color.red);
                DatabaseReference db = FirebaseDatabase.getInstance().getReference()
                        .child("Beginners").child("Students").child(aRollno).child("gr3");
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            int temp = dataSnapshot.getValue(Integer.class);
                            DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                                    .child("Beginners").child("Students").child(aRollno).child("gr3");
                            dbref.setValue(temp+1);
                        }else{
                            DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                                    .child("Beginners").child("Students").child(aRollno).child("gr3");
                            dbref.setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b4.setBackgroundResource(R.color.red);
                DatabaseReference db = FirebaseDatabase.getInstance().getReference()
                        .child("Beginners").child("Students").child(aRollno).child("gr4");
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            int temp = dataSnapshot.getValue(Integer.class);
                            DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                                    .child("Beginners").child("Students").child(aRollno).child("gr4");
                            dbref.setValue(temp+1);
                        }else{
                            DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                                    .child("Beginners").child("Students").child(aRollno).child("gr4");
                            dbref.setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b5.setBackgroundResource(R.color.red);
                DatabaseReference db = FirebaseDatabase.getInstance().getReference()
                        .child("Beginners").child("Students").child(aRollno).child("gr5");
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            int temp = dataSnapshot.getValue(Integer.class);
                            DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                                    .child("Beginners").child("Students").child(aRollno).child("gr5");
                            dbref.setValue(temp+1);
                        }else{
                            DatabaseReference dbref = FirebaseDatabase.getInstance().getReference()
                                    .child("Beginners").child("Students").child(aRollno).child("gr5");
                            dbref.setValue(1);
                        }
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

    public void setGrades(int g1,int g2,int g3,int g4,int g5){
        gr1.setText(String.valueOf(g1));
        gr2.setText(String.valueOf(g2));
        gr3.setText(String.valueOf(g3));
        gr4.setText(String.valueOf(g4));
        gr5.setText(String.valueOf(g5));
        gr1.setVisibility(View.VISIBLE);
        gr2.setVisibility(View.VISIBLE);
        gr3.setVisibility(View.VISIBLE);
        gr4.setVisibility(View.VISIBLE);
        gr5.setVisibility(View.VISIBLE);
        b1.setVisibility(View.GONE);
        b2.setVisibility(View.GONE);
        b3.setVisibility(View.GONE);
        b4.setVisibility(View.GONE);
        b5.setVisibility(View.GONE);
    }
}
