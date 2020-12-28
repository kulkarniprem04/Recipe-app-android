package com.example.recipeappandroid.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recipeappandroid.R;
import com.example.recipeappandroid.searchActivity;


public class LandingFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_landing, container, false);

        searchActivity activity = (searchActivity) getActivity();
        String name = activity.getUserName();
        Log.d("USERNAME",name);

        TextView username = (TextView) view.findViewById(R.id.welcometext);
        username.setText("Welcome " + name);

        return view;
    }
}