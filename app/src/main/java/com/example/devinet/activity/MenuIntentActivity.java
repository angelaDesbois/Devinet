package com.example.devinet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.devinet.R;

public class MenuIntentActivity extends MenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_intent);
    }

    public  void onClickMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickCategorieList(View view){
        Intent intent = new Intent(this, ListeCategorieActivity.class);
        startActivity(intent);
    }


    public void onClickResultat(View view) {
        Intent intent = new Intent(this, ResultatActivity.class);
        startActivity(intent);

    }

    public void onClickProposer(View view) {
        Intent intent = new Intent(this, ProposerActivity.class);
        startActivity(intent);
    }
}//end class