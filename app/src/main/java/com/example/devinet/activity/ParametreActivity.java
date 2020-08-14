package com.example.devinet.activity;

import android.os.Bundle;
import android.widget.Switch;

import com.example.devinet.R;

public class ParametreActivity extends MenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametre);
    }

    // Lancer un son sous Android
    Switch switchSon = findViewById(R.id.switch_son);
    String son = getSharedPreferences("setting_app",MODE_PRIVATE).getString("son","ON");
   // MediaPlayer player = MediaPlayer.create(this,R.mp3.);


}


