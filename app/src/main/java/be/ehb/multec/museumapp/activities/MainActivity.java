package be.ehb.multec.museumapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import be.ehb.multec.museumapp.R;
import be.ehb.multec.museumapp.model.Navigation;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goHalls(View view) {
        Navigation.goHalls(getApplicationContext());
    }

    public void goSearch(View view) {
        Navigation.goSearch(getApplicationContext());
    }

    public void goAbout(View view) {
        Navigation.goAbout(getApplicationContext());
    }
}
