package com.kosta.ebiblioteka.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.transition.Slide;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kosta.ebiblioteka.HelperClasses.SliderAdapter;
import com.kosta.ebiblioteka.R;

import org.w3c.dom.Text;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;

    SliderAdapter sliderAdapter;
    TextView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        //kuke

        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);




        //zovi adapter

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);


    }

    private void addDots(int position){

        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for(int i=0; i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if(dots.length > 0 ){
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }


    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };



}