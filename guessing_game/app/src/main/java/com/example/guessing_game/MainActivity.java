package com.example.guessing_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText input_text;
    private Button button;
    private TextView r_text,w_text,l_text;
    int w = 0,l = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_text = (EditText)findViewById(R.id.input);
        button = (Button)findViewById(R.id.check);
        r_text = (TextView)findViewById(R.id.r_text);
        w_text = (TextView)findViewById(R.id.w_text);
        l_text = (TextView)findViewById(R.id.l_text);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try
        {
            String te = input_text.getText().toString();
            int number = Integer.parseInt(te);
            input_text.setText("");
            Random r = new Random();
            int random = r.nextInt(10)+1;

            if(number==random)
            {
                r_text.setText("wow..! You win,,Fawzia also loves Nahid");
                w++;
                w_text.setText("Win = "+w);
            }
            else
            {
                r_text.setText("Sorry..! You lose,,Actual number is = "+random+". So Fawzia just like Nahid");
                l++;
                l_text.setText("Lose = "+l);
            }
        }catch (Exception e)
        {
            Toast.makeText(MainActivity.this,"Enter a number",Toast.LENGTH_SHORT).show();
        }
    }
}
