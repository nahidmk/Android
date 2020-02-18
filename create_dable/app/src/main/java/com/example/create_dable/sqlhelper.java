package com.example.create_dable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.sql.Types;

public class sqlhelper extends SQLiteOpenHelper {
    private static final String DATABESE_NAME = "Student.db";
    private static final String TABLE_NAME = "Student_details";
    private static final int VERTION = 1;
    private static final String NAME = "Name";
    private static final String AGE = "Age";
    private static final String ID = "_Id";
    private static final String ADDRESS = "Address";
    private static final String SQL = "CREATE TABLE "+TABLE_NAME+"( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+"  VARCHAR(15),"+AGE+" INT);";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
    private Context context;
    public sqlhelper(@Nullable Context context ) {
        super(context, DATABESE_NAME,null, VERTION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try
        {
            Toast.makeText(context,"oncreate is done",Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(SQL);

        }catch (Exception e){
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_LONG).show();
            Log.d("mk",e+"");
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try
        {

        }catch (Exception e)
        {

        }
    }
}
