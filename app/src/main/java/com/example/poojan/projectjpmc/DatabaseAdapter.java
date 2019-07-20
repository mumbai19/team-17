package com.example.poojan.projectjpmc;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatabaseAdapter extends RecyclerView.ViewHolder {

    TextView rollno, name, mobile, age;
    Context context;

    public DatabaseAdapter(View itemView) {
        super(itemView);

        rollno = itemView.findViewById(R.id.db_roll);
        name = itemView.findViewById(R.id.db_name);
        mobile = itemView.findViewById(R.id.db_number);
        age = itemView.findViewById(R.id.db_age);

    }
    public void setContext(Context context){
        this.context = context;
    }
    public void setRollno(String roll){
        rollno.setText(roll);
    }
    public void setName(String xname){
        name.setText(xname);
    }
    public void setNumber(Long numb){
        mobile.setText(String.valueOf(numb));
    }
    public void setAge(int agex){
        age.setText(String.valueOf(agex));
    }
}
