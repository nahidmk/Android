package com.example.login_application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login_application.database.db_connection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private Button login_buton,reset_button,signup_button;
  private EditText username,password;
  private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.user_name1);
        password = findViewById(R.id.password1);
        textView = findViewById(R.id.textveiw);

        login_buton = findViewById(R.id.login_button1);
        signup_button = findViewById(R.id.signup_button1);

        login_buton.setOnClickListener(this);
        signup_button.setOnClickListener(this);
        db_connection db = new db_connection(this);
        SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
    }

    @Override
    public void onClick(View view) {
        String user_name = username.getText().toString();
        String pass = password.getText().toString();
        if(view.getId()==R.id.login_button1)
        {
            if(!user_name.isEmpty()&&!pass.isEmpty())
            {
                username.setText("");
                password.setText("");
                String te = "",te1 = "";
                int flag = 0;
                db_connection dbConnection = new db_connection(this);
                Cursor cursor = dbConnection.readdata(user_name);
                if(cursor.getCount()!=0)
                {
                    while(cursor.moveToNext())
                    {
                        te = cursor.getString(0);
                        te1 = cursor.getString(1);
                         if(te.equals(user_name)&&te1.equals(pass))
                         {

                             flag = 1;
                             break;
                         }
                    }
                    if(flag==1)
                    {
                        Intent intent = new Intent(MainActivity.this,start.class);
                        startActivity(intent);

                    }else
                    {
                        Toast.makeText(MainActivity.this,"Wrong UserName or password",Toast.LENGTH_LONG).show();
                    }
                }else
                {
                    Toast.makeText(MainActivity.this,"At first please Signup ",Toast.LENGTH_LONG).show();
                }


            }else
            {
                Toast.makeText(MainActivity.this,"complete this",Toast.LENGTH_LONG).show();
            }
        }

        if(view.getId()==R.id.signup_button1)
        {
            Intent intent = new Intent(MainActivity.this,Signup.class);
            startActivity(intent);
        }



    }


    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Attention");
        builder.setMessage("Do you want to exit..?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              dialogInterface.cancel();
            }
        });
        builder.setCancelable(false);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
