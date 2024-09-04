package com.example.todoapp;

public class Task {
    private String taskname;
    private boolean taskstatus;

    // Constructor
    public Task(String name, boolean status) {
        this.taskname = name;
        this.taskstatus = status;
    }
    // Getter for taskname
    public String getTaskname() {
        return taskname;
    }
    // Getter for taskstatus
    public boolean getTaskstatus() {
        return taskstatus;
    }
    // Setter for taskname
    public void setTaskname(String name) {
        this.taskname = name;
    }
    // Setter for taskstatus
    public void setTaskstatus(boolean taskstatus) {
        this.taskstatus = taskstatus;
    }


}
