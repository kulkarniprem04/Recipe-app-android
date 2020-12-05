package com.example.recipeappandroid.Model;

public class Recipe {
    private String img;
    private String title;
    private String data;

    public Recipe(String imgurl, String img_title, String img_data) {
        img = imgurl;
        title = img_title;
        data = img_data;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
