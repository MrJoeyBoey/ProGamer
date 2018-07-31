package com.example.joey.progamer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.VideoView;

public class GameVideoActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.slide_in_from_left,R.anim.slide_out_from_right);
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
        setContentView(R.layout.activity_game_video);

        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbar_gamevideo);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.returnicon);
        }

        Intent intent=getIntent();
        String gameUrl=intent.getStringExtra("GameStra");

        WebView mGameVideo=(WebView)findViewById(R.id.web_GameVideo);
        mGameVideo.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mGameVideo.getSettings().setJavaScriptEnabled(true);
        mGameVideo.getSettings().setUseWideViewPort(true);
        mGameVideo.getSettings().setLoadWithOverviewMode(true);
        mGameVideo.getSettings().setBuiltInZoomControls(false);
        mGameVideo.getSettings().setSupportZoom(true);

        mGameVideo.setWebViewClient(new WebViewClient());
        mGameVideo.loadUrl(gameUrl);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_from_left,R.anim.slide_out_from_right);
    }
}
