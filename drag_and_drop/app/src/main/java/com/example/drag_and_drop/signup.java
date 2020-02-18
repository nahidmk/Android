package com.example.drag_and_drop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        if(bundle !=null)
        {
            String te = bundle.getString("1");
            String te2 = bundle.getString("2");
            textView.setText(te+"\n"+te2);
        }

    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(signup.this);
        builder.setTitle("Hello i am signup");
        builder.setMessage("do you want to signup");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(signup.this,"do you",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setCancelable(false);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
