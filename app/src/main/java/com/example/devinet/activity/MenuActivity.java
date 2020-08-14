package com.example.devinet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devinet.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mon_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.param:
                Intent param = new Intent(this, ParametreActivity.class);
                startActivity(param);
                return true;

            case R.id.apropos:
                Intent aPropos = new Intent(this, AproposActivity.class);
                startActivity(aPropos);
                return true;

            case R.id.accueil:
                Intent accueil = new Intent(this, MenuIntentActivity.class);
                startActivity(accueil);
                return true;


            default:

                return super.onOptionsItemSelected(item);

        }
    }
}