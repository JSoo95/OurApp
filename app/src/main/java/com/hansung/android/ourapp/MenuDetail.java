package com.hansung.android.ourapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MenuDetail extends AppCompatActivity {

    private int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        Intent intent = getIntent();

        ImageView imageitem1 = (ImageView)findViewById(R.id.img_menu);
        TextView textitem1 = (TextView)findViewById(R.id.txt_menu);
        TextView textitem2 = (TextView)findViewById(R.id.txt_menu2);

        img = Integer.parseInt(intent.getStringExtra("menu"));
        imageitem1.setImageResource(img);
        textitem1.setText(intent.getStringExtra("text1"));
        textitem2.setText(intent.getStringExtra("text2"));
    }




}
