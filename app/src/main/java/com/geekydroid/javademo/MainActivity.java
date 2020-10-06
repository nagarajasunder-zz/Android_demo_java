package com.geekydroid.javademo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insert_todo(View view) {
        InsertTask task = new InsertTask();
        task.execute();
    }

    public void get_all_todo(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Todo> todoList =
                        MyRoomDatabase.getInstance(MainActivity.this).Todo_Dao().get_all_todos();
                Log.d(TAG, "run: " + todoList.toString());
            }
        }).start();
    }

    public void delete_a_todo(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Todo> todoList = MyRoomDatabase.getInstance(MainActivity.this).Todo_Dao().get_all_todos();
                Log.d(TAG, "run: " + todoList.toString());

                Todo todo = MyRoomDatabase.getInstance(MainActivity.this).Todo_Dao().find_todo_by_id("5");
                MyRoomDatabase.getInstance(MainActivity.this).Todo_Dao().delete_a_todo(todo);
                Log.d(TAG, "run: todo has been deleted");
            }
        }).start();
    }

    public void update_a_todo(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Todo todo = MyRoomDatabase.getInstance(MainActivity.this).Todo_Dao().find_todo_by_id("1");
                todo.setCompleted(true);
                MyRoomDatabase.getInstance(MainActivity.this).Todo_Dao().update_a_todo(todo);
                Log.d(TAG, "run: Todo has been updated");
            }
        }).start();
    }

    public void insert_more_todos(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Todo> todoList = new ArrayList<Todo>();
                todoList.add(new Todo("Study room database today", false));
                todoList.add(new Todo("Study flutter daily", false));
                MyRoomDatabase.getInstance(MainActivity.this).Todo_Dao().insert_more_todos(todoList);
                Log.d(TAG, "run: Many todos added");
            }
        }).start();
    }

    public void get_completed_todos(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Todo> todoList = MyRoomDatabase.getInstance(MainActivity.this).Todo_Dao().get_all_completed();
                Log.d(TAG, "run: " + todoList.toString());
            }
        }).start();
    }


    class InsertTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            MyRoomDatabase.getInstance(MainActivity.this).Todo_Dao().insert_todo(new Todo("First todo", false));
            return null;
        }
    }
}