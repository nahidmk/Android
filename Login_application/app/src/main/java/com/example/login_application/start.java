package com.example.login_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class start extends AppCompatActivity implements View.OnClickListener {
    private Button registration_button,mell_button,diposit_button,information_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        registration_button = findViewById(R.id.registration_Button);
        mell_button = findViewById(R.id.mell_Button);
        diposit_button = findViewById(R.id.deposite_Button);
        information_button = findViewById(R.id.intire_informantion);

        registration_button.setOnClickListener(this);
        mell_button.setOnClickListener(this);
        diposit_button.setOnClickListener(this);
        information_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.registration_Button)
        {
            Intent intent = new Intent(start.this,registration.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.mell_Button)
        {

        }
        else if(view.getId()==R.id.deposite_Button)
        {
            Intent intent = new Intent(start.this,deposite.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.intire_informantion)
        {
            Intent intent = new Intent(start.this,informatin.class);
            startActivity(intent);


        }

    }
}
