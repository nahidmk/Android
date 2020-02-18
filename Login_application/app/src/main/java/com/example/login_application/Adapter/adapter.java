package com.example.login_application.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login_application.Module.info;
import com.example.login_application.R;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.viewHolder> {

    ArrayList<info>list;
    Context context;

    public adapter(ArrayList<info> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter,null);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        info in = this.list.get(position);
        holder.name.setText("Name : "+in.getName());
        holder.deposite.setText("Deposite : "+in.getDeposite());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
     TextView name, deposite;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_adapter_view);
            deposite = itemView.findViewById(R.id.deposite_adapter_view);
        }
    }
}
