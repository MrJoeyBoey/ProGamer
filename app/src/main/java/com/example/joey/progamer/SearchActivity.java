package com.example.joey.progamer;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = "SearchActivity";

    private GameAdapter gameAdapter;
    private List<Game>games=new ArrayList<>();
    private String lastTextView=null;
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
        setContentView(R.layout.activity_search);

        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbar_search);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        TextView tv_cancel=(TextView)findViewById(R.id.cancel_search);
        final EditText search=(EditText)findViewById(R.id.search);

        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SearchActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_from_left,R.anim.slide_out_from_right);
            }
        });
        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                if (i == EditorInfo.IME_ACTION_SEARCH) {

                    if(lastTextView!=textView.getText()){
                        games.clear();
                    }
                    for(int j=0;j<mGameList.size();j++){
                        if(mGameList.get(j).getGameName().contains(textView.getText())&&textView.getText().length()!=0){
                            games.add(mGameList.get(j));
                        }
                    }

                    RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerview_search);
                    GridLayoutManager layoutManager=new GridLayoutManager(SearchActivity.this,3);
                    recyclerView.setLayoutManager(layoutManager);
                    gameAdapter=new GameAdapter(games);
                    recyclerView.setAdapter(gameAdapter);

                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(textView.getWindowToken(), 0);
                }

                lastTextView=textView.getText().toString();

                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_from_left,R.anim.slide_out_from_right);
    }
}
