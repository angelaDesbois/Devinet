package com.example.devinet.dal;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.devinet.bo.Categorie;

import java.util.List;

@Dao
public interface CategorieDao {

    @Insert
    void insert(Categorie categorie);

    @Insert
    void insert(Categorie ... categories);

    @Query("SELECT * FROM Categorie")
    LiveData<List<Categorie>> get();

    @Query("SELECT * FROM Categorie WHERE id = :id")
    LiveData<Categorie> get(int id);

    @Update
    void update(Categorie categorie);

    @Delete
    void delete(Categorie categorie);

    @Query("DELETE FROM Categorie WHERE id = :id")
    void delete(int id);



}
