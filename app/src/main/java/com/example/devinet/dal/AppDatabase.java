package com.example.devinet.dal;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.devinet.bo.Categorie;
import com.example.devinet.bo.Mot;

@Database(entities = {Mot.class, Categorie.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE = null;

    public abstract MotDao getMotDao();
    public abstract CategorieDao getCategorieDao();

    public  static AppDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "devinet.db")
                    .addCallback(roomFixture)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    private static Callback roomFixture = new Callback() {
        @SuppressLint("StaticFieldLeak")
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new AsyncTask<AppDatabase, Void, Void>(){
                @Override
                protected  Void doInBackground(AppDatabase... appDatabases){
                    CategorieDao catDao = INSTANCE.getCategorieDao();
                    MotDao motDao = INSTANCE.getMotDao();

                    catDao.insert(new Categorie(0,"Facile"));
                    catDao.insert(new Categorie(0,"Intermediaire"));
                    catDao.insert(new Categorie(0,"Difficile"));

                    motDao.insert(new Mot(0, "SURF", "", 0, 1, "surf"));
                    motDao.insert(new Mot(0, "BOXE", "", 0, 1, "boxe"));
                    motDao.insert(new Mot(0, "SKI", "", 0, 1, "ski"));
                    motDao.insert(new Mot(0, "VOILE", "", 0, 2, "voile"));
                    motDao.insert(new Mot(0, "KAYAK", "", 0, 2, "kayak"));
                    motDao.insert(new Mot(0, "SKATE", "", 0, 2, "skate"));
                    motDao.insert(new Mot(0, "DANSE", "", 0, 2, "danse"));
                    motDao.insert(new Mot(0, "NATATION", "", 0, 3, "natation"));
                    motDao.insert(new Mot(0, "WINDSURF", "", 0, 3, "windsurf"));

                    return null;
                }
            }.execute(INSTANCE);
        }
    };

}//end class
