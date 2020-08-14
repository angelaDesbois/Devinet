package com.example.devinet.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.devinet.R;
import com.example.devinet.bo.Mot;

import java.util.List;

public class ResultatAdapter extends ArrayAdapter<Mot> {
    public ResultatAdapter(@NonNull Context context, int resource, @NonNull List<Mot> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View newLigne, @NonNull ViewGroup parent){
        if(newLigne == null){
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            newLigne = li.inflate(R.layout.style_resultat_list, parent, false);
        }


        TextView tvMot = newLigne.findViewById(R.id.tv_mot);
        TextView tvProp = newLigne.findViewById(R.id.tv_proposition);
        ImageView img = newLigne.findViewById(R.id.iv_ok);
        tvMot.setText(getItem(position).getMot());
        tvProp.setText(getItem(position).getProposition());

        if(getItem(position).getEtatMot() == 1){
            img.setImageResource(R.drawable.ic_baseline_thumb_up_24);
        }else{
            img.setImageResource(R.drawable.ic_baseline_thumb_down_24);
        }
        return  newLigne;
    }
}//endclass
