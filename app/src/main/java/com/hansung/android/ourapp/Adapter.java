package com.hansung.android.ourapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kwanwoo on 2016-09-05.
 */
 class MyAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<MyItem> data;
    private int layout;

    public MyAdapter(Context context, int layout, ArrayList<MyItem> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);;
        this.data = data;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getTextItem1();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = inflater.inflate(layout, parent,false);
        }
        MyItem myItem = data.get(position);

        // Set Icon
        ImageView imageicon1 = (ImageView) convertView.findViewById(R.id.imageItem1);
        imageicon1.setImageResource(myItem.getImageItem1());

        // Set Text 01
        TextView texticon1 = (TextView) convertView.findViewById(R.id.textItem1);
        texticon1.setText(myItem.getTextItem1());

        // Set Text 02
        TextView texticon2 = (TextView) convertView.findViewById(R.id.textItem2);
        texticon2.setText(myItem.getTextItem2());

        return convertView;
    }
}

 class MyItem {
   private int imageitem1; // 메뉴사진
   private String textitem1; // 메뉴이름
   private String textitem2;  // 메뉴가격

    public int getImageItem1(){
        return imageitem1;
    }

    public String getTextItem1(){
        return textitem1;
    }

    public String getTextItem2(){
        return textitem2;
    }

    public MyItem(int imageitem1, String textitem1, String textitem2) {
        this.imageitem1 = imageitem1;
        this.textitem1 = textitem1;
        this.textitem2 = textitem2;

    }

    }
