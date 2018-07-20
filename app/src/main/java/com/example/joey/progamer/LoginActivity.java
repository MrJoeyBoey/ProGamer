package com.example.joey.progamer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    static public boolean logined=false;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.register:
                //Toast.makeText(LoginActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent1);
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

        setContentView(R.layout.activity_login);

        android.support.v7.widget.Toolbar toolbar2=findViewById(R.id.toolbar2);
        toolbar2.setTitle("");
        setSupportActionBar(toolbar2);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.returnicon);
        }


        Intent intent=getIntent();
        boolean Login_Success=intent.getBooleanExtra("Login Success",false);
        if(Login_Success){
            Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
        }


        Button btn_login=(Button)findViewById(R.id.btn_login);
        final EditText text_user=(EditText)findViewById(R.id.user);
        final EditText text_passport=(EditText)findViewById(R.id.passport);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int had=0;
                List<Acount> acounts= LitePal.select("userName","passPort").find(Acount.class);
                for(int i=0;i<acounts.size();i++){

                    Acount acount0=acounts.get(i);

                    if(text_user.getText().toString().equals(acount0.getUserName())){
                        had++;
                        if(text_passport.getText().toString().equals(acount0.getPassPort())){
                            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                            logined=true;
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                if(acounts.size()==0){
                    Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }else if(had==0){
                    Toast.makeText(LoginActivity.this,"该用户还没有被注册",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
