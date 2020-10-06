package com.geekydroid.javademo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "todo")
public class Todo {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    private int uid;

    @ColumnInfo(name = "todo")
    private String todo;

    @ColumnInfo(name = "completed")
    private boolean completed;

    public Todo(String todo, boolean completed) {
        this.todo = todo;
        this.completed = completed;
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "\nTodo{" +
                "uid=" + uid +
                ", todo='" + todo + '\'' +
                ", completed=" + completed +
                '}';
    }
}


