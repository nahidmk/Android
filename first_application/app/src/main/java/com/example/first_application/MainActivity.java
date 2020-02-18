package com.example.first_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text1;
    private Button bio1,stydy1,love1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bio1 = (Button)findViewById(R.id.bio);
        stydy1 = (Button)findViewById(R.id.study);
        love1  = (Button)findViewById(R.id.love);
        text1 = (TextView)findViewById(R.id.text);
        bio1.setOnClickListener(this);
        stydy1.setOnClickListener(this);
        love1.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.bio)
        {
            text1.setText("  Nahid was bron in 17th june,1998. He is the last family member of his family. He is 21 years old. He is a average person\n" +
                    "        like any other ordinary persion. He loves play Cricket. He is not good in study. He is 5 feet 6.5 inch long.\n" +
                    "        He is light black.He like bodybuilding.");
            Toast.makeText(MainActivity.this,"This is BIO",Toast.LENGTH_LONG).show();
        }
        if(view.getId()==R.id.study)
        {
            text1.setText("He is on the way of BSc in Computer Science & Engineering in SouthEast University. He had complete his " +
                    "HSC in 2016 from Hajigonj Degree Collage. He had complete his SSC from Gollak Nowav Ali High School in 2014");
            Toast.makeText(MainActivity.this,"This is STUDY",Toast.LENGTH_LONG).show();
        }
        if(view.getId()==R.id.love)
        {
            text1.setText("He had fall in love to a girl since when he read in class 5. The name of that girl " +
                    "is Fawzia. He loves her a lot. But Fawzia refused him for 4 times. Nahid Still love her.");
            Toast.makeText(MainActivity.this,"This is LOVE",Toast.LENGTH_LONG).show();

        }

    }
}

