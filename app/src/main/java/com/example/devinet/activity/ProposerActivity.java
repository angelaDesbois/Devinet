package com.example.devinet.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.devinet.R;
import com.example.devinet.bo.Mot;
import com.example.devinet.repository.mot.IMotRepository;
import com.example.devinet.repository.mot.MotBddRepository;

public class ProposerActivity extends MenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposer);
    }


    public void onClickInsert(View view) {

        IMotRepository repo = new MotBddRepository(this);

        EditText etMot = findViewById(R.id.et_mot_inser);
        EditText etCat = findViewById(R.id.et_id_cat);

        String motEnPlus = etMot.getText().toString();
        int cat = Integer.parseInt(etCat.getText().toString());

        Mot motAjout = new Mot(0, motEnPlus,"", 0, cat,"");
        repo.insert(motAjout);
    }
}