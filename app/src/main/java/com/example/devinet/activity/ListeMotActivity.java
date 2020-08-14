package com.example.devinet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import com.example.devinet.R;
import com.example.devinet.activity.adapter.MotAdapter;
import com.example.devinet.bo.Categorie;
import com.example.devinet.bo.Mot;
import com.example.devinet.view_model.MotViewModel;

import java.util.List;

public class ListeMotActivity extends MenuActivity {

    private ListView maListeMot = null;
    private Categorie categorie = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_mot);

        Intent intent = getIntent();
        categorie = intent.getParcelableExtra("categorie");


        maListeMot= findViewById(R.id.list_mot);
        maListeMot.setOnItemClickListener((adapterView, view, i, l) -> {
            Mot mot = (Mot) maListeMot.getAdapter().getItem(i);
            Intent intentMot = new Intent(ListeMotActivity.this, testActivity.class);
            intentMot.putExtra("cleMot", mot);
            startActivity(intentMot);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        MotViewModel vm = ViewModelProviders.of(this).get(MotViewModel.class);
        LiveData<List<Mot>> observateurMot = vm.getMotCategorieObserver(categorie.getId());
        //LiveData<List<Mot>> observateurMot = vm.get();

        observateurMot.observe(this, mots -> {
           // ListView maListeMot = findViewById(R.id.list_mot);
            MotAdapter adapter = new MotAdapter(ListeMotActivity.this, R.layout.style_mot_list, mots);
            maListeMot.setAdapter(adapter);
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}//end activity