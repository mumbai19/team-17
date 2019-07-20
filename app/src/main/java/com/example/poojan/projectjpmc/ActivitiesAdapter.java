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

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ActivitiesHolder> {
    private static final String TAG = "ActivitiesAdapter";
    private Context mContext;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth auth;
    private ArrayList<Activities> mlist;
    private int flag ;
    private Activities requests;
    private FirebaseUser firebaseUser;
    private String pk;

    public ActivitiesAdapter(Context context, ArrayList<Activities> list, int flag) {
        mContext = context;
        auth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Beginners").child("activities");
        mlist = list;
        this.flag = flag;


//        Log.d(TAG, "AssetAdapter: " + String.valueOf(mlist.size()));
    }

    @Override
    public ActivitiesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called");
        Log.d(TAG, "onCreateViewHolder: GOT REQUEST CALLED===================");
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.activities_cardview, parent, false);
        return new ActivitiesHolder(view);

    }

    @Override
    public void onBindViewHolder(final ActivitiesHolder holder, final int position) {
        if (mlist.size()!=0) {
//            Log.d(TAG, "onBindViewHolder: called" + String.valueOf(position))

            requests = mlist.get(holder.getAdapterPosition());
            holder.tvNumber1.setText(mlist.get(holder.getAdapterPosition()).getActtheme());
            holder.tvWeight1.setText(String.valueOf(mlist.get(holder.getAdapterPosition()).getActname()));
            holder.tvHeight1.setText(String.valueOf(mlist.get(holder.getAdapterPosition()).getActdes()));

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
//                        Toast.makeText(mContext, pk + "dfsdfnkwfnuefer",Toast.LENGTH_LONG).show();
                    String N=mlist.get(holder.getAdapterPosition()).getActtheme();
                    String P=mlist.get(holder.getAdapterPosition()).getActname();
                    String K=mlist.get(holder.getAdapterPosition()).getActdes();
                    notifyDataSetChanged();

                    return true;

                }
            });

        }
    else{
            Toast.makeText(mContext, "ELSEEEEEEEE", Toast.LENGTH_SHORT).show();
            Log.d("" ,"ELSEEEEEEEEEEEEEEE");
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class ActivitiesHolder extends RecyclerView.ViewHolder {

        TextView tvNumber1;
        TextView tvWeight1;
        TextView tvHeight1;

        public ActivitiesHolder(View itemView) {
            super(itemView);

            tvNumber1 = itemView.findViewById(R.id.tvTheme1);
            tvWeight1 = itemView.findViewById(R.id.tvActName1);
            tvHeight1 = itemView.findViewById(R.id.tvDescription1);
        }

    }

    public ArrayList<Activities> getRequestsOb(){
        return mlist;
    }
}
