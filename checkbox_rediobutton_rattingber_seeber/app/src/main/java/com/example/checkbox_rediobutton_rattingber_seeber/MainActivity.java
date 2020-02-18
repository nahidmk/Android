package com.example.checkbox_rediobutton_rattingber_seeber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private CheckBox c1,c2;
   private TextView t1,t2,t3,t4;
   private Button b1,b2;
   private RadioGroup group;
   private RadioButton r1,r2;
   private RatingBar rating;
   private SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //checkBoxe
        c1 = findViewById(R.id.milkid);
        c2 = findViewById(R.id.waterid);
        t1 = findViewById(R.id.text1);
        //Radiobox
        group = findViewById(R.id.r_group);
        r1 = findViewById(R.id.male);
        //Ratingber
        rating = findViewById(R.id.rating);
        t3 = findViewById(R.id.text3);
        //Seekbar
        seekBar = findViewById(R.id.seekbar);
        t4 = findViewById(R.id.text4);

        //Checkbox
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder();
                if(c1.isChecked())
                {
                    String value = c1.getText().toString();
                    stringBuilder.append(value + "is orderd");

                }
                if(c2.isChecked())
                {
                    String value = c2.getText().toString();
                    stringBuilder.append(value + "is orderd");

                }
                t1.setText(stringBuilder);
            }
        });
        //RadioButton
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = group.getCheckedRadioButtonId();
                r1 = findViewById(id);
                String value = r1.getText().toString();
                t2.setText("you have clicked "+ value);
            }
        });
        //RatingBer
        t3.setText("Rating = "+rating.getProgress());
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                t3.setText("rating = "+v);
            }
        });
        //SeekBer


        t4.setText("progress = "+seekBar.getProgress()+"/"+seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                t4.setText("progress = "+i+"/"+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"Start",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"Stop",Toast.LENGTH_LONG).show();
            }
        });
    }

}
