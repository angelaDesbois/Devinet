package com.example.devinet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.devinet.R;
import com.example.devinet.bo.Categorie;
import com.example.devinet.bo.Mot;
import com.example.devinet.repository.mot.IMotRepository;
import com.example.devinet.repository.mot.MotBddRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JeuxDetailMot extends AppCompatActivity {

    private Mot mot = null;
    private Categorie cat = null;

    List<Mot> listeMot = new ArrayList<>();
    String motEnCours = null;
    int index = 0;

    ImageView image = null;

    TextView tvMot = null;
    TextView tvRes = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeux_detail_mot);


        Intent intent = getIntent();
        mot = intent.getParcelableExtra("cleMot");
        motEnCours = mot.getMot();
        String motMelange = RandomMot(motEnCours);
        Log.i("WOLOLOLOLOLOLOlololala","INFO mot : " +motEnCours.toString());

        






      //  Resources res = getResources();
       // String monImage = mot.getImage();
       // int resID = res.getIdentifier(monImage, "drawable", getPackageName());
        image = findViewById(R.id.iv_mot);

        int resId = JeuxDetailMot.this.getResources().getIdentifier(mot.getImage(), "drawable", JeuxDetailMot.this.getPackageName());
        Log.i("WOLOLOLOLOLOLOlolol","INFO image : " +mot.getImage().toString());
        Log.i("WOLOLOLOLOLOLO","INFO image : " +resId);

        image.setImageResource(resId);

        Log.i("WOLOLOLOLOLOLO","INFO image : " + image);
       


        tvMot = findViewById(R.id.tv_mot);
        tvMot.setText(motMelange);

        tvRes = findViewById(R.id.tv_resultat);
        tvRes.setText("RESULTAT");

       
        








    }

    public void onClickCheck(View view) {
        IMotRepository repo = new MotBddRepository(this);
        EditText editMot = findViewById(R.id.et_proposition);
        mot.setProposition(editMot.getText().toString());
        repo.update(mot);
        
        if(mot.getMot().toString().equals(mot.getProposition().toString()) ){
         // mot.setMotOk(true);
          repo.update(mot);
            Log.i("WOLOLOLOLOLOLO","INFO Mot : " +mot.toString());
           
            tvRes.setText("GAGNé!!");
/*          
            Intent intentRetour = new Intent(this, ListeMotActivity.class);
            startActivity(intentRetour);*/
            
        }else{
          //  mot.setMotOk(false);
            repo.update(mot);
            tvRes.setText("PERDU!");
        }
        
    }

    private String RandomMot(String mot) {

        List<Character> list = new ArrayList<>();
        for (char c : mot.toCharArray()) {
            list.add(c);
        }

        StringBuilder b = new StringBuilder();
        String motEnvoi = null;

        do {
            Collections.shuffle(list);
            list.forEach(b::append);
            motEnvoi = list.toString();
        } while (mot.toLowerCase().equals(motEnvoi.toLowerCase()));

        return b.toString();
    }
    
    
}