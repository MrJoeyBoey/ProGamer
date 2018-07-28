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
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private static final String TAG = "MainActivity";

    private List<Game>gameList=new ArrayList<>();
    private Game[] games={
            new Game("超级马里奥：奥德赛",R.drawable.supermario,"SuperMario:Odyssey","10","Swich","奇幻 沙盒 3D","https://space.bilibili.com/43536/#/favlist?fid=1610906"),
            new Game("刺客信条：起源",R.drawable.assassin,"Assassin's Creed:Origins ","9.0","PC/PS4/XBOX ONE","开放世界 动作角色扮演 冒险","https://www.bilibili.com/video/av16034019?from=search&seid=18113796428949774774"),
            new Game("底特律：变人",R.drawable.detroy,"Detroit:Become Human","8.0","PS4","科幻 互动式电影","https://www.bilibili.com/video/av25233957?from=search&seid=8928858028714139919"),
            new Game("古墓丽影9",R.drawable.gumuliying,"Tomb Raider","9.1","PC/PS3/XBOX 360","奇幻 生存","https://www.bilibili.com/video/av6553009?from=search&seid=16708481528234861305"),
            new Game("怪物猎人：世界",R.drawable.monsterhunter,"Monster Hunter:World","9.6","PC/PS4/XBOX ONE","动作 冒险 多人 奇幻","https://www.bilibili.com/video/av19613105?from=search&seid=14258492953319388675"),
            new Game("合金装备5：幻痛",R.drawable.hejinzhuangbei,"Metal Gear Solid V:The Phantom Pain","9.2","PC/PS4/XBOX","潜入暗杀 沙盒","https://www.bilibili.com/video/av6559000?from=search&seid=18396072576093707225" ),
            new Game("黑暗之魂3",R.drawable.darksouls,"Dark Souls 3","9.4","PC/PS4/XBOX","奇幻 黑暗 动作角色扮演","https://www.bilibili.com/video/av4384128?from=search&seid=2502178149860962009" ),
            new Game("饥荒",R.drawable.dontstarve,"Don't Starve","9.1","PC/PSV/WiiU PS4","生存 沙盒 独立游戏 冒险","https://www.bilibili.com/video/av12735950/?spm_id_from=333.338.recommend_report.1" ),
            new Game("极品飞车20",R.drawable.nfs,"Need For Speed 20","7.5","PC/PS4/XBOX","赛车 竞技","https://www.bilibili.com/video/av16223062?from=search&seid=5016901606566321330" ),
            new Game("精灵宝可梦：究极太阳/究极月亮",R.drawable.pokemeng,"Pokemon Ultra Sun/Moon","9.0","3DS","回合制 对战 收集","https://www.bilibili.com/video/av16925792?from=search&seid=13905837721019002023" ),
            new Game("尼尔：机械纪元",R.drawable.nir,"NieR:Automata","8.9","PC/PS4/XBOX ONE","科幻 末世 美少女","https://www.bilibili.com/video/av10150031?from=search&seid=11831377836268364649"),
            new Game("女神异闻录5",R.drawable.persona,"Persona 5","9.6","PS4/PS3","奇幻 回合制 角色扮演","https://www.bilibili.com/video/av9358230?from=search&seid=1770470183854496000"),
            new Game("仁王",R.drawable.nioh,"Nioh","8.4","PC/PS4","动作角色扮演 日式 冒险","https://www.bilibili.com/video/av8749046?from=search&seid=14956812363154200244"),
            new Game("塞尔达传说：荒野之息",R.drawable.zelda,"The Legend of Zelda:Breath of the Wild","10","Switch/WiiU","动作角色扮演 开放世界 冒险","https://www.bilibili.com/video/av9800429?from=search&seid=17654783124746259836"),
            new Game("生化危机7",R.drawable.resident,"Resident Evil 7 Biohazard","7.7","PC/PS4/XBOX ONE/Switch","恐怖 第一人称射击 冒险","https://www.bilibili.com/video/av25174054"),
            new Game("使命召唤14：二战",R.drawable.callofduty,"Call of Duty:WWII","8.0","PC/PS4/XBOX ONE","第一人称射击 历史","https://www.bilibili.com/video/av15965482?from=search&seid=5644938300841769069"),
            new Game("侠盗猎车手5",R.drawable.gta,"Grand Theft Auto 5","9.8","PC/PS4/XBOX","开放世界 犯罪 动作","https://www.bilibili.com/video/av2295825?from=search&seid=12030211630006097404"),
            new Game("血源诅咒",R.drawable.bloodborne,"BloodBorne","9.5","PS4","黑暗 克苏鲁 动作角色扮演","https://www.bilibili.com/video/av2184262?from=search&seid=8939949566497416065"),
            new Game("异度之刃2",R.drawable.xneoblade,"XneoBlade 2","9.5","Switch","科幻 沙盒 角色扮演","https://www.bilibili.com/video/av17577699?from=search&seid=13418943913617253618"),
            new Game("战神4",R.drawable.godofwar,"God of War 4","10","PS4","动作 ","https://www.bilibili.com/video/av22338596?from=search&seid=3300672328697779466"),
            new Game("最终幻想15",R.drawable.ff,"Final Fantasy 15","8.4","PC/PS4/XBOX","动作角色扮演 奇幻 冒险","https://www.bilibili.com/video/av7367859?from=search&seid=2214592691810653557")
    };
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

        icon_image.setImageResource(R.mipmap.acounticon);
        if(LoginActivity.logined){
            try {
                List<Acount> acounts= LitePal.select("userName","headIconId").find(Acount.class);
                for(int i=0;i<acounts.size();i++) {
                    Acount acount = acounts.get(i);
                    if(LoginActivity.username.equals(acount.getUserName())) {
                        userName.setText(LoginActivity.username);
                        switch (acount.getHeadIconId()){
                            case 1:
                                icon_image.setImageResource(R.drawable.head);
                                break;
                            case 2:
                                icon_image.setImageResource(R.drawable.headicon2);
                                break;
                            case 3:
                                icon_image.setImageResource(R.drawable.headicon3);
                                break;
                            case 4:
                                icon_image.setImageResource(R.drawable.headicon4);
                                break;
                            case 5:
                                icon_image.setImageResource(R.drawable.headicon5);
                                break;
                            case 6:
                                icon_image.setImageResource(R.drawable.headicon6);
                                break;

                        }
                    }
                    }
            }catch (Exception e){
                e.printStackTrace();
            }

        }else {
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
