package com.example.countryprofile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button b,p,n;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.bangladeshid);
        p  = findViewById(R.id.pakistanid);
        n = findViewById(R.id.nepalid);

        b.setOnClickListener(this);
        p.setOnClickListener(this);
        n.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.bangladeshid)
        {
            intent = new Intent(MainActivity.this,profile.class);
            intent.putExtra("name","bangladesh");
            startActivity(intent);
        }
        if(view.getId()==R.id.pakistanid)
        {
            intent = new Intent(MainActivity.this,profile.class);
            intent.putExtra("name","pakistan");
            startActivity(intent);
        }
        if(view.getId()==R.id.nepalid)
        {
            intent = new Intent(MainActivity.this,profile.class);
            intent.putExtra("name","nepal");
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cancelation alert");
        builder.setMessage("Do you want to exit..?");
        builder.setCancelable(false);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
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
    }
}
