package com.kosta.ebiblioteka.HelperClasses.HomeAdapter;

public class MostViewedHelperClass {


    int mv_image;
    String mv_title,mv_desc;

    public MostViewedHelperClass(int mv_image, String mv_title, String mv_desc) {
        this.mv_image = mv_image;
        this.mv_title = mv_title;
        this.mv_desc = mv_desc;
    }


    public int getMv_image() {
        return mv_image;
    }

    public String getMv_title() {
        return mv_title;
    }

    public String getMv_desc() {
        return mv_desc;
    }
}
