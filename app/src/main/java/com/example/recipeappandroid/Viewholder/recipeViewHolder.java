package com.example.recipeappandroid.Viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeappandroid.Adapter.RecipeAdapter;
import com.example.recipeappandroid.R;

public class recipeViewHolder extends RecyclerView.ViewHolder {
    public static ImageView image;
    public static TextView recipe_title;
    public static TextView recipe_data;
    public static CardView card;


    public recipeViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.recipe_img);
        recipe_title = itemView.findViewById(R.id.recipe_title);
        recipe_data = itemView.findViewById(R.id.recipe_data);
        card = itemView.findViewById(R.id.recipe_card);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RecipeAdapter.mListener!= null) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        RecipeAdapter.mListener.onItemClick(position);
                    }
                }
            }
        });

        /*itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RecipeAdapter.mListener!= null) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        RecipeAdapter.mListener.onItemClick(position);
                    }
                }
            }
        });*/
    }
}
