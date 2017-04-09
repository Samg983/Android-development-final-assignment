package be.ehb.multec.museumapp.activities;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import be.ehb.multec.museumapp.R;
import be.ehb.multec.museumapp.model.Navigation;

public class AboutActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_CALL = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_lay_out);
    }


    public void callUs(View view) {
        Intent callUs = new Intent(Intent.ACTION_CALL);
        callUs.setData(Uri.parse("tel:0292929292"));

        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(callUs);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CALL);
        }
    }

    public void emailUs(View view) {
        Log.i("Send email", "");
        String[] TO = {"sam.goeman@hotmail.com"};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contactform from Android app");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email.", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();

        }
    }
    public void goToHome(View view) {
        Navigation.goToHome(getApplicationContext());
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
