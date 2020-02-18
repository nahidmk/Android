package com.example.drag_and_drop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button signuf,reset;
    private EditText Text,Text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signuf = findViewById(R.id.signup_button);
        reset = findViewById(R.id.reset_button);
        Text = findViewById(R.id.editText);
        Text2 = findViewById(R.id.editText2);
        signuf.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.signup_button)
        {
            Intent intent = new Intent(MainActivity.this,signup.class);
            String te1 = Text.getText().toString();
            String te2 = Text2.getText().toString();
            intent.putExtra("1",te1);
            intent.putExtra("2",te2);
            startActivity(intent);
        }
        if(view.getId()==R.id.reset_button)
        {
            Text.setText("");
            Text2.setText("");
        }

    }
}
