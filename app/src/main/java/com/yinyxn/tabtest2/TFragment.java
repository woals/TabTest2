package com.yinyxn.tabtest2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by yinyxn on 2016/1/11.
 */
public class TFragment extends Fragment{


    private ListView listView;
    private ArrayList<String> data = new ArrayList<>();
    private static final String EXTRA_CONTENT = "content";

    public static TFragment newInstance(ArrayList<String> data) {
        TFragment fragment = new TFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(EXTRA_CONTENT,data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            data = getArguments().getStringArrayList(EXTRA_CONTENT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_fragment,container,false);
        listView = (ListView) v.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_activated_1,
                data
        );
        listView.setAdapter(adapter);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                menu.setGroupVisible(R.menu.menu__item2,true);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                if(R.id.action_edit == item.getItemId()){

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_EDIT);

                    intent.setType("text/*");//所有文本类型

                    startActivity(intent);

                    mode.finish();
                    return  true;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent();
//                intent.setAction(App.ACTION_DETAIL);//ctrl+q  可以看到详细信息
//
//                Log.d("意图中的数据:", data.toString());
//                intent.putExtra(App.EXTRA_NAME, data.get(position));
//                startActivity(intent);
//            }
//        });


        return v;
    }


    private class MultListener implements AbsListView.MultiChoiceModeListener {
        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {


        }


        //长按加载这个菜单
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {

//            onCreateOptionsMenu(menu, inflater);
//            inflater.inflate(R.menu.menu__item2,menu);

            menu.setGroupVisible(R.menu.menu__item2,true);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            if(R.id.action_edit == item.getItemId()){

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_EDIT);

                intent.setType("text/*");//所有文本类型

                startActivity(intent);

                mode.finish();
                return  true;
            }

            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    }
}
