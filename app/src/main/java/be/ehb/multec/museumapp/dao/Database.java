package be.ehb.multec.museumapp.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import be.ehb.multec.museumapp.activities.MijnApplicatie;
import be.ehb.multec.museumapp.R;

/**
 * Created by SamGoeman on 18/12/2016.
 */

public class Database extends SQLiteOpenHelper {
    private static Database mijnDatabase;


    public static Database getHuidigeDatabase() {
        if (mijnDatabase == null) {
            mijnDatabase = new Database();

        }
        return mijnDatabase;
    }


    public Database() {
        super(MijnApplicatie.getContext(), "atomiumDatabase.db", null, 46);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("PRAGMA foreign_keys=ON");

        db.execSQL("create table Zaal (zaalId integer primary key autoincrement, naam integer not null, foto integer);");
        db.execSQL("create table Werk (werkId integer primary key autoincrement, naam integer not null, beschrijving integer not null, auteur integer not null, jaar integer, foto integer, zaalId integer references Zaal(zaalId));");

        db.execSQL("INSERT INTO Zaal (naam, foto) VALUES (?, ?)", new Object[]{R.string.naam_zaal1, R.drawable.green_background});
        db.execSQL("INSERT INTO Zaal (naam, foto) VALUES (?, ?)", new Object[]{R.string.naam_zaal2, R.drawable.yellow_background});
        db.execSQL("INSERT INTO Zaal (naam, foto) VALUES (?, ?)", new Object[]{R.string.naam_zaal3, R.drawable.blue_background});
        db.execSQL("INSERT INTO Zaal (naam, foto) VALUES (?, ?)", new Object[]{R.string.naam_zaal4, R.drawable.purple_background});
        db.execSQL("INSERT INTO Zaal (naam, foto) VALUES (?, ?)", new Object[]{R.string.naam_zaal5, R.drawable.orange_background});
        db.execSQL("INSERT INTO Zaal (naam, foto) VALUES (?, ?)", new Object[]{R.string.naam_zaal6, R.drawable.red_background});

        db.execSQL("INSERT INTO Werk (naam, beschrijving, auteur, jaar, foto, zaalId) VALUES (?, ?, ?, ?, ?, '1')", new Object[]{R.string.naam_werk1, R.string.beschrijving_werk1, R.string.auteur_werk1, R.string.jaar_werk1, R.drawable.dezingendeschilder});
        db.execSQL("INSERT INTO Werk (naam, beschrijving, auteur, jaar, foto, zaalId) VALUES (?, ?, ?, ?, ?, '1')", new Object[]{R.string.naam_werk2, R.string.beschrijving_werk2, R.string.auteur_werk2, R.string.jaar_werk2, R.drawable.zottedoos});
        db.execSQL("INSERT INTO Werk (naam, beschrijving, auteur, jaar, foto, zaalId) VALUES (?, ?, ?, ?, ?, '2')", new Object[]{R.string.naam_werk3, R.string.beschrijving_werk3, R.string.auteur_werk3, R.string.jaar_werk3, R.drawable.kriskraskros});
        db.execSQL("INSERT INTO Werk (naam, beschrijving, auteur, jaar, foto, zaalId) VALUES (?, ?, ?, ?, ?, '2')", new Object[]{R.string.naam_werk4, R.string.beschrijving_werk4, R.string.auteur_werk4, R.string.jaar_werk4, R.drawable.portefeuilleweg});
        db.execSQL("INSERT INTO Werk (naam, beschrijving, auteur, jaar, foto, zaalId) VALUES (?, ?, ?, ?, ?, '3')", new Object[]{R.string.naam_werk5, R.string.beschrijving_werk5, R.string.auteur_werk5, R.string.jaar_werk5, R.drawable.sdcard});
        db.execSQL("INSERT INTO Werk (naam, beschrijving, auteur, jaar, foto, zaalId) VALUES (?, ?, ?, ?, ?, '3')", new Object[]{R.string.naam_werk6, R.string.beschrijving_werk6, R.string.auteur_werk6, R.string.jaar_werk6, R.drawable.tandenstoker});
        db.execSQL("INSERT INTO Werk (naam, beschrijving, auteur, jaar, foto, zaalId) VALUES (?, ?, ?, ?, ?, '4')", new Object[]{R.string.naam_werk7, R.string.beschrijving_werk7, R.string.auteur_werk7, R.string.jaar_werk7, R.drawable.ijskreim});
        db.execSQL("INSERT INTO Werk (naam, beschrijving, auteur, jaar, foto, zaalId) VALUES (?, ?, ?, ?, ?, '4')", new Object[]{R.string.naam_werk8, R.string.beschrijving_werk8, R.string.auteur_werk8, R.string.jaar_werk8, R.drawable.mountain_biella});
        db.execSQL("INSERT INTO Werk (naam, beschrijving, auteur, jaar, foto, zaalId) VALUES (?, ?, ?, ?, ?, '5')", new Object[]{R.string.naam_werk9, R.string.beschrijving_werk9, R.string.auteur_werk9, R.string.jaar_werk9, R.drawable.justofnie});
        db.execSQL("INSERT INTO Werk (naam, beschrijving, auteur, jaar, foto, zaalId) VALUES (?, ?, ?, ?, ?, '5')", new Object[]{R.string.naam_werk10, R.string.beschrijving_werk10, R.string.auteur_werk10, R.string.jaar_werk10, R.drawable.lolita});
        db.execSQL("INSERT INTO Werk (naam, beschrijving, auteur, jaar, foto, zaalId) VALUES (?, ?, ?, ?, ?, '6')", new Object[]{R.string.naam_werk11, R.string.beschrijving_werk11, R.string.auteur_werk11, R.string.jaar_werk11, R.drawable.freaky});
        db.execSQL("INSERT INTO Werk (naam, beschrijving, auteur, jaar, foto, zaalId) VALUES (?, ?, ?, ?, ?, '6')", new Object[]{R.string.naam_werk12, R.string.beschrijving_werk12, R.string.auteur_werk12, R.string.jaar_werk12, R.drawable.vergeefme});


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Werk");
        db.execSQL("DROP TABLE IF EXISTS Zaal");

        //De database opnieuw aanmaken
        onCreate(db);
    }

    public static Cursor voerSqlLeesActieUit(String sqlQuery) {
        return voerSqlLeesActieUit(sqlQuery, new String[0]);
    }

    public static Cursor voerSqlLeesActieUit(String sqlQuery, String[] parameterWaarden) {
        return getHuidigeDatabase().getReadableDatabase().rawQuery(sqlQuery, parameterWaarden);
    }

    public static void voerSqlSchrijfActieUit(String sqlQuery) {
        voerSqlSchrijfActieUit(sqlQuery, new Object[0]);
    }

    public static void voerSqlSchrijfActieUit(String sqlQuery, Object[] parameterWaarden) {

        getHuidigeDatabase().getWritableDatabase().execSQL(sqlQuery, parameterWaarden);
    }
}
