package com.example.recipeappandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.recipeappandroid.Fragments.BookmarkFragment;
import com.example.recipeappandroid.Fragments.LandingFragment;
import com.example.recipeappandroid.Fragments.ProfileFragment;
import com.example.recipeappandroid.Fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class searchActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Fragment selectedFragment = null;
    private String UserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent intent = getIntent();
        UserName = intent.getStringExtra("Username");


        bottomNavigationView = findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new LandingFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_explore:
                        selectedFragment = new LandingFragment();
                        /*Bundle bundle = new Bundle();
                        bundle.putString("username",UserName);
                        selectedFragment.setArguments(bundle);*/
                        break;
                    case R.id.nav_search:
                        selectedFragment = new SearchFragment();
                        break;
                    case R.id.nav_bookmark:
                        selectedFragment =  new BookmarkFragment();
                        break;
                    case R.id.nav_profile:
                        selectedFragment = new ProfileFragment();
                        break;
                }
                if (selectedFragment!=null)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                }
                return true;

            }
        });

    }

    public String getUserName() {
        return UserName;
    }
}