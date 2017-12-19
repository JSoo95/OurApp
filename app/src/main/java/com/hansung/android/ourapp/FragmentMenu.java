package com.hansung.android.ourapp;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentMenu extends Fragment {
    static int index=-1;

    String mimage;
    String mmenu;
    String mprice;
    String mgrade;

    public FragmentMenu(){

    }

    public void setSelection(int i) { index = i; }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_fragment_menu, container, false);
        ImageView image = (ImageView)view.findViewById(R.id.img);
        TextView menu = (TextView)view.findViewById(R.id.txt1);
        TextView price = (TextView)view.findViewById(R.id.txt2);
        TextView grade = (TextView)view.findViewById(R.id.txt3);
        //image.setImageResource(mimage);

        menu.setText(mmenu);
        price.setText(mprice);
        grade.setText(mgrade);

        if (index >=0) {
            String str1 = getArguments().getString("image");
            String str2 = getArguments().getString("menu");
            String str3 = getArguments().getString("price");
            String str4 = getArguments().getString("grade");
        }


        return view;
    }

}