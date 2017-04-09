package be.ehb.multec.museumapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import be.ehb.multec.museumapp.model.Navigation;

/**
 * Created by SamGoeman on 18/01/2017.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Navigation.goToHome(this);
    }
}
