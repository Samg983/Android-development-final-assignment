package be.ehb.multec.museumapp.model;

import android.content.Context;
import android.content.Intent;

import be.ehb.multec.museumapp.activities.AboutActivity;
import be.ehb.multec.museumapp.activities.MainActivity;
import be.ehb.multec.museumapp.activities.SearchActivity;
import be.ehb.multec.museumapp.activities.ZalenActivity;

/**
 * Created by SamGoeman on 18/01/2017.
 */

public class Navigation {
    public static void goToHome(Context context) {
        Intent goHome = new Intent(context, MainActivity.class);
        context.startActivity(goHome);
        //activity.finish();
    }

    public static void goHalls(Context context) {
        Intent toHalls = new Intent(context, ZalenActivity.class);
        context.startActivity(toHalls);
        //activity.finish();
    }

    public static void goSearch(Context context) {
        Intent toSearch = new Intent(context, SearchActivity.class);
        context.startActivity(toSearch);
        //activity.finish();
    }

    public static void goAbout(Context context) {
        Intent toAbout = new Intent(context, AboutActivity.class);
        context.startActivity(toAbout);
        //activity.finish();
    }
}
