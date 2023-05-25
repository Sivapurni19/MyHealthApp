package com.sivapurni.myhealthapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class DirRVAdapter extends
        RecyclerView.Adapter<DirRVAdapter.ViewHolder> {
    // variable for our array list and context
    private ArrayList<dirModal> dirModalArrayList;
    private Context context;
    // constructor
    public DirRVAdapter(ArrayList<dirModal> dirModalArrayList, Context
            context) {
        this.dirModalArrayList = dirModalArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public DirRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup
                                                              parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.ext_layout,
                        parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull DirRVAdapter.ViewHolder holder,
                                 int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        dirModal modal = dirModalArrayList.get(position);
        holder.dirIDTV.setText(String.valueOf(modal.getId()));
        holder.dirNameTV.setText(modal.getDate());
        holder.dirDeptTV.setText(modal.getTime());
        holder.dirMailTV.setText(modal.getSystolic());
        holder.dirPhoneTV.setText(modal.getDiastolic());
        holder.dirExtTV.setText(String.valueOf(modal.getBpStatus()));
    }
    @Override
    public int getItemCount() {
        return dirModalArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView
                dirIDTV,dirNameTV,dirDeptTV,dirMailTV,dirPhoneTV,dirExtTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing TextView
            dirIDTV = itemView.findViewById(R.id.tvBil);
            dirNameTV = itemView.findViewById(R.id.tvName);
            dirDeptTV = itemView.findViewById(R.id.tvDept);
            dirMailTV = itemView.findViewById(R.id.tvMail);
            dirPhoneTV = itemView.findViewById(R.id.tvPhone);
            dirExtTV = itemView.findViewById(R.id.tvExt);
        }
    }
}