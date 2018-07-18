package com.example.joey.progamer;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyInfoActivity extends AppCompatActivity {

    private static final String TAG = "MyInfoActivity";
    
    private RecyclerView recyclerView;
    private String[] title={"头像","昵称","性别","生日","地区","学校"};
    private String[] content={"Mr.Joey","男","1995-09-05","浙江 宁波","安徽科技学院"};
    private int[] pic={R.drawable.head};

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent=new Intent(MyInfoActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
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

        setContentView(R.layout.activity_my_info);

        android.support.v7.widget.Toolbar toolbar2=findViewById(R.id.toolbar2);
        toolbar2.setTitle("");
        setSupportActionBar(toolbar2);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.returnicon);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview_info);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerviewAdapter(this,title,pic,content));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        Button btn_loginout=(Button)findViewById(R.id.btn_loginout);
        btn_loginout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MyInfoActivity.this,LoginActivity.class);
                LoginActivity.logined=false;
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(MyInfoActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
