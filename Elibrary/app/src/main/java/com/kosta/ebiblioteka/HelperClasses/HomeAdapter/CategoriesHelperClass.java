package com.kosta.ebiblioteka.HelperClasses.HomeAdapter;

import android.graphics.drawable.GradientDrawable;

public class CategoriesHelperClass {

    int categories_image;
    GradientDrawable categories_gradient;
    String  categories_title;

    public CategoriesHelperClass(int categories_image, GradientDrawable categories_gradient, String categories_title) {
        this.categories_image = categories_image;
        this.categories_gradient = categories_gradient;
        this.categories_title = categories_title;
    }




    public int getCategories_image() {
        return categories_image;
    }

    public GradientDrawable getCategories_gradient() {
        return categories_gradient;
    }

    public String getCategories_title() {
        return categories_title;
    }
}
