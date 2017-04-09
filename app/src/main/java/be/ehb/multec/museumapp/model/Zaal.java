package be.ehb.multec.museumapp.model;

import android.graphics.drawable.Drawable;

/**
 * Created by SamGoeman on 07/12/2016.
 */

public class Zaal {
    private int zaalID, foto, naam;



    public int getZaalID() {
        return zaalID;
    }

    public void setZaalID(int zaalID) {
        this.zaalID = zaalID;
    }

    public int getNaam() {
        return naam;
    }

    public void setNaam(int naam) {
        this.naam = naam;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public Zaal(int zaalID, int naam, int foto) {
        this.zaalID = zaalID;
        this.naam = naam;
        this.foto = foto;
    }
}
