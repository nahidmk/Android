package com.example.my_fagment.Fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.my_fagment.Adapter.UserInfoAdapter;
import com.example.my_fagment.Constant.constant;
import com.example.my_fagment.Module.info;
import com.example.my_fagment.R;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class User_list extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<info> list ;
    private ProgressDialog progressDialog;
    public User_list() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycle_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //recyclerView.setAdapter(new UserInfoAdapter(list,getActivity()));
    }

    @Override
    public void onResume() {
        super.onResume();
        new communication().execute();
    }

    class communication extends AsyncTask<Void,Void,JSONArray>
    {
        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("please wait....");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected JSONArray doInBackground(Void... voids) {
            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(constant.EMPLOYEE_LIST).build();
                Response response = client.newCall(request).execute();
                if (response.isSuccessful())
                {
                    return new JSONArray(response.body().string());
                }

            }catch (Exception e)
            {
                Toast.makeText(getActivity(),"Exception : "+e,Toast.LENGTH_LONG).show();
            }
            return null;
        }


        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            progressDialog.dismiss();
            list = new ArrayList<>();
            //info in = new info();
            try {
                if (jsonArray!=null)
                {
                    for (int i = 0;i<jsonArray.length();i++)
                    {
                        info in = new info();
                       JSONObject jsonObject = jsonArray.getJSONObject(i);
                        in.setId(Integer.parseInt(jsonObject.getString("id")));
                        in.setAge(jsonObject.getString("employee_age"));
                        in.setName(jsonObject.getString("employee_name"));
                        in.setProfilePicture(jsonObject.getString("profile_image"));
                        in.setSalary(jsonObject.getString("employee_salary"));
                       list.add(in);
                    }

                    recyclerView.setAdapter(new UserInfoAdapter(list,getActivity()));

                }else
                {
                    Toast.makeText(getActivity(),"response is null",Toast.LENGTH_LONG).show();
                }
            }catch (Exception e)
            {
                Toast.makeText(getActivity(),"Exception : "+e,Toast.LENGTH_LONG).show();
            }
        }
    }



}


