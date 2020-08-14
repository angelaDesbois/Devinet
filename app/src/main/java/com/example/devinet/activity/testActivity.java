package com.example.devinet.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.devinet.R;
import com.example.devinet.bo.Mot;
import com.example.devinet.repository.mot.IMotRepository;
import com.example.devinet.repository.mot.MotBddRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//rename class avec Maj
public class testActivity extends MenuActivity{

    private Mot mot = null;
    private int presCounter = 0;
    private  int maxCounter ;
    private String motEnCours;
    TextView tvTitre;
    ImageView ivMot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //recup le mot en question
        Intent intent = getIntent();
        mot = intent.getParcelableExtra("cleMot");
        motEnCours = mot.getMot();
        Log.i("WOLOLOLOLOLOLO","INFO Mot : " + motEnCours);

        ivMot = findViewById(R.id.iv_mot);
         //recup image a partir du string bdd
        int resId = testActivity.this.getResources().getIdentifier(mot.getImage(), "drawable", testActivity.this.getPackageName());
        Log.i("WOLOLOLOLOLOLOlolol","INFO image : " +mot.getImage().toString());
        Log.i("WOLOLOLOLOLOLO","INFO image : " +resId);

        ivMot.setImageResource(resId);

        // boucle sur les char du mot
        for(char tab : randomMot(motEnCours)){
            Log.i("WOLOLOLOLOLOLO","INFO Mot : " + tab + "" + motEnCours);

            addView((LinearLayout) findViewById(R.id.layoutParent), tab, (EditText) findViewById(R.id.editText));

        }
        maxCounter= motEnCours.length();

    }



    private static char[] randomMot(String mot) {

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

        return b.toString().toCharArray();
    }

    // créer les emplacements en fonction du nbre de char
    private void addView(LinearLayout viewParent, final char text, final EditText editText){
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        linearLayoutParams.rightMargin = 5;

        final TextView textView = new TextView(this);

        textView.setLayoutParams(linearLayoutParams);

        // si mot trop long, y a pas tte les lettres a check! linear layout a changer
        int res = this.getResources().getIdentifier("bgpink", "drawable", testActivity.this.getPackageName());
        textView.setBackgroundResource(res);
        textView.setTextColor(this.getResources().getColor(R.color.colorPrimary));
        textView.setGravity(Gravity.CENTER);
        textView.setText(String.valueOf(text) );
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setTextSize(32);

        //type ecriture
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/FredokaOneRegular.ttf");
        textView.setTypeface(typeface);

        tvTitre = (TextView) findViewById(R.id.tv_titre);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(presCounter < maxCounter){
                    if(presCounter == 0)
                        editText.setText("");
                        editText.setText(editText.getText().toString() + String.valueOf(text));
                        textView.animate().alpha(0).setDuration(300);// permet de mettre invisible le textView
                        presCounter++;

                        if(presCounter == maxCounter){
                           doValidate();
                        }
                    }
            }
        });
        viewParent.addView(textView);
    }

    private void doValidate(){
        presCounter = 0;
        IMotRepository repo = new MotBddRepository(this);

        EditText editText = findViewById(R.id.editText);
        LinearLayout linearLayout = findViewById(R.id.layoutParent);

        if(editText.getText().toString().equals(motEnCours)){
            Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();

            editText.setText(editText.getText().toString());
            mot.setProposition(editText.getText().toString());
            mot.setEtatMot(1);
            repo.update(mot);
            Log.i("WOLOLOLOLOLOLO","INFO MotBDD : " + mot.toString());

           // editText.setText("");
        } else{
            Toast.makeText(this, "INCORRECT", Toast.LENGTH_SHORT).show();

            editText.setText(editText.getText().toString());
            mot.setProposition(editText.getText().toString());
            mot.setEtatMot(0);
            repo.update(mot);
            editText.setText("");
        }
        linearLayout.removeAllViews();
        for(char tab : randomMot(motEnCours)){
            addView((LinearLayout) findViewById(R.id.layoutParent), tab, (EditText) findViewById(R.id.editText));
        }
    }


    public void onClickContinue(View view) {

        Intent intentRetour = new Intent(testActivity.this, ListeCategorieActivity.class);
        startActivity(intentRetour);
    }
}//end class