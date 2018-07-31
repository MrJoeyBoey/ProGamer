package com.example.joey.progamer;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

import org.litepal.LitePal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GamesActivity extends AppCompatActivity {

    private static final String TAG = "GamesActivity";
    
    private boolean colected=false;
    private List<Integer>gamesId=new ArrayList<>();
    private List<Game>mGameList=MainActivity.sGameList;

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

        Intent intent=getIntent();
        final int gameId=intent.getIntExtra("GameId",0);
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
        final ImageView btn_colect=(ImageView)findViewById(R.id.btn_colect);

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
        btn_colect.setImageResource(R.mipmap.colecticon);

        try {
            List<Acount> acounts = LitePal.select("userName", "gameColectedId").find(Acount.class);
            for (int i = 0; i < acounts.size(); i++) {
                Acount acount = acounts.get(i);
                if (LoginActivity.username.equals(acount.getUserName())) {
                    if(acount.getGameColectedId()!=null){
                        gamesId=acount.getGameColectedId();
                    }
                    for(int j=0;j<acount.getGameColectedId().size();j++){

                       if(acount.getGameColectedId().get(j)==gameId){

                           btn_colect.setImageResource(R.mipmap.colectedicon);
                           colected=true;
                       }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        btn_stra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(GamesActivity.this,GameVideoActivity.class);
                intent1.putExtra("GameStra",gameVideo);
                startActivity(intent1);
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
            }
        });
        btn_colect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(LoginActivity.logined){
                    Acount acount=new Acount();
                    if(!colected){
                        btn_colect.setImageResource(R.mipmap.colectedicon);
                        gamesId.add(gameId);
                        colected=true;
                    }else {
                        btn_colect.setImageResource(R.mipmap.colecticon);
                        for (int i = 0; i < gamesId.size(); i++) {
                            if (gamesId.get(i) == gameId) {
                                gamesId.remove(i);
                            }
                        }
                        colected = false;
                    }
                    if(gamesId.size()==0){
                        acount.setToDefault("gameColectedId");
                    }else {
                        acount.setGameColectedId(gamesId);
                    }
                        acount.updateAll("userName=?", LoginActivity.username);
                }else {
                    Toast.makeText(GamesActivity.this,"请登录",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=getIntent();
        String context=intent.getStringExtra("上文");
        switch (item.getItemId()){
            case android.R.id.home:
                if(context.contains("com.example.joey.progamer.MyColectActivity")){
                    Intent intent1=new Intent(GamesActivity.this,MyColectActivity.class);
                    intent1.putExtra("GamesList", (Serializable)mGameList);
                    startActivity(intent1);
                }
                finish();
                overridePendingTransition(R.anim.slide_in_from_left,R.anim.slide_out_from_right);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_from_left,R.anim.slide_out_from_right);
    }
}
