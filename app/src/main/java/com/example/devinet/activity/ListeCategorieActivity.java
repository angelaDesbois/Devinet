package com.example.devinet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.devinet.R;
import com.example.devinet.activity.adapter.CategorieAdapter;
import com.example.devinet.bo.Categorie;
import com.example.devinet.view_model.CategorieViewModel;

import java.util.List;

public class ListeCategorieActivity extends MenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_categorie);

                CategorieViewModel categorieViewModel = ViewModelProviders.of(this).get(CategorieViewModel.class);
                LiveData<List<Categorie>> observateur =  categorieViewModel.get();
                observateur.observe(this, new Observer<List<Categorie>>() {
                    @Override
                    public void onChanged(List<Categorie> categories) {
                        CategorieAdapter adapter = new CategorieAdapter(ListeCategorieActivity.this, R.layout.style_categorie_list, categories);

                        ListView listView = findViewById(R.id.list_categorie);
                        listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(ListeCategorieActivity.this, ListeMotActivity.class);
                        intent.putExtra("categorie", (Parcelable) categories.get(i));
                        startActivity(intent);
                    }
                });
            }
        });

    }

  /* private ListView maListe = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_categorie);

        //pr listener
        maListe = findViewById(R.id.list_categorie);
        maListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Categorie categorie = (Categorie) maListe.getAdapter().getItem(position);

                Intent intent = new Intent(ListeCategorieActivity.this, ListeMotActivity.class);
                intent.putExtra("categorie", categorie);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        CategorieViewModel vm = ViewModelProviders.of(this).get(CategorieViewModel.class);
        LiveData<List<Categorie>> observateur = vm.get();

        observateur.observe(this, categories -> {
           // ListView maListe = findViewById(R.id.list_categorie);
            CategorieAdapter adapterCat = new CategorieAdapter(ListeCategorieActivity.this, R.layout.style_categorie_list, categories);
            maListe.setAdapter(adapterCat);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }*/
}//end class