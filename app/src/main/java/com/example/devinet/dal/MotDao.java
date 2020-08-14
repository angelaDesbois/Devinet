package com.example.devinet.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.devinet.bo.Mot;

import java.util.List;

@Dao
public interface MotDao {

    @Insert
    void insert(Mot mot);

    @Insert
    void insert(Mot ... mots);

    @Query("SELECT * FROM Mot")
    LiveData<List<Mot>> get();

    @Query("SELECT * FROM Mot WHERE id = :id")
    LiveData<Mot> get(int id);

    @Query("SELECT * FROM Mot WHERE idCategorie= :idCategorie")
    LiveData<List<Mot>> getMotCategorie(int idCategorie);

    @Query("SELECT * FROM Mot WHERE etatMot = 1")
    LiveData<List<Mot>> getEtatMot();

    @Update
    void update(Mot mot);

    @Delete
    void delete(Mot mot);


}
