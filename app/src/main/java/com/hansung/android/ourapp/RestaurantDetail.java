package com.hansung.android.ourapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RestaurantDetail extends AppCompatActivity {
    static MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        ArrayList<MyItem> data = new ArrayList<MyItem>();
        data.add(new MyItem(R.drawable.capture1, "설렁탕", "7000"));
        data.add(new MyItem(R.drawable.capture2, "순사골국", "8000"));
        data.add(new MyItem(R.drawable.capture3, "떡국설렁탕", "7500"));
        data.add(new MyItem(R.drawable.capture4, "만두설렁탕", "8000"));

        adapter = new MyAdapter(this, R.layout.listview_item, data);

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View vClicked,
                                    int position, long id) {
                //   String name = (String) ((TextView)vClicked.findViewById(R.id.textItem1)).getText();
                String name = ((MyItem)adapter.getItem(position)).nName;
                Toast.makeText(RestaurantDetail.this, name + " selected",
                        Toast.LENGTH_SHORT).show();
            }
        });



    }
}
