package com.example.recipeappandroid.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.recipeappandroid.Adapter.RecipeAdapter;
import com.example.recipeappandroid.Model.Recipe;
import com.example.recipeappandroid.R;
import com.example.recipeappandroid.RecipeActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SearchFragment extends Fragment implements RecipeAdapter.OnItemClickListener {

    public static final String EXTRA_URL = "ImageUrl";
    public static final String EXTRA_TITLE = "RecipeTitle";
    public static final String EXTRA_DATA = "RecipeData";
    public static final String EXTRA_INGREDIENTS = "RecipeIngredients";
    Button click;
    //public static TextView fetchedText;
    ImageView searching_logo;
    TextView searching_text;
    SearchView searchbar;
    String query="";
    RecyclerView recyclerView;
    public static ArrayList<Recipe> recipeList;
    ArrayList<String> Ingredients;

    public static RecipeAdapter recipeAdapter;
    public RequestQueue mRequestQueue;
    
    private String Api_id= "3f335994";
    private String Api_key = "8e99e327d1f2130dc6ab3422e26a95e8";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        click = (Button) view.findViewById(R.id.button1);
        //fetchedText = (TextView) view.findViewById(R.id.fetcheddata);
        searchbar = (SearchView) view.findViewById(R.id.searchbar);
        searching_logo = view.findViewById(R.id.searching_logo);
        searching_text = view.findViewById(R.id.searching_text);
        recyclerView = view.findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        //recipeAdapter = new RecipeAdapter();
        recipeList = new ArrayList<>();
        //getData();



        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query = searchbar.getQuery().toString();
                String url = "http://192.168.0.107:5000/" + query;
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        recipeList.clear();
                        try {
                            JSONArray hits = response.getJSONArray("hits");
                            for (int i =0;i<hits.length();i++) {
                                JSONObject jsonObject = hits.getJSONObject(i);
                                JSONObject recipe = jsonObject.getJSONObject("recipe");
                                String recipe_img = recipe.getString("image");
                                String recipe_title = recipe.getString("label");
                                String recipe_data =  recipe.getString("source");
                                JSONArray ingredients = recipe.getJSONArray("ingredientLines");
                                Ingredients = new ArrayList<String>();
                                for (int j=0;j<ingredients.length();j++) {
                                    String ingredient = ingredients.getString(j);
                                    Ingredients.add(ingredient);
                                    Log.d("INGREDIENTS",ingredient);
                                }
                                //RecipeActivity.listView.setAdapter(IngredientAdapter);

                                recipeList.add(new Recipe(recipe_img,recipe_title,recipe_data, Ingredients));
                            }
                            recipeAdapter = new RecipeAdapter(getContext(),recipeList);
                            recyclerView.setAdapter(recipeAdapter);
                            recipeAdapter.setOnItemClickListener(SearchFragment.this);
                            //recipeAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
                mRequestQueue = Volley.newRequestQueue(getContext());
                mRequestQueue.add(jsonObjectRequest);
            }
        });
        return view;

    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(getContext(), RecipeActivity.class);
        Recipe clickedItem = recipeList.get(position);
        Log.d("INTENT","INTENT OPENED");
        detailIntent.putExtra(EXTRA_URL,clickedItem.getImg());
        detailIntent.putExtra(EXTRA_TITLE,clickedItem.getTitle());
        //detailIntent.putExtra(EXTRA_DATA,clickedItem.getData());
        detailIntent.putExtra(EXTRA_INGREDIENTS,clickedItem.getIngredients());

        startActivity(detailIntent);
    }
}






