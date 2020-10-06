package com.geekydroid.javademo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {
        Todo.class
},version = 1,exportSchema = false)
public abstract class MyRoomDatabase extends RoomDatabase {

    private static volatile MyRoomDatabase INSTANCE;

    static MyRoomDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MyRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyRoomDatabase.class, "todo.db").build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract Todo_Dao Todo_Dao();
}
