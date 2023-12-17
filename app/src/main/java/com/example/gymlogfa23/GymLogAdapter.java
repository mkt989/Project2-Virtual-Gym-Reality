package com.example.gymlogfa23;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GymLogAdapter extends RecyclerView.Adapter<GymLogAdapter.GymLogViewHolder> {

    private List<GymLog> mGymLogs;

    public GymLogAdapter(List<GymLog> gymLogs) {
        this.mGymLogs = gymLogs;
    }

    @NonNull
    @Override
    public GymLogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_gym_log, parent, false);
        return new GymLogViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GymLogViewHolder holder, int position) {
        GymLog gymLog = mGymLogs.get(position);
        // Bind GymLog data to views in ViewHolder
        holder.bind(gymLog);
    }

    @Override
    public int getItemCount() {
        return mGymLogs.size();
    }

    static class GymLogViewHolder extends RecyclerView.ViewHolder {
        private TextView textExercise;

        GymLogViewHolder(View itemView) {
            super(itemView);
            textExercise = itemView.findViewById(R.id.textExercise);
            // Find other views and initialize them here
        }

        void bind(GymLog gymLog) {
            textExercise.setText(gymLog.getExercise());
            // Bind other GymLog data to respective views here
        }
    }
}