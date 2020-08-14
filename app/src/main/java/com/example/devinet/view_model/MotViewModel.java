package com.example.devinet.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.devinet.bo.Mot;
import com.example.devinet.repository.mot.IMotRepository;
import com.example.devinet.repository.mot.MotBddRepository;

import java.util.List;

public class MotViewModel  extends AndroidViewModel {

    private IMotRepository repoMot;
    private  LiveData<List<Mot>> observateurMot = null;

    public MotViewModel(@NonNull Application application) {
        super(application);
        repoMot = new MotBddRepository(application);
        observateurMot = repoMot.get();
    }

    public  LiveData<List<Mot>> get(){
        return observateurMot;
    }

    public void insert(Mot mot){
        repoMot.insert(mot);
    }

    public  void update(Mot mot){
        repoMot.update(mot);
    }

    public void delete(Mot mot){
        repoMot.delete(mot);
    }

    public LiveData<List<Mot>> getMotCategorieObserver(int id){
        return (LiveData<List<Mot>>) repoMot.getMotCategorie(id);
    }

    public  LiveData<List<Mot>> getEtatMotObserver(){
        return repoMot.getEtatMot();
    }
}// end class

