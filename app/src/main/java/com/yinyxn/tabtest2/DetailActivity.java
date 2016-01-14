package com.yinyxn.tabtest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {

    HashMap<String,String> map = new HashMap<>();
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView = (TextView) findViewById(R.id.textView);

        map.put("科技2", "这是自定科技");
        map.put("星球2", "这是自定星球");
        map.put("娱乐2", "这是自定娱乐");

        String name = getIntent().getStringExtra(App.EXTRA_NAME);
        Log.d("name:::",name.toString());

//        textView.setText(name);
        if (map.containsKey(name)){
            String founder = map.get(name);
            textView.setText("详细信息："+founder);
        }

    }
}
