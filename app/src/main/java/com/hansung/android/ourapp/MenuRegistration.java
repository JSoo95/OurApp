package com.hansung.android.ourapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuRegistration extends AppCompatActivity {

    EditText mName;
    EditText mAdress;
    EditText mNumber;

    private DBHelper meDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_registration);


        mName = (EditText)findViewById(R.id.medit_name);
        mAdress = (EditText)findViewById(R.id.medit_call);
        mNumber = (EditText)findViewById(R.id.medit_explain);
        meDbHelper = new DBHelper(this);

        Button btn1 = (Button)findViewById(R.id.mrgt);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertRecord();

                Intent intent = new Intent(MenuRegistration.this, RestaurantDetail.class);
                startActivity(intent);
            }
        });

        ImageButton btn = (ImageButton)findViewById(R.id.miconItem);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });
    }
    String mePhotoFileName;
    File mePhotoFile;

    final int REQUEST_IMAGE_CAPTURE = 200;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            //1. 카메라 앱으로 찍은 이미지를 저장할 파일 객체 생성
            mePhotoFileName = "IMG"+currentDateFormat()+".jpg";
            mePhotoFile = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), mePhotoFileName);

            if (mePhotoFile !=null) {
                //2. 생성된 파일 객체에 대한 Uri 객체를 얻기
                Uri mimageUri = FileProvider.getUriForFile(this, "com.hansung.android.ourapp", mePhotoFile);

                //3. Uri 객체를 Extras를 통해 카메라 앱으로 전달
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,mimageUri);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            } else
                Toast.makeText(getApplicationContext(), "file null", Toast.LENGTH_SHORT).show();
        }
    }
    private String currentDateFormat(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
        String  currentTimeStamp = dateFormat.format(new Date());
        return currentTimeStamp;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            if (mePhotoFileName != null) {
                mePhotoFile = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), mePhotoFileName);

                ImageButton imageView = (ImageButton)findViewById(R.id.miconItem);
                imageView.setImageURI(Uri.fromFile(mePhotoFile));
                //mAdapter.addItem(new MediaItem(MediaItem.SDCARD, mPhotoFileName, Uri.fromFile(mPhotoFile), MediaItem.IMAGE));
            }
        }
    }
    long nOfRows;
    private void insertRecord() {
        EditText name = (EditText)findViewById(R.id.medit_name);
        EditText call = (EditText)findViewById(R.id.medit_call);
        EditText explain = (EditText)findViewById(R.id.medit_explain);

        long nOfRows = meDbHelper.insertUserByMethod(name.getText().toString(),call.getText().toString(),explain.getText().toString(),mePhotoFileName);
        if (nOfRows >0)
            Toast.makeText(this,nOfRows+" Record Inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"No Record Inserted", Toast.LENGTH_SHORT).show();
    }

}
