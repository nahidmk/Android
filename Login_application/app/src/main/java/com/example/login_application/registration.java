package com.example.login_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login_application.database.db_connection;

public class registration extends AppCompatActivity implements View.OnClickListener {
    private EditText id,fullname,email,contact;
    private Button savedatabutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        id = findViewById(R.id.R_ID);
        fullname = findViewById(R.id.R_fullname);
        email = findViewById(R.id.R_email);
        contact = findViewById(R.id.R_contact);

        savedatabutton = findViewById(R.id.ResitrationsaveButton);
        savedatabutton.setOnClickListener(this);
        Toast.makeText(registration.this,"ID should be unic",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {

        String r_id = id.getText().toString();
        String r_fullname = fullname.getText().toString();
        String r_emil = email.getText().toString();
        String r_contact = contact.getText().toString();
        if(!r_id.isEmpty()&&!r_fullname.isEmpty()&&!r_emil.isEmpty()&&!r_contact.isEmpty())
        {
            db_connection db = new db_connection(this);
            db.savereagitrationdata(r_id,r_fullname,r_emil,r_contact);
        }else
        {
            Toast.makeText(registration.this,"complete this",Toast.LENGTH_LONG).show();
        }

        id.setText("");
        fullname.setText("");
        email.setText("");
        contact.setText("");

    }
}
