package com.example.joey.progamer;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    private Game[] games={
            new Game("超级马里奥：奥德赛",R.drawable.supermario,"SuperMario:Odyssey","10","Swich","奇幻 沙盒 3D","https://space.bilibili.com/43536/#/favlist?fid=1610906"),
            new Game("刺客信条：起源",R.drawable.assassin,"Assassin's Creed:Origins ","9.0","PC/PS4/XBOX ONE","开放世界 动作角色扮演 冒险","https://www.bilibili.com/video/av16034019?from=search&seid=18113796428949774774"),
            new Game("底特律：变人",R.drawable.detroy,"Detroit:Become Human","8.0","PS4","科幻 互动式电影","https://www.bilibili.com/video/av25233957?from=search&seid=8928858028714139919"),
            new Game("古墓丽影9",R.drawable.gumuliying,"Tomb Raider","9.1","PC/PS3/XBOX 360","奇幻 生存","https://www.bilibili.com/video/av6553009?from=search&seid=16708481528234861305"),
//            new Game("怪物猎人：世界",R.drawable.monsterhunter,"Monster Hunter:World",""),
//            new Game("合金装备5：幻痛",R.drawable.hejinzhuangbei,"Metal Gear Solid V:The Phantom Pain" ),
//            new Game("黑暗之魂3",R.drawable.darksouls,"Dark Souls 3"),
//            new Game("饥荒",R.drawable.dontstarve,"Don't Starve"),
//            new Game("极品飞车20",R.drawable.nfs,"Need For Speed 20"),
//            new Game("精灵宝可梦：究极太阳/究极月亮",R.drawable.pokemeng,"Pokemon Ultra Sun/Moon"),
            new Game("尼尔：机械纪元",R.drawable.nir,"NieR:Automata","8.9","PC/PS4/XBOX ONE","科幻 末世 美少女","https://www.bilibili.com/video/av10150031?from=search&seid=11831377836268364649"),
//            new Game("女神异闻录5",R.drawable.persona,"Persona 5",""),
//            new Game("仁王",R.drawable.nioh,"Nioh"),
//            new Game("塞尔达传说：荒野之息",R.drawable.zelda,"The Legend of Zelda:Breath of the Wild"),
            new Game("生化危机7",R.drawable.resident,"Resident Evil 7 Biohazard","7.7","PC/PS4/XBOX ONE/Switch","恐怖 第一人称射击 冒险","https://www.bilibili.com/video/av25174054"),
//            new Game("使命召唤14：二战",R.drawable.callofduty,"Call of Duty:WWII","8.0","PC/PS4/XBOX ONE",""),
//            new Game("侠盗猎车手5",R.drawable.gta,"Grand Theft Auto 5"),
//            new Game("血源诅咒",R.drawable.bloodborne,"BloodBorne"),
//            new Game("异度之刃2",R.drawable.xneoblade,"XneoBlade 2"),
//            new Game("战神4",R.drawable.godofwar,"God of War 4"),
//            new Game("最终幻想15",R.drawable.ff,"Final Fantasy 15")
    };
    private List<Game> gameList=new ArrayList<>();
    private GameAdapter gameAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.START);
                break;
            case R.id.search_game:
                Toast.makeText(this,"搜索游戏",Toast.LENGTH_SHORT).show();
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

        setContentView(R.layout.activity_main);

        final Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        final Intent intent1=new Intent(MainActivity.this,MyInfoActivity.class);

        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.menuicon);
        }

        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);

        NavigationView navView=(NavigationView)findViewById(R.id.nav_view);
        View drawView=navView.inflateHeaderView(R.layout.nav_header);
        CircleImageView icon_image=(CircleImageView)drawView.findViewById(R.id.icon_image);
        TextView userName=(TextView)drawView.findViewById(R.id.logintip);

        if(LoginActivity.logined){
            UserInfo userInfo=new UserInfo();
            userInfo.setIconImage(getResources().getDrawable(R.drawable.head));
            userInfo.setUserName(LoginActivity.username);

            icon_image.setImageDrawable(userInfo.getIconImage());
            userName.setText(userInfo.getUserName());
        }else {
            icon_image.setImageDrawable(getResources().getDrawable(R.mipmap.acounticon));
            userName.setText("立即登录");
        }
        icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.icon_image:
                        if(LoginActivity.logined){
                            startActivity(intent1);
                            finish();
                        }else {
                            startActivity(intent);
                            finish();
                        }
                        drawerLayout.closeDrawers();
                        break;
                }
            }
        });

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_setting:
                        Intent intent2=new Intent(MainActivity.this,SettingActivity.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case R.id.nav_skin:
                        Intent intent3=new Intent(MainActivity.this,SkinActivity.class);
                        startActivity(intent3);
                        finish();
                        break;
                }
                return true;
            }
        });

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        for(int i=0;i<games.length;i++){
            gameList.add(games[i]);
        }
        gameAdapter=new GameAdapter(gameList);
        recyclerView.setAdapter(gameAdapter);


    }




    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if(drawerLayout.isDrawerOpen(Gravity.LEFT)){
            drawerLayout.closeDrawers();
        }else {
            finish();
        }
    }
}
