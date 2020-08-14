package com.example.devinet.repository.mot;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.devinet.bo.Mot;
import com.example.devinet.dal.AppDatabase;
import com.example.devinet.dal.MotDao;

import java.util.List;

public class MotBddRepository implements  IMotRepository{

    private MotDao motDao = null;

    public  MotBddRepository(Context context){
        AppDatabase db = AppDatabase.getInstance(context);
        motDao = db.getMotDao();
    }


    @Override
    public void insert(Mot mot) {
        new AsyncTask<Mot, Void, Void>(){
            @Override
            protected Void doInBackground(Mot... mots) {
                //insertion d un article ds la bdd
                motDao.insert(mots[0]);
                return null;
            }

        }.execute(mot);

    }

    @Override
    public LiveData<List<Mot>> getMotCategorie(int id){
        return (LiveData<List<Mot>>) motDao.getMotCategorie(id);
    }

    @Override
    public  LiveData<List<Mot>> getEtatMot(){
        return motDao.getEtatMot();
    }

    @Override
    public LiveData<List<Mot>> get() {

        return motDao.get();
    }

    @Override
    public LiveData<Mot> get(int id) {

        return motDao.get(id);
    }

    @Override
    public void update(Mot mot) {
        new AsyncTask<Mot, Void, Void>() {
            @Override
            protected Void doInBackground(Mot... mots) {
                //insertion d un article ds la bdd
                motDao.update(mots[0]);
                return null;
            }
        }.execute(mot);

    }

    @Override
    public void delete(Mot mot) {
        new AsyncTask<Mot, Void, Void>() {
            @Override
            protected Void doInBackground(Mot... mots) {
                //insertion d un article ds la bdd
                motDao.delete(mots[0]);
                return null;
            }
        }.execute(mot);



    }

    @Override
    public void delete(int id) {

    }
}
