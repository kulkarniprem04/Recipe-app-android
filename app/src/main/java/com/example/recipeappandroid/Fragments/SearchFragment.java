package com.example.recipeappandroid.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.recipeappandroid.ApiCall;
import com.example.recipeappandroid.R;

public class SearchFragment extends Fragment {

    Button click;
    public static TextView fetchedText;
    EditText searchbar;
    String query="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        click = (Button) view.findViewById(R.id.button1);
        fetchedText = (TextView) view.findViewById(R.id.fetcheddata);
        searchbar = (EditText) view.findViewById(R.id.searchbar);



        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query = searchbar.getText().toString();
                Log.d("QUEEEERRRYYYY",query);
                ApiCall process = new ApiCall();
                process.execute(query);
            }
        });

        return view;
    }

}