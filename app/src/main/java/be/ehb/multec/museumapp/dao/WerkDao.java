package be.ehb.multec.museumapp.dao;

import android.database.Cursor;

import java.util.ArrayList;

import be.ehb.multec.museumapp.model.Werk;

/**
 * Created by SamGoeman on 18/12/2016.
 */

public class WerkDao {
    public static ArrayList<Werk> getWerken() {
        ArrayList<Werk> resultaat = new ArrayList<Werk>();
        Cursor mijnCursor = getWerkenCursor();
        if (mijnCursor != null) {
            while (mijnCursor.moveToNext()) {
                Werk huidigWerk = converteerHuidigeRijNaarObject(mijnCursor);
                resultaat.add(huidigWerk);
            }
        }

        return resultaat;
    }

    public static ArrayList<Werk> getWerkenByZaalId(int id) {
        ArrayList<Werk> resultaat = new ArrayList<Werk>();
        Cursor mijnCursor = getWerkByZaalIdCursor(id);
        if (mijnCursor != null) {
            while (mijnCursor.moveToNext()) {
                Werk huidigWerk = converteerHuidigeRijNaarObject(mijnCursor);
                resultaat.add(huidigWerk);
            }
        }

        return resultaat;
    }
    public static Cursor getWerkenCursor() {
        return Database.voerSqlLeesActieUit("SELECT * from Werk");
    }
    public static Werk getWerkById(int id) {
        Werk resultaat = null;

        Cursor mijnCursor = getWerkByIdCursor(id);
        if (mijnCursor != null) {
            mijnCursor.moveToFirst();
            resultaat = converteerHuidigeRijNaarObject(mijnCursor);
        }

        return resultaat;
    }
    public static Cursor getWerkByIdCursor(int id){
        return Database.voerSqlLeesActieUit("SELECT * from Werk where werkId = ?", new String[] { Integer.toString(id) });
    }

    public static Cursor getWerkByZaalIdCursor(int id){
        return Database.voerSqlLeesActieUit("SELECT * from Werk where zaalId = ?", new String[] { Integer.toString(id) });
    }
    public static void voegWerkToe(Werk nieuwWerk) {
        Database.voerSqlSchrijfActieUit("INSERT INTO Werk (naam, beschrijving, auteur, jaar, foto, zaalId) VALUES (?,?,?,?,?,?)", new Object[] { nieuwWerk.getNaam(), nieuwWerk.getBeschrijving(), nieuwWerk.getAuteur(), nieuwWerk.getJaar(), nieuwWerk.getFoto(), nieuwWerk.getZaalId() });
    }

    public static void updateWerk(Werk nieuwWerk) {
        Database.voerSqlSchrijfActieUit("UPDATE Werk SET naam = ?, beschrijving = ?, auteur = ?, jaar = ?, foto = ?, zaalId = ? WHERE werkId = ?", new Object[] { nieuwWerk.getNaam(), nieuwWerk.getBeschrijving(), nieuwWerk.getAuteur(), nieuwWerk.getJaar(), nieuwWerk.getFoto(), nieuwWerk.getZaalId(), nieuwWerk.getWerkId() });
    }

    public static void verwijderWerk(int werkId) {
        Database.voerSqlSchrijfActieUit("DELETE FROM Werk WHERE werkId = ?", new Object[] { werkId });
    }

    private static Werk converteerHuidigeRijNaarObject(Cursor mijnCursor) {
        return new Werk(mijnCursor.getInt(mijnCursor.getColumnIndex("werkId")), mijnCursor.getInt(mijnCursor.getColumnIndex("naam")), mijnCursor.getInt(mijnCursor.getColumnIndex("beschrijving")), mijnCursor.getInt(mijnCursor.getColumnIndex("auteur")), mijnCursor.getInt(mijnCursor.getColumnIndex("jaar")), mijnCursor.getInt(mijnCursor.getColumnIndex("foto")), mijnCursor.getInt(mijnCursor.getColumnIndex("zaalId")));
    }
}
