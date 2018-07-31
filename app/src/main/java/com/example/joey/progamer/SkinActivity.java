package com.example.joey.progamer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class SkinActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int blueTheme=0;
    public static final int redTheme=1;
    public static int myTheme=1;
    private boolean changed=false;

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolbar,menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent=new Intent(SkinActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_from_left,R.anim.slide_out_from_right);
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch (myTheme){
            case blueTheme:
                setTheme(R.style.BlueTheme);
                changed=true;
                break;
            case redTheme:
                setTheme(R.style.AppTheme);
                changed=false;
                break;
        }

        setContentView(R.layout.activity_skin);

        android.support.v7.widget.Toolbar toolbar3=findViewById(R.id.toolbar3);
        toolbar3.setTitle("");
        setSupportActionBar(toolbar3);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.returnicon);
        }

        ImageView redstyle=(ImageView)findViewById(R.id.redstyle);
        ImageView bluestyle=(ImageView)findViewById(R.id.bluestyle);
        redstyle.setOnClickListener(SkinActivity.this);
        bluestyle.setOnClickListener(SkinActivity.this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.redstyle:
                if(changed){
                    myTheme=redTheme;
                    finish();
                    startActivity(getIntent());
                    changed=false;
                }

                break;
            case R.id.bluestyle:
                if(!changed){
                    myTheme=blueTheme;
                    finish();
                    startActivity(getIntent());
                    changed=true;
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(SkinActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_in_from_left,R.anim.slide_out_from_right);
    }
}
