package com.yinyxn.tabtest2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class NextActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    TAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        toolbar = (Toolbar) findViewById(R.id.nexttoolbar);
        tabLayout = (TabLayout) findViewById(R.id.nexttabLayout);
        viewPager = (ViewPager) findViewById(R.id.nextviewPager);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        adapter = new TAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu__item2, menu);
        menu.setGroupVisible(R.menu.menu__item2, false);
        menu.setGroupEnabled(R.menu.menu__item2,false);
        return false;
    }
}
