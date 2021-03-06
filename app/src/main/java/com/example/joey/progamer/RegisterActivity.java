package com.example.joey.progamer;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import org.litepal.crud.LitePalSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";
    private static int id=0;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
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

        switch (SkinActivity.myTheme){
            case 0:
                setTheme(R.style.BlueTheme);
                break;
            case 1:
                setTheme(R.style.AppTheme);
                break;
        }

        setContentView(R.layout.activity_register);

        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbar_register);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.returnicon);
        }

        final EditText register_user=(EditText)findViewById(R.id.register_user);
        final EditText register_passport=(EditText)findViewById(R.id.register_passport);
        final TextView warning_user=(TextView)findViewById(R.id.warning_user);
        final TextView wwarning_passport=(TextView)findViewById(R.id.warning_passport);

        warning_user.setVisibility(View.GONE);
        wwarning_passport.setVisibility(View.GONE);
        Button btn_register=(Button)findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (register_user.getText().length() < 4) {
                    warning_user.setVisibility(View.VISIBLE);
                }
                if (register_passport.getText().length() < 3) {
                    wwarning_passport.setVisibility(View.VISIBLE);
                }
                if (register_user.getText().length() >= 4) {
                    warning_user.setVisibility(View.GONE);
                }
                if (register_passport.getText().length() >= 3){
                    wwarning_passport.setVisibility(View.GONE);
                 }

                if(register_user.getText().length() >= 4&&register_passport.getText().length() >= 3){
                    List<Acount> acounts = LitePal.select("userName").find(Acount.class);
                    for (int i = 0; i < acounts.size(); i++) {
                        Acount acount0 = acounts.get(i);
                        if (register_user.getText().toString().equals(acount0.getUserName())) {
                            Toast.makeText(RegisterActivity.this, "该用户已被注册", Toast.LENGTH_SHORT).show();
                            register_user.setText("");
                            register_passport.setText("");
                            return;
                        }
                    }

                    Connector.getDatabase();
                    Acount acount = new Acount();
                    acount.setUserName(register_user.getText().toString());
                    acount.setPassPort(register_passport.getText().toString());
                    acount.save();

                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("Login Success", true);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_from_left,R.anim.slide_out_from_right);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_in_from_left,R.anim.slide_out_from_right);
    }
}
