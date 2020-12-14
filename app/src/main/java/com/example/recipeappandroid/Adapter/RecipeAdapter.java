 package com.example.recipeappandroid.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeappandroid.Model.Recipe;
import com.example.recipeappandroid.R;
import com.example.recipeappandroid.Viewholder.recipeViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class RecipeAdapter extends RecyclerView.Adapter<recipeViewHolder>{
    private Context mContext;
    private ArrayList<Recipe> mRecipe;
    public static OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener = listener;
    }


    public RecipeAdapter(Context context,ArrayList<Recipe> recipe) {
        mContext = context;
        mRecipe = recipe;
    }

    /*public void setData(ArrayList<Recipe> mRecipe) {
        this.mRecipe = mRecipe;
    }*/

    @NonNull
    @Override
    public recipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_row, viewGroup, false);
        return new recipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recipeViewHolder viewHolder, int i) {
        Recipe recipe = mRecipe.get(i);
        Picasso.get().load(recipe.getImg()).into(viewHolder.image);
        viewHolder.recipe_title.setText(recipe.getTitle());
        viewHolder.recipe_data.setText(recipe.getData());
    }

    @Override
    public int getItemCount() {
        return mRecipe.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    }
