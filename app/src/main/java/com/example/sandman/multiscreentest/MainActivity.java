package com.example.sandman.multiscreentest;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

//        TextView colors = (TextView) findViewById(R.id.colors);
//        TextView prases = (TextView) findViewById(R.id.phrases);
//
//        colors.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, ColorsActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        prases.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent intent =new Intent(MainActivity.this, PrasesActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    public void OpenNumbersActivity(View view){
//        Intent intent =new Intent(this,NumbersActivity.class);
//        startActivity(intent);
//    }
//    public void openFamilActivity(View view){
//        Intent intent=new Intent(this,FamilyActivity.class);
//        startActivity(intent);
//    }
    }

}
