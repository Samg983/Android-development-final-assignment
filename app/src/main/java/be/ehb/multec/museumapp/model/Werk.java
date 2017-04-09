package be.ehb.multec.museumapp.model;

import android.media.Image;

import java.io.Serializable;

/**
 * Created by SamGoeman on 23/11/2016.
 */

public class Werk implements Serializable {
    private int werkId, foto, zaalId, jaar, beschrijving,naam, auteur;

    public int getNaam() {
        return naam;
    }

    public void setNaam(int naam) {
        this.naam = naam;
    }

    public int getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(int beschrijving) {
        this.beschrijving = beschrijving;
    }

    public int getAuteur() {
        return auteur;
    }

    public void setAuteur(int auteur) {
        this.auteur = auteur;
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getWerkId() {
        return werkId;
    }

    public void setWerkId(int werkId) {
        this.werkId = werkId;
    }

    public int getZaalId() {
        return zaalId;
    }

    public void setZaalId(int zaalId) {
        this.zaalId = zaalId;
    }

    public Werk(int werkId, int naam, int beschrijving, int auteur, int jaar, int foto, int zaalId) {
        this.foto = foto;
        this.auteur = auteur;
        this.beschrijving = beschrijving;
        this.jaar = jaar;
        this.naam = naam;
        this.werkId = werkId;
        this.zaalId = zaalId;
    }
}
