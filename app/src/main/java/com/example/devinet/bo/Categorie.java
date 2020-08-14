package com.example.devinet.bo;


// classe pr les catégories (facile, moyen , difficile)

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Categorie implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String libelle;

    public Categorie(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    protected Categorie(Parcel in) {
        id = in.readInt();
        libelle = in.readString();
    }

    public static final Creator<Categorie> CREATOR = new Creator<Categorie>() {
        @Override
        public Categorie createFromParcel(Parcel in) {
            return new Categorie(in);
        }

        @Override
        public Categorie[] newArray(int size) {
            return new Categorie[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(libelle);
    }
}//end class
