package com.example.recipeappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_DATA;
import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_TITLE;
import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_URL;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String recipeTitle = intent.getStringExtra(EXTRA_TITLE);
        String recipeData = intent.getStringExtra(EXTRA_DATA);

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView RecipeTitle = findViewById(R.id.recipe_name_detail);
        TextView RecipeData = findViewById(R.id.recipe_data_detail);

        Picasso.get().load(imageUrl).fit().centerCrop().into(imageView);
        RecipeTitle.setText(recipeTitle);
        RecipeData.setText(recipeData);

    }
}