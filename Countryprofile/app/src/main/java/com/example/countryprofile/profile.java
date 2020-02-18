package com.example.countryprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class profile extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imageView = findViewById(R.id.imageviewid);
        textView = findViewById(R.id.textviewid);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            String countryname = bundle.getString("name");
            showname(countryname);
        }
    }
    void showname(String name)
    {
        if(name.equals("bangladesh"))
        {
            imageView.setImageResource(R.drawable.b);
            textView.setText(R.string.bangladesh);
        }
        if(name.equals("pakistan"))
        {
            imageView.setImageResource(R.drawable.p);
            textView.setText(R.string.pakistan);
        }
        if(name.equals("bangladesh"))
        {
            imageView.setImageResource(R.drawable.n);
            textView.setText(R.string.nepal);
        }
    }
}
