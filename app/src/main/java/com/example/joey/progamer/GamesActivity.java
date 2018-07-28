package com.example.joey.progamer;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

public class GamesActivity extends AppCompatActivity {

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

        setContentView(R.layout.activity_games);

        final Intent intent=getIntent();
        String gameName=intent.getStringExtra("GameName");
        int gameImageID=intent.getIntExtra("GameCover",0);
        String englishName=intent.getStringExtra("EnglishName");
        String grade=intent.getStringExtra("Grade");
        String platform=intent.getStringExtra("Platform");
        String gameType=intent.getStringExtra("GameType");
        final String gameVideo=intent.getStringExtra("GameVideo");

        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbar_game);
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ImageView gameCover=(ImageView)findViewById(R.id.game_cover);
//        ImageView bkg=(ImageView)findViewById(R.id.bkg);
        TextView text_game_Name=(TextView)findViewById(R.id.text_gameName);
        TextView gameInfo=(TextView)findViewById(R.id.game_info);
        //TextView game_Strategy=(TextView)findViewById(R.id.game_Strategy);
        Button btn_stra=(Button)findViewById(R.id.btn_stra);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.returnicon);
        }
        Glide.with(this).load(gameImageID).into(gameCover);
//        Glide.with(this).load(gameImageID).into(bkg);
        text_game_Name.setText(gameName);
        text_game_Name.append("\n");
        text_game_Name.append(englishName);
        gameInfo.append(grade);
        gameInfo.append("\n\n");
        gameInfo.append(platform);
        gameInfo.append("\n\n");
        gameInfo.append(gameType);
   //     game_Strategy.setText(gameVideo);

        btn_stra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(GamesActivity.this,GameVideoActivity.class);
                intent1.putExtra("GameStra",gameVideo);
                startActivity(intent1);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
