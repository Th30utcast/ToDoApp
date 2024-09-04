package com.example.todoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private List<Task> taskList;

    // Constructor to initialize the task list
    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    // ViewHolder class to represent each task item view
    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView taskname; // TextView for task name
        CheckBox taskcheckbox;  // CheckBox to indicate task completion

        public TaskViewHolder(View itemView) {
            super(itemView);
            // Initialize the views from the layout using their IDs
            taskname = itemView.findViewById(R.id.taskname);
            taskcheckbox = itemView.findViewById(R.id.taskcheckbox);
        }
    }

    @NonNull
    @Override
    // Create a new ViewHolder for each item in the RecyclerView
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    // Bind data to the ViewHolder
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        // Get the current task from the task list
        Task currentTask = taskList.get(position);

        // Bind the task data to the views
        holder.taskname.setText(currentTask.getTaskname());
        holder.taskcheckbox.setChecked(currentTask.getTaskstatus());

        // Handle checking/unchecking of the checkbox
        holder.taskcheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Update the task's completion status
            currentTask.setTaskstatus(isChecked);
        });
    }

    @Override
    // Return the total number of items in the RecyclerView
    public int getItemCount() {
        return taskList.size();
    }
}
