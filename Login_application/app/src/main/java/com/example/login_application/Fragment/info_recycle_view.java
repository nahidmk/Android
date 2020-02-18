package com.example.login_application.Fragment;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.login_application.Adapter.adapter;
import com.example.login_application.Module.info;
import com.example.login_application.R;
import com.example.login_application.database.db_connection;

import java.util.ArrayList;


public class info_recycle_view extends Fragment {

    ArrayList<info>list;
    RecyclerView recyclerView;

    public info_recycle_view() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_recycle_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        recyclerView = view.findViewById(R.id.recyle_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setAdapter(new adapter(list,getActivity()));
    }

    public void initialize()
    {
        list = new ArrayList<>();

            db_connection db = new db_connection(getActivity());
            Cursor information_of_name,information_of_diposite;
            information_of_name = db.information_name();
            information_of_diposite = db.information_deposite();
            int v = information_of_name.getCount();
        Toast.makeText(getActivity(),v+"",Toast.LENGTH_LONG).show();

        try {
            if(information_of_name.getCount()!=0&& information_of_diposite.getCount()!=0)
            {
                Toast.makeText(getActivity(),"Total member : "+v,Toast.LENGTH_LONG).show();
                while (information_of_name.moveToNext()&&information_of_diposite.moveToNext())
                {
                    list.add(new info(information_of_name.getString(1),information_of_diposite.getInt(1)));
                }
            }else
            {
                Toast.makeText(getActivity(),"Database is empty",Toast.LENGTH_LONG).show();
            }
        }catch (Exception e)
        {
            Toast.makeText(getActivity(),"problem : "+e+"",Toast.LENGTH_LONG).show();
        }


    }
}
