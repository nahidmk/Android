package com.example.date_picker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView t1,t2;
    private Button bb1,bb2;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //DatePicker
        t1 = findViewById(R.id.te);
        bb1 = findViewById(R.id.b1);
        //Time Picker
        t2 = findViewById(R.id.te1);
        bb2 = findViewById(R.id.b2);

        bb1.setOnClickListener(this);
        bb2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //date picker
        if(view.getId()==R.id.b1)
        {
            DatePicker datePicker = new DatePicker(this);
            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth();
            int year = datePicker.getYear();
            datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    t1.setText(i2+"-"+(i1+1)+"-"+i);
                }
            },day,month,year);
            datePickerDialog.show();
        }
        //Time picker
        if(view.getId()==R.id.b2)
        {
            TimePicker timePicker = new TimePicker(this);
            int mi = timePicker.getCurrentMinute();
            int hour = timePicker.getCurrentHour();

            timePickerDialog = new TimePickerDialog(MainActivity.this,
                    new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    t2.setText(i+":"+i1);
                }
            },mi,hour,false);
            timePickerDialog.show();
        }

    }
}
