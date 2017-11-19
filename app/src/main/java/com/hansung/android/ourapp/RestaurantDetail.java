package com.hansung.android.ourapp;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RestaurantDetail extends AppCompatActivity {
    static MyAdapter adapter;
    private DBHelper mDbHelper;

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        ActionBar actionBar = getSupportActionBar();

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(UserContract.Users.KEY_NAME);


//        ArrayList<MyItem> data = new ArrayList<MyItem>();
//        data.add(new MyItem(R.drawable.capture1, "설렁탕", "7000"));
//        data.add(new MyItem(R.drawable.capture2, "순사골국", "8000"));
//        data.add(new MyItem(R.drawable.capture3, "떡국설렁탕", "7500"));
//        data.add(new MyItem(R.drawable.capture4, "만두설렁탕", "8000"));
//
//        adapter = new MyAdapter(this, R.layout.listview_item, data);
//
//        ListView listView = (ListView)findViewById(R.id.listView);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View vClicked,
//                                    int position, long id) {
//                //   String name = (String) ((TextView)vClicked.findViewById(R.id.textItem1)).getText();
//                String name = ((MyItem)adapter.getItem(position)).nName;
//                Toast.makeText(RestaurantDetail.this, name + " selected",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        Button btn = (Button)findViewById(R.id.call);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent implicit_intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-744-8533"));
//                startActivity(implicit_intent);
//            }
//        });


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_subactivity:
                startActivity(new Intent(this, MenuRegistration.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}