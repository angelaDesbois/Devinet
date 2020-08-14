package com.example.devinet.repository.categorie;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.devinet.bo.Categorie;
import com.example.devinet.dal.AppDatabase;
import com.example.devinet.dal.CategorieDao;

import java.util.List;

public class CategorieBddRepository implements ICategorieRepository{

    private CategorieDao categorieDao = null;

    public  CategorieBddRepository(Context context){
        AppDatabase db = AppDatabase.getInstance(context);
        categorieDao=db.getCategorieDao();
    }
    @Override
    public void insert(Categorie categorie) {
        new AsyncTask<Categorie, Void, Void>(){
            @Override
            protected Void doInBackground(Categorie... categories){
                categorieDao.insert(categories[0]);
                return  null;
            }

        }.execute(categorie);

    }

    @Override
    public LiveData<List<Categorie>> get() {
        return categorieDao.get();
    }

    @Override
    public LiveData<Categorie> get(int id) {
        return categorieDao.get(id);
    }

    @Override
    public void udpate(Categorie categorie) {
        new AsyncTask<Categorie, Void, Void>(){
            @Override
            protected Void doInBackground(Categorie ... categories){
                categorieDao.update(categories[0]);
                return  null;
            }

        }.execute(categorie);
    }

    @Override
    public void delete(Categorie categorie) {
        new AsyncTask<Categorie, Void, Void>(){
            @Override
            protected Void doInBackground(Categorie ... categories){
                categorieDao.delete(categories[0]);
                return  null;
            }

        }.execute(categorie);

    }

    @Override
    public void delete(int id) {

    }
}
