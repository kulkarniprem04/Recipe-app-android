package com.example.recipeappandroid.Model;

import java.util.ArrayList;

public class Recipe {
    private String img;
    private String title;
    private String data;
    private String RecipeUrl;
    private Double Calories;
    private int totalTime;
    private Double energyQt;
    private Double Fatqt;
    private Double CarbsQt;
    private Double FiberQt;
    private Double SugarQT;
    private Double ProteinQt;
    private Double CholeQt;
    ArrayList<String> Ingredients;

    public Recipe(String imgurl, String img_title, String img_data, String recipeUrl, Double calories, int totalTime, Double energyQt, Double fatqt, Double carbsQt, Double fiberQt, Double sugarQT, Double proteinQt, Double choleQt, ArrayList<String> ingredients) {
        img = imgurl;
        title = img_title;
        data = img_data;
        RecipeUrl = recipeUrl;
        Calories = calories;
        this.totalTime = totalTime;
        this.energyQt = energyQt;
        Fatqt = fatqt;
        CarbsQt = carbsQt;
        FiberQt = fiberQt;
        SugarQT = sugarQT;
        ProteinQt = proteinQt;
        CholeQt = choleQt;
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

    public Double getCalories() {
        return Calories;
    }


    public Double getFatqt() {
        return Fatqt;
    }

    public void setFatqt(Double fatqt) {
        Fatqt = fatqt;
    }

    public Double getCarbsQt() {
        return CarbsQt;
    }

    public void setCarbsQt(Double carbsQt) {
        CarbsQt = carbsQt;
    }

    public Double getFiberQt() {
        return FiberQt;
    }

    public void setFiberQt(Double fiberQt) {
        FiberQt = fiberQt;
    }

    public Double getSugarQT() {
        return SugarQT;
    }

    public void setSugarQT(Double sugarQT) {
        SugarQT = sugarQT;
    }

    public Double getProteinQt() {
        return ProteinQt;
    }

    public void setProteinQt(Double proteinQt) {
        ProteinQt = proteinQt;
    }

    public Double getCholeQt() {
        return CholeQt;
    }

    public void setCholeQt(Double choleQt) {
        CholeQt = choleQt;
    }

    public Double getEnergyQt() {
        return energyQt;
    }

    public void setEnergyQt(Double energyQt) {
        this.energyQt = energyQt;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public void setCalories(Double calories) {
        Calories = calories;
    }

    public String getRecipeUrl() {
        return RecipeUrl;
    }

    public void setRecipeUrl(String recipeUrl) {
        RecipeUrl = recipeUrl;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
