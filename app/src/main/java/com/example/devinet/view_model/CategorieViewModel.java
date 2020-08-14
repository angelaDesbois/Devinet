package com.example.devinet.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.devinet.bo.Categorie;
import com.example.devinet.repository.categorie.CategorieBddRepository;
import com.example.devinet.repository.categorie.ICategorieRepository;

import java.util.List;

public class CategorieViewModel  extends AndroidViewModel {

    private ICategorieRepository repoCategorie;
    private LiveData<List<Categorie>> observateurCat = null;

    public CategorieViewModel(@NonNull Application application) {
        super(application);
        repoCategorie = new CategorieBddRepository(application);
        observateurCat = repoCategorie.get();
    }

    public  LiveData<List<Categorie>> get(){
        return observateurCat;
    }

    public void insert(Categorie categorie){
        repoCategorie.insert(categorie);
    }

    public  void update(Categorie categorie){
        repoCategorie.udpate(categorie);
    }

    public void delete(Categorie categorie){
        repoCategorie.delete(categorie);
    }
}//end class