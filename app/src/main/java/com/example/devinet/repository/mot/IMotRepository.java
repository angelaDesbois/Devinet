package com.example.devinet.repository.mot;

import androidx.lifecycle.LiveData;

import com.example.devinet.bo.Mot;

import java.util.List;

public interface IMotRepository {

    void insert(Mot mot);

    LiveData<List<Mot>> get();

    LiveData<Mot> get(int id);

    LiveData<List<Mot>> getMotCategorie(int id);

    LiveData<List<Mot>> getEtatMot();

    void update(Mot mot);

    void delete(Mot mot);

    void delete(int id);
}
