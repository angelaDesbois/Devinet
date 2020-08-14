package com.example.devinet.bo;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Categorie.class,
        parentColumns = "id",
        childColumns = "idCategorie",
        onDelete = ForeignKey.CASCADE),
        indices = {@Index("idCategorie")}
)
public class Mot implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String mot;
    private String proposition;
    private int etatMot;
    private int idCategorie;
    private String image;

    public Mot(int id, String mot, String proposition, int etatMot, int idCategorie, String image) {
        this.id = id;
        this.mot = mot;
        this.proposition = proposition;
        this.etatMot = etatMot;
        this.idCategorie = idCategorie;
        this.image = image;
    }

    protected Mot(Parcel in) {
        id = in.readInt();
        mot = in.readString();
        proposition = in.readString();
        etatMot = in.readInt();
        idCategorie = in.readInt();
        image = in.readString();
    }

    public static final Creator<Mot> CREATOR = new Creator<Mot>() {
        @Override
        public Mot createFromParcel(Parcel in) {
            return new Mot(in);
        }

        @Override
        public Mot[] newArray(int size) {
            return new Mot[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public String getProposition() {
        return proposition;
    }

    public void setProposition(String proposition) {
        this.proposition = proposition;
    }

    public int getEtatMot() {
        return etatMot;
    }

    public void setEtatMot(int etatMot) {
        this.etatMot = etatMot;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Mot{" +
                "id=" + id +
                ", mot='" + mot + '\'' +
                ", proposition='" + proposition + '\'' +
                ", etatMot=" + etatMot+
                ", idCategorie=" + idCategorie +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(mot);
        parcel.writeString(proposition);
        parcel.writeInt (etatMot);
        parcel.writeInt(idCategorie);
        parcel.writeString(image);
    }
}//end class
