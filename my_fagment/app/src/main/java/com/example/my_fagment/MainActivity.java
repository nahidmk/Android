package com.example.my_fagment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.my_fagment.Fragment.API;
import com.example.my_fagment.Fragment.User_list;
import com.example.my_fagment.Fragment.googleMap;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openFragment(new googleMap());

    }



    //Load fragment into main Frame
    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrame,fragment);
        transaction.commit();
    }

    // menu on the top_left
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_of_item,menu);
        return true;
    }



//Lestener for the menu bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.google_mapm:
                openFragment(new googleMap());
                return true;
            case R.id.apim:
                openFragment(new API());
                return true;
            case R.id.User_listm:
                openFragment(new User_list());
                return true;
                default:
                    return super.onOptionsItemSelected(item);


        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        bottomNavigationView = findViewById(R.id.nav_view);
        //Buttom Navigation
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.google_mapm:
                        openFragment(new googleMap());
                        return true;
                    case R.id.apim:
                        openFragment(new API());
                        return true;
                    case R.id.User_listm:
                        openFragment(new User_list());
                }

                return false;
            }
        });
    }


}

