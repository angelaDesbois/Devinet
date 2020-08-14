package com.example.devinet.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.devinet.R;
import com.example.devinet.bo.Categorie;

import java.util.List;

public class CategorieAdapter extends ArrayAdapter<Categorie> {
    public CategorieAdapter(@NonNull Context context, int resource, @NonNull List<Categorie> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View newLigne, @NonNull ViewGroup parent){
        if(newLigne == null){
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            newLigne = li.inflate(R.layout.style_categorie_list, parent, false);
        }

        TextView tvLibelle = newLigne.findViewById(R.id.tv_libelle);
        tvLibelle.setText(getItem(position).getLibelle());

        return newLigne;

    }

}// end class
