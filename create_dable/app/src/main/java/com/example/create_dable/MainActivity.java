package com.example.create_dable;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
     sqlhelper mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mk = new sqlhelper(this);
        SQLiteDatabase sqLiteDatabase = mk.getReadableDatabase();
    }
}
