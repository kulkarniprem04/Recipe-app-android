package com.example.recipeappandroid.Viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeappandroid.R;

public class recipeViewHolder extends RecyclerView.ViewHolder {
    public static ImageView image;
    public static TextView recipe_title;
    public static TextView recipe_data;


    public recipeViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.recipe_img);
        recipe_title = itemView.findViewById(R.id.recipe_title);
        recipe_data = itemView.findViewById(R.id.recipe_data);
    }
}