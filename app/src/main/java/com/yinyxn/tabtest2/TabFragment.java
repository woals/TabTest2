package com.yinyxn.tabtest2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by yinyxn on 2016/1/11.
 */
public class TabFragment extends Fragment {
    private static final String EXTRA_CONTENT = "content";
    private ListView listView;

    private ArrayList<String> data = new ArrayList<>();
    public static Fragment newInstance(ArrayList<String> data) {
        TabFragment fragment = new TabFragment();

        Bundle args = new Bundle();
        args.putStringArrayList(EXTRA_CONTENT,data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            data = getArguments().getStringArrayList(EXTRA_CONTENT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment, container, false);
        listView = (ListView) v.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_activated_1,
                data);
        listView.setAdapter(adapter);
        return v;
    }
}
