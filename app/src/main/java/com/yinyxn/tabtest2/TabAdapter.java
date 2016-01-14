package com.yinyxn.tabtest2;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by yinyxn on 2016/1/11.
 */
public class TabAdapter extends FragmentPagerAdapter{

    private String[] tabs = {"科技","星球","娱乐"};
    private ArrayList<Fragment> fragments;

    public TabAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        fragments = new ArrayList<>();
        for (String tab:tabs){
            ArrayList<String> data = new ArrayList<>();
            for(int i = 0;i<5;i++){
                data.add(tab+" "+i);
            }
            fragments.add(TabFragment.newInstance(data));
        }
        
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
