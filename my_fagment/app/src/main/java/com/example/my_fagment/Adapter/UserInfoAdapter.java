package com.example.my_fagment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_fagment.Module.info;
import com.example.my_fagment.R;

import java.util.ArrayList;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.viewHolder> {

    ArrayList<info> list;
    Context context;

    public UserInfoAdapter(ArrayList<info> list, Context context) {
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
        holder.Address.setText("Age : "+in.getAge());
        holder.Id.setText("Salary : "+in.getSalary());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class viewHolder extends RecyclerView.ViewHolder {
        TextView name, Id, Address;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Name);
            Id = itemView.findViewById(R.id.Id);
            Address = itemView.findViewById(R.id.Address);
        }
    }
}
