package com.example.recipeappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.recipeappandroid.Adapter.CustomListAdapter;
import com.example.recipeappandroid.Fragments.SearchFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_CALORIES;
import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_CARBSQT;
import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_CHOLEQT;
import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_DATA;
import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_ENERGYQT;
import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_FATQT;
import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_FIBERQT;
import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_INGREDIENTS;
import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_PROTEINQT;
import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_RECIPEURL;
import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_SUGARQT;
import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_TIME;
import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_TITLE;
import static com.example.recipeappandroid.Fragments.SearchFragment.EXTRA_URL;

public class RecipeActivity extends AppCompatActivity {

    ListView listView;
    //ArrayAdapter IngredientAdapter;
    //String Ingredients[];
    CustomListAdapter IngredientAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String recipeTitle = intent.getStringExtra(EXTRA_TITLE);
        String recipeUrl = intent.getStringExtra(EXTRA_RECIPEURL);
        Double calories = intent.getDoubleExtra(EXTRA_CALORIES,0);
        int totalTime = intent.getIntExtra(EXTRA_TIME,60);
        //String energy = intent.getStringExtra(EXTRA_ENERGY);
        Double energyQt = intent.getDoubleExtra(EXTRA_ENERGYQT,0);
        Double fatqt = intent.getDoubleExtra(EXTRA_FATQT,0);
        Double carbsqt = intent.getDoubleExtra(EXTRA_CARBSQT,0);
        Double fiberqt = intent.getDoubleExtra(EXTRA_FIBERQT,0);
        Double sugarqt = intent.getDoubleExtra(EXTRA_SUGARQT,0);
        Double proteinqt = intent.getDoubleExtra(EXTRA_PROTEINQT,0);
        Double choleqt = intent.getDoubleExtra(EXTRA_CHOLEQT,0);


        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView RecipeTitle = findViewById(R.id.recipe_name_detail);
        //TextView RecipeData = findViewById(R.id.recipe_data_detail);
        TextView Calories = findViewById(R.id.calories);
        TextView TotalTime = findViewById(R.id.minutes);
        TextView Energy = findViewById(R.id.energy);
        TextView Fat = findViewById(R.id.fat);
        TextView Carbs = findViewById(R.id.carbs);
        TextView Fiber = findViewById(R.id.fiber);
        TextView Sugar = findViewById(R.id.sugar);
        TextView Protein = findViewById(R.id.protein);
        TextView Cholesterol = findViewById(R.id.cholesterol);
        Button back = findViewById(R.id.backbutton);
        Button RecipeUrl = findViewById(R.id.recipeurl);
        listView = findViewById(R.id.ingredients_list);

        Picasso.get().load(imageUrl).fit().centerCrop().into(imageView);
        RecipeTitle.setText(recipeTitle);
        Calories.setText("Calories:-"+ calories);
        TotalTime.setText("In:-" + totalTime + "mins.");
        Energy.setText("Energy:-" + energyQt + " Kcal");
        Fat.setText("Fat:-" + fatqt + " g");
        Carbs.setText("Carbs:-" + carbsqt + " g");
        Fiber.setText("Fiber:-" + fiberqt + " g");
        Sugar.setText("Sugar:-" + sugarqt + " g");
        Protein.setText("Protein:-" + proteinqt + " g");
        Cholesterol.setText("Choleserol:-" + choleqt + " mg");
        //RecipeData.setText(recipeData);

        //IngredientAdapter = new ArrayAdapter<>(RecipeActivity.this, R.layout.ingredient, intent.getStringArrayExtra(EXTRA_INGREDIENTS));
        //listView.setAdapter(IngredientAdapter);
        IngredientAdapter = new CustomListAdapter(RecipeActivity.this,R.layout.ingredient,intent.getStringArrayListExtra(EXTRA_INGREDIENTS));
        listView.setAdapter(IngredientAdapter);

        RecipeUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_VIEW);
                intent1.addCategory(Intent.CATEGORY_BROWSABLE);
                intent1.setData(Uri.parse(recipeUrl));
                startActivity(intent1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchFragment();
            }
        });

    }

    public void openSearchFragment() {
        Intent intent = new Intent(this, SearchFragment.class);
        startActivity(intent);
    }
}