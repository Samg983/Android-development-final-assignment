package be.ehb.multec.museumapp.dao;

import android.database.Cursor;

import java.util.ArrayList;

import be.ehb.multec.museumapp.model.Zaal;

/**
 * Created by SamGoeman on 18/12/2016.
 */

public class ZaalDao {
    public static ArrayList<Zaal> getZalen() {
        ArrayList<Zaal> resultaat = new ArrayList<Zaal>();
        Cursor mijnCursor = getZalenCursor();
        if (mijnCursor != null) {
            while (mijnCursor.moveToNext()) {
                Zaal huidigeZaal = converteerHuidigeRijNaarObject(mijnCursor);
                resultaat.add(huidigeZaal);
            }
        }

        return resultaat;
    }

    public static Cursor getZalenCursor() {
        return Database.voerSqlLeesActieUit("SELECT * from Zaal");
    }

    public static Zaal getZaalById(int id) {
        Zaal resultaat = null;

        Cursor mijnCursor = getZaalByIdCursor(id);
        if (mijnCursor != null) {
            mijnCursor.moveToFirst();
            resultaat = converteerHuidigeRijNaarObject(mijnCursor);
        }

        return resultaat;
    }

    public static Cursor getZaalByIdCursor(int id){
        return Database.voerSqlLeesActieUit("SELECT * from Zaal where zaalId = ?", new String[] { Integer.toString(id) });
    }

    public static void voegZaalToe(Zaal nieuweZaal) {
        Database.voerSqlSchrijfActieUit("INSERT INTO Zaal (naam) VALUES (?)", new Object[] { nieuweZaal.getNaam()});
    }

    public static void updateZaal(Zaal nieuweZaal) {
        Database.voerSqlSchrijfActieUit("UPDATE Zaal SET naam = ? WHERE zaalId = ?", new Object[] { nieuweZaal.getNaam() });
    }

    public static void verwijderZaal(int ZaalId) {
        Database.voerSqlSchrijfActieUit("DELETE FROM Zaal WHERE zaalId = ?", new Object[] { ZaalId });
    }

    private static Zaal converteerHuidigeRijNaarObject(Cursor mijnCursor) {
        return new Zaal(mijnCursor.getInt(mijnCursor.getColumnIndex("zaalId")), mijnCursor.getInt(mijnCursor.getColumnIndex("naam")), mijnCursor.getInt(mijnCursor.getColumnIndex("foto")));
    }
}
