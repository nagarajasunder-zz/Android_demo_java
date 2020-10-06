package com.geekydroid.javademo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface Todo_Dao {

    @Insert
    void insert_todo(Todo todo);

    @Query("SELECT * FROM todo")
    List<Todo> get_all_todos();

    @Query("SELECT * FROM todo WHERE uid LIKE:uid")
    Todo find_todo_by_id(String uid);

    @Delete
    void delete_a_todo(Todo todo);

    @Update
    void update_a_todo(Todo todo);

    @Insert
    void insert_more_todos(List<Todo> todoList);

    @Query("SELECT * FROM todo WHERE completed LIKE 1")
    List<Todo> get_all_completed();
}
