package be.ehb.multec.museumapp.activities;

import android.app.Application;
import android.content.Context;


/**
 * Created by SamGoeman on 18/12/2016.
 */

public class MijnApplicatie extends Application{
    private static Context mijnContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mijnContext = getApplicationContext();

    }

    public static Context getContext(){
        return mijnContext;

    }
}
