package com.example.recipeappandroid.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.recipeappandroid.Adapter.RecipeAdapter;
import com.example.recipeappandroid.Model.Recipe;
import com.example.recipeappandroid.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    Button click;
    //public static TextView fetchedText;
    ImageView searching_logo;
    TextView searching_text;
    SearchView searchbar;
    String query="";
    RecyclerView recyclerView;
    public static ArrayList<Recipe> recipeList;
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
                String url = "https://api.edamam.com/search?q=" + query + "&app_id=" + Api_id + "&app_key=" + Api_key;
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
                                Log.d("LABEL",recipe_title);
                                recipeList.add(new Recipe(recipe_img,recipe_title,recipe_data));
                            }
                            recipeAdapter = new RecipeAdapter(getContext(),recipeList);
                            recyclerView.setAdapter(recipeAdapter);
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
                /*JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                JSONObject recipes = jsonObject.getJSONObject("recipe");
                                //Recipe recipe = new Recipe();
                                String recipe_img = recipes.getString("image");
                                String recipe_title = recipes.getString("label");
                                String recipe_data =  recipes.getString("source");
                                recipeList.add(new Recipe(recipe_img,recipe_title,recipe_data));
                                Log.d("data",recipe_title);
                            }
                            //recipeAdapter = new RecipeAdapter(getContext(), recipeList);
                            //recyclerView.setAdapter(recipeAdapter);
                            recipeAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(SearchFragment.this,"Error Occured",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                });*/

                /*jsonArrayRequest.setRetryPolicy(new RetryPolicy() {
                    @Override
                    public int getCurrentTimeout() {
                        return 3000;
                    }

                    @Override
                    public int getCurrentRetryCount() {
                        return 3000;
                    }

                    @Override
                    public void retry(VolleyError error) throws VolleyError {

                    }
                });*/

               /* Log.d("QUEEEERRRYYYY",query);
                ApiCall process = new ApiCall(searching_logo,searching_text);
                process.execute(query);*/


            }
        });
        return view;

    }

}






