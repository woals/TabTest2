package com.yinyxn.tabtest2;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by yinyxn on 2016/1/11.
 */
public class TAdapter extends FragmentPagerAdapter {


    ArrayList<Fragment> fragments;
    private String[] tabs = {"科技","星球","娱乐"};
    public TAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);

        fragments = new ArrayList<>();
        for(String tab:tabs){
            ArrayList<String> data = new ArrayList<>();
            for(int i=0;i<5;i++){
                data.add(tab+i);
            }


            Log.d("TAdapter中data的数据：",data.toString());
            fragments.add(TFragment.newInstance(data));
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
