package com.example.joey.progamer;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private String[] settingTitle={"不","知","道","该","设","置","啥"};

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.slide_in_from_left,R.anim.slide_out_from_right);
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch (SkinActivity.myTheme){
            case 0:
                setTheme(R.style.BlueTheme);
                break;
            case 1:
                setTheme(R.style.AppTheme);
                break;
        }

        setContentView(R.layout.activity_setting);

        android.support.v7.widget.Toolbar toolbar4=findViewById(R.id.toolbar4);
        toolbar4.setTitle("");
        setSupportActionBar(toolbar4);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.returnicon);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview_setting);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerviewAdapterSetting(this,settingTitle));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_from_left,R.anim.slide_out_from_right);
    }
}
