package com.example.joey.progamer;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class MyColectActivity extends AppCompatActivity {
    private static final String TAG = "MyColectActivity";

    private GameAdapter gameAdapter;
    private List<Game> games=new ArrayList<>();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent=new Intent(MyColectActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
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
        setContentView(R.layout.activity_my_colect);
        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbar_mycolect);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.returnicon);
        }

        Intent intent=getIntent();
        List<Game>gameList=(List<Game>) intent.getSerializableExtra("GamesList");


        try {
            List<Acount> acounts = LitePal.select("userName", "gameColectedId").find(Acount.class);
            for (int i = 0; i < acounts.size(); i++) {
                Acount acount = acounts.get(i);
                if (LoginActivity.username.equals(acount.getUserName())) {

                    for(int j=0;j<acount.getGameColectedId().size();j++){
                        games.add(gameList.get(acount.getGameColectedId().get(j)-1));
                    }
                    RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerview_colect);
                    GridLayoutManager layoutManager=new GridLayoutManager(MyColectActivity.this,3);
                    recyclerView.setLayoutManager(layoutManager);
                    gameAdapter=new GameAdapter(games);
                    recyclerView.setAdapter(gameAdapter);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
