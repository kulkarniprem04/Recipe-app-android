package com.example.recipeappandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.recipeappandroid.Fragments.BookmarkFragment;
import com.example.recipeappandroid.Fragments.LandingFragment;
import com.example.recipeappandroid.Fragments.ProfileFragment;
import com.example.recipeappandroid.Fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchActiviy();
            }
        });

    }

    public  void  openSearchActiviy() {
        Intent intent = new Intent(this, searchActivity.class);
        startActivity(intent);

    }
}
