package com.example.recipeappandroid.Model;

import java.util.ArrayList;

public class Recipe {
    private String img;
    private String title;
    private String data;
    ArrayList<String> Ingredients;

    public Recipe(String imgurl, String img_title, String img_data, ArrayList<String> ingredients) {
        img = imgurl;
        title = img_title;
        data = img_data;
        Ingredients = ingredients;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getIngredients() {
        return Ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        Ingredients = ingredients;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
