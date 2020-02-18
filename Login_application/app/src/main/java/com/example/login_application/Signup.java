package com.example.login_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login_application.database.db_connection;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    private Button signup_button,reset_button;
    private EditText username,password,confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username = findViewById(R.id.user_name);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);

        signup_button = findViewById(R.id.signup_button);

        signup_button.setOnClickListener(this);
        Toast.makeText(Signup.this,"User name has to unnic",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        String take_user_name = username.getText().toString();
        String take_password = password.getText().toString();
        String take_confirm_password = confirm_password.getText().toString();

        if(view.getId()==R.id.signup_button)
        {
            if(!take_confirm_password.isEmpty()&&!take_password.isEmpty()&&!take_user_name.isEmpty())
            {
                if(take_password.equals(take_confirm_password))
                {
                    db_connection db = new db_connection(this);
                    db.savedata(take_user_name,take_password);

                }else
                {
                    Toast.makeText(Signup.this,"Give the correct password",Toast.LENGTH_LONG).show();

                }
            }else
            {
                Toast.makeText(Signup.this,"complete this",Toast.LENGTH_LONG).show();
            }
            username.setText("");
            password.setText("");
            confirm_password.setText("");

        }



    }
}
