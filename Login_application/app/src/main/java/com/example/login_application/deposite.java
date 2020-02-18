package com.example.login_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login_application.database.db_connection;

public class deposite extends AppCompatActivity implements View.OnClickListener {
    private EditText d_id, d_amount;
    private TextView d_total_diposite_of_this_id, d_total_deposit;
    private Button save_deposite_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposite);

        d_id = findViewById(R.id.D_ID);
        d_amount = findViewById(R.id.D_AMOUNT);

        d_total_deposit = findViewById(R.id.total_deposit);
        d_total_diposite_of_this_id = findViewById(R.id.total_deposit_of_ID);

        save_deposite_button = findViewById(R.id.save_deposite_data_button);
        save_deposite_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String id = d_id.getText().toString();
        String s = d_amount.getText().toString();
        int arr[] = new int[2];
        if(!id.isEmpty() && !s.isEmpty())
        {
            int amount = Integer.parseInt(s);

            db_connection db = new db_connection(this);
            arr = db.save_deposite_data(id,amount);
            d_total_diposite_of_this_id.setText("Total deposite of this id = "+arr[0]);
            d_total_deposit.setText("Total diposite = "+arr[1]);


        }else
        {
            Toast.makeText(deposite.this,"Complete this",Toast.LENGTH_LONG).show();
        }
        d_amount.setText("");

    }
}
