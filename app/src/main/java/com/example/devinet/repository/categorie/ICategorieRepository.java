package com.example.devinet.repository.categorie;

import androidx.lifecycle.LiveData;

import com.example.devinet.bo.Categorie;

import java.util.List;

public interface ICategorieRepository {

    void insert(Categorie categorie);

    LiveData<List<Categorie>> get();

    LiveData<Categorie> get(int id);

    void udpate(Categorie categorie);

    void delete(Categorie categorie);

    void delete(int id);
}
