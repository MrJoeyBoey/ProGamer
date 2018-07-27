package com.example.joey.progamer;

import android.content.Intent;
import android.graphics.Matrix;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class HeadIconChooseActivity extends AppCompatActivity implements View.OnClickListener {
    private int headIconId=1;

    private ImageView headIcon1,headIcon2, headIcon3, headIcon4, headIcon5, headIcon6;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar3,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent=new Intent(HeadIconChooseActivity.this,MyInfoActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.headIconSave:
                Acount acount=new Acount();
                acount.setHeadIconId(headIconId);
                acount.updateAll("userName=?",LoginActivity.username);

                Intent intent2=new Intent(HeadIconChooseActivity.this,MyInfoActivity.class);
                intent2.putExtra("更换头像",true);
                intent2.putExtra("HeadIconId",headIconId);
                startActivity(intent2);
                finish();

                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_icon_choose);

        android.support.v7.widget.Toolbar toolbar_headIconChoose=findViewById(R.id.toolbar_headIconChoose);
        toolbar_headIconChoose.setTitle("");
        setSupportActionBar(toolbar_headIconChoose);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.returnicon);
        }
         headIcon1=(ImageView)findViewById(R.id.headIcon1);
         headIcon2=(ImageView)findViewById(R.id.headIcon2);
         headIcon3=(ImageView)findViewById(R.id.headIcon3);
         headIcon4=(ImageView)findViewById(R.id.headIcon4);
         headIcon5=(ImageView)findViewById(R.id.headIcon5);
         headIcon6=(ImageView)findViewById(R.id.headIcon6);
         headIcon1.setOnClickListener(this);
         headIcon2.setOnClickListener(this);
         headIcon3.setOnClickListener(this);
         headIcon4.setOnClickListener(this);
         headIcon5.setOnClickListener(this);
         headIcon6.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
         Matrix matrix = new Matrix();
         Matrix matrix1=new Matrix();
         matrix.setTranslate(140, 110);
         matrix1.setTranslate(1000,1000);
        switch (view.getId()){
            case R.id.headIcon1:
                headIconId=1;
                headIcon1.setImageResource(R.mipmap.checkicon);
                headIcon1.setImageMatrix(matrix);

                headIcon2.setImageMatrix(matrix1);
                headIcon3.setImageMatrix(matrix1);
                headIcon4.setImageMatrix(matrix1);
                headIcon5.setImageMatrix(matrix1);
                headIcon6.setImageMatrix(matrix1);
                break;
            case R.id.headIcon2:
                headIconId=2;
                headIcon2.setImageResource(R.mipmap.checkicon);
                headIcon2.setImageMatrix(matrix);

                headIcon1.setImageMatrix(matrix1);
                headIcon3.setImageMatrix(matrix1);
                headIcon4.setImageMatrix(matrix1);
                headIcon5.setImageMatrix(matrix1);
                headIcon6.setImageMatrix(matrix1);
                break;
            case R.id.headIcon3:
                headIconId=3;
                headIcon3.setImageResource(R.mipmap.checkicon);
                headIcon3.setImageMatrix(matrix);

                headIcon1.setImageMatrix(matrix1);
                headIcon2.setImageMatrix(matrix1);
                headIcon4.setImageMatrix(matrix1);
                headIcon5.setImageMatrix(matrix1);
                headIcon6.setImageMatrix(matrix1);
                break;
            case R.id.headIcon4:
                headIconId=4;
                headIcon4.setImageResource(R.mipmap.checkicon);
                headIcon4.setImageMatrix(matrix);

                headIcon1.setImageMatrix(matrix1);
                headIcon2.setImageMatrix(matrix1);
                headIcon3.setImageMatrix(matrix1);
                headIcon5.setImageMatrix(matrix1);
                headIcon6.setImageMatrix(matrix1);
                break;
            case R.id.headIcon5:
                headIconId=5;
                headIcon5.setImageResource(R.mipmap.checkicon);
                headIcon5.setImageMatrix(matrix);

                headIcon1.setImageMatrix(matrix1);
                headIcon2.setImageMatrix(matrix1);
                headIcon3.setImageMatrix(matrix1);
                headIcon4.setImageMatrix(matrix1);
                headIcon6.setImageMatrix(matrix1);
                break;
            case R.id.headIcon6:
                headIconId=6;
                headIcon6.setImageResource(R.mipmap.checkicon);
                headIcon6.setImageMatrix(matrix);

                headIcon1.setImageMatrix(matrix1);
                headIcon2.setImageMatrix(matrix1);
                headIcon3.setImageMatrix(matrix1);
                headIcon4.setImageMatrix(matrix1);
                headIcon5.setImageMatrix(matrix1);
                break;
        }
    }
}
