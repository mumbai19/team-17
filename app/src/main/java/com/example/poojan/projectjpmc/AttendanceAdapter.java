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
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.afollestad.materialdialogs.DialogAction;
//import com.afollestad.materialdialogs.MaterialDialog;
//import com.google.android.gms.flags.impl.SharedPreferencesFactory;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

//import de.j4velin.mapsmeasure.R;
//import es.dmoral.toasty.Toasty;

import static android.content.Context.MODE_PRIVATE;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttendanceHolder> {
    private static final String TAG = "StudentsAdapter";
    private Context mContext;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth auth;
    private ArrayList<Student> mlist;
    private int flag ;
    private Student requests;
    private FirebaseUser firebaseUser;
    private String pk;

    public AttendanceAdapter(Context context, ArrayList<Student> list, int flag) {
        mContext = context;
        auth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("students");
        mlist = list;
        this.flag = flag;


//        Log.d(TAG, "AssetAdapter: " + String.valueOf(mlist.size()));
    }

    @Override
    public AttendanceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called");
        Log.d(TAG, "onCreateViewHolder: GOT REQUEST CALLED===================");
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.status_cardview, parent, false);
        return new AttendanceHolder(view);

    }

    @Override
    public void onBindViewHolder(final AttendanceHolder holder, final int position) {
        if (mlist.size()!=0) {
//            Log.d(TAG, "onBindViewHolder: called" + String.valueOf(position))

            requests = mlist.get(holder.getAdapterPosition());
            holder.tvName.setText(mlist.get(holder.getAdapterPosition()).getName());



//                        Toast.makeText(mContext, pk + "dfsdfnkwfnuefer",Toast.LENGTH_LONG).show();

                    notifyDataSetChanged();




        }}

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class AttendanceHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        CheckBox cbAttendance;
        public int p=0;

        public AttendanceHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            cbAttendance = itemView.findViewById(R.id.cbAttendance);
            if(cbAttendance.isChecked()){
                p=1;
            }
        }

    }

    public ArrayList<Student> getRequestsOb(){
        return mlist;
    }
}
