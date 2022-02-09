package com.kosta.ebiblioteka.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.kosta.ebiblioteka.Common.LoginSignup.StartUpScreen;
import com.kosta.ebiblioteka.HelperClasses.HomeAdapter.CategoriesAdapter;
import com.kosta.ebiblioteka.HelperClasses.HomeAdapter.CategoriesHelperClass;
import com.kosta.ebiblioteka.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.kosta.ebiblioteka.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.kosta.ebiblioteka.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.kosta.ebiblioteka.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.kosta.ebiblioteka.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    ImageView menuIcon;


    //Meni na izvlacenje

    DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);


        //kuke

        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        menuIcon = findViewById(R.id.menu_icon);


        //kuke za meni

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);


        navigationDrawer();


        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();

    }

    //Navigaciona fioka funkcije
    private void navigationDrawer() {

        //Navigaciona fioka

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);

            }
        });


    }





    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_all_categories:
                startActivity(new Intent(getApplicationContext(), AllCategories.class));
                break;

        }

        return true;
    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedBooks = new ArrayList<>();
        mostViewedBooks.add(new MostViewedHelperClass(R.drawable.kletvenik_img, "Klevetnik", "Bugarska vojska je svom silinom napala srpske teritorije i tako se početkom X veka srpska kneževina suočila sa neizbežnim i jezivim porazom..."));
        mostViewedBooks.add(new MostViewedHelperClass(R.drawable.jedanhitac_img, "Jedan Hitac", "Šest hitaca. Petoro mrtvih. Teror je zavladao jednim provincijskim gradom. Ali policija je sve rešila u roku od nekoliko sati: sve je kristalno jasno i lako."));
        mostViewedBooks.add(new MostViewedHelperClass(R.drawable.austrijanka_img, "Austrijanka", "Kasno proleće 1942, gluvo doba noći. Na sporedni kolosek zagrebačke železničke stanice pristiže transport stočnih vagona krcat srpskim ženama. Odlaze na prisilni rad u Nemački Rajh."));
        ;

        adapter = new MostViewedAdapter(mostViewedBooks);
        mostViewedRecycler.setAdapter(adapter);
        navigationView.setCheckedItem(R.id.nav_home);

    }


    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredBooks = new ArrayList<>();

        featuredBooks.add(new FeaturedHelperClass(R.drawable.kletvenik_img, "Kletvenik", "Bugarska vojska je svom silinom napala srpske teritorije i tako se početkom X veka srpska kneževina suočila sa neizbežnim i jezivim porazom..."));
        featuredBooks.add(new FeaturedHelperClass(R.drawable.jedanhitac_img, "Jedan Hitac", "Šest hitaca. Petoro mrtvih. Teror je zavladao jednim provincijskim gradom. Ali policija je sve rešila u roku od nekoliko sati: sve je kristalno jasno i lako."));
        featuredBooks.add(new FeaturedHelperClass(R.drawable.austrijanka_img, "Austrijanka", "Kasno proleće 1942, gluvo doba noći. Na sporedni kolosek zagrebačke železničke stanice pristiže transport stočnih vagona krcat srpskim ženama. Odlaze na prisilni rad u Nemački Rajh."));

        adapter = new FeaturedAdapter(featuredBooks);
        featuredRecycler.setAdapter(adapter);


    }

    private void categoriesRecycler() {

        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.action_img, gradient1, "Akcioni"));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.history_img, gradient2, "Istorija"));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.love_img, gradient3, "Ljubavni"));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.drama_img, gradient4, "Drama"));


        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);


    }

    //Dugme za login

    public void callLoginScreens(View view) {

        startActivity(new Intent(getApplicationContext(), StartUpScreen.class));

    }


}