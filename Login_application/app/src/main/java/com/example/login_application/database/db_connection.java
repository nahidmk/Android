package com.example.login_application.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class db_connection extends SQLiteOpenHelper {
    //for user name and password
    private static final String DATABASE_NAME = "My_database.db";
    private static final String TABLE_NAME = "Store_password";
    private static final int VERTION = 1;
    private static final String USER_NAME = "User_name";
    private static final String PASSWORD = "passwoed";
    private static final String SQL = "CREATE TABLE "+TABLE_NAME+" ("+USER_NAME+" TEXT PRIMARY KEY,"+PASSWORD+" TEXT);";

    //for registration
    private static final String R_TABLE_NAME = "Registration";
    private static final String R_FULL_NAME = "Full_name";
    private static final String R_ID = "ID";
    private static final String R_EMAIL = "email";
    private static final String R_CONTACT = "contact";
    private static final String R_SQL = "CREATE TABLE "+R_TABLE_NAME+" ("+R_ID+" INTEGER PRIMARY KEY,"+R_FULL_NAME+" TEXT,"+R_EMAIL+" TEXT,"+R_CONTACT+" TEXT);";

    // for diposite
    private static final String D_TABLE_NAME = "Deposite";
    private static final String D_ID = "ID";
    private static final String D_DEPOSITE = "deposite";
    private static final String D_SQL = "CREATE TABLE "+D_TABLE_NAME+"( "+D_ID+" INTEGER PRIMARY KEY, "+D_DEPOSITE+" TEXT);";







    Context context;
    public db_connection(@Nullable Context context) {
        super(context,DATABASE_NAME, null, VERTION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //FOR PASSWORD TABLE
        try{
            Toast.makeText(context,""+TABLE_NAME+" table has been created",Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(SQL);
        }catch (Exception e)
        {
            Toast.makeText(context,"Exception :"+e,Toast.LENGTH_LONG).show();
        }

        //FOR REGISTRATION TABLE
        try {
            Toast.makeText(context,""+R_TABLE_NAME+" table has been created",Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(R_SQL);
        }catch (Exception e)
        {
            Toast.makeText(context,"Exception :"+e,Toast.LENGTH_LONG).show();
        }

        //FOR DEPOSITE TABLE
        try {
            Toast.makeText(context,""+D_TABLE_NAME+" table has been created",Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(D_SQL);
        }catch (Exception e)
        {
            Toast.makeText(context,"Exception :"+e,Toast.LENGTH_LONG).show();
        }

    }

    //for signup
    public void savedata(String username,String password)
    {
        ContentValues values = new ContentValues();
        values.put(USER_NAME,username);
        values.put(PASSWORD,password);

        try
        {
            SQLiteDatabase database = getWritableDatabase();
            long data = database.insert(TABLE_NAME,null,values);
            if(data>0)
            {
                Toast.makeText(context,"save successful",Toast.LENGTH_LONG).show();
            }else
            {
                Toast.makeText(context,"sorry",Toast.LENGTH_LONG).show();
            }

        }catch (Exception e)
        {
            Toast.makeText(context,"Exceptoin:"+e,Toast.LENGTH_LONG).show();
        }

    }

    //for login
    public Cursor readdata(String username)
    {
        String sql = "select * from "+TABLE_NAME+";";
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(sql,null);
        return cursor;
    }

    //for registration
    public void savereagitrationdata(String id,String fulllname,String email,String contact)
    {

        ContentValues contentValues = new ContentValues();
        contentValues.put(R_ID,id);
        contentValues.put(R_FULL_NAME,fulllname);
        contentValues.put(R_EMAIL,email);
        contentValues.put(R_CONTACT,contact);
        //INITIAL DEPOSITE TABLE
        ContentValues content  = new ContentValues();
        content.put(D_ID,id);
        content.put(D_DEPOSITE,"0");
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            long value = sqLiteDatabase.insert(R_TABLE_NAME,null,contentValues);
            long valuee = sqLiteDatabase.insert(D_TABLE_NAME,null,content);
            if(value>0 && valuee>0)
            {
                Toast.makeText(context,"save successful",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(context,"sorry",Toast.LENGTH_LONG).show();
            }
        }catch (Exception e)
        {
            Toast.makeText(context,"Exceptoin:"+e,Toast.LENGTH_LONG).show();
        }

    }

    //FOR DEPOSITE
    public int []save_deposite_data(String id, int amount)
    {
        String sql = "select * from "+D_TABLE_NAME+";";
        int arr[] = new int[2];
        int store_past_amount = 0,flag = 0,total_amount = 0;
        String te = "";
        SQLiteDatabase database = getReadableDatabase();
        try
        {
            Cursor cursor = database.rawQuery(sql,null);
            if(cursor.getCount()!=0)
            {
                while (cursor.moveToNext())
                {
                    te = cursor.getString(0);
                    if(te.equals(id))
                    {
                        flag = 1;
                        store_past_amount = Integer.parseInt(cursor.getString(1));
                    }
                }
                if(flag==0)
                {
                    Toast.makeText(context,"This id is not exist",Toast.LENGTH_LONG).show();
                    return arr;
                }else
                {
                    ContentValues content  = new ContentValues();

                    SQLiteDatabase database1 = getWritableDatabase();
                    content.put(D_ID,id);
                    content.put(D_DEPOSITE,""+(store_past_amount+amount));
                    long value = database.update(D_TABLE_NAME,content,D_ID+" = ?",new String[]{id});
                    if(value>0)
                    {
                        Toast.makeText(context,"Update successfully",Toast.LENGTH_LONG).show();
                    }else
                    {
                        Toast.makeText(context,"Update Unsuccessfull",Toast.LENGTH_LONG).show();
                    }

                }
                Cursor cursor1 = database.rawQuery(sql,null);
                if(cursor1.getCount()!=0)
                {
                    while (cursor1.moveToNext()) {
                        total_amount += Integer.parseInt(cursor1.getString(1));
                    }
                }


                arr[0] = store_past_amount+amount;
                arr[1] = total_amount;
            }else
            {
                Toast.makeText(context,"At first you have to registration",Toast.LENGTH_LONG).show();
            }


        }catch (Exception e)
        {
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_LONG).show();

        }



       return arr;

    }

    //for information
    public Cursor information_name()
    {
        SQLiteDatabase database = getReadableDatabase();
        String sql = "SELECT * FROM "+R_TABLE_NAME+";";
        Cursor cursor = database.rawQuery(sql,null);

       return cursor;
    }
    public Cursor information_deposite()
    {
        SQLiteDatabase database = getReadableDatabase();
        String sql = "SELECT * FROM "+D_TABLE_NAME+";";
        Cursor cursor = database.rawQuery(sql,null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
