package com.example.devinet.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.devinet.R;
import com.example.devinet.activity.adapter.ResultatAdapter;
import com.example.devinet.bo.Mot;
import com.example.devinet.repository.mot.IMotRepository;
import com.example.devinet.repository.mot.MotBddRepository;
import com.example.devinet.view_model.MotViewModel;

import java.util.List;

public class ResultatActivity extends MenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        Mot motCheck = null;
        IMotRepository repo = new MotBddRepository(this);

        //get ts les mots avec etatMot = 1
        //get les propositions
        //get les mot correct



        MotViewModel motViewModel = ViewModelProviders.of(this).get(MotViewModel.class);
        LiveData<List<Mot>> observateur =  motViewModel.get();
        observateur.observe(this, new Observer<List<Mot>>() {
            @Override
            public void onChanged(List<Mot> mots) {
                ResultatAdapter adapter = new ResultatAdapter(ResultatActivity.this, R.layout.style_resultat_list,mots);

                   ListView listView = findViewById(R.id.list_resultat);
                   listView.setAdapter(adapter);






            }
        });


    }
}