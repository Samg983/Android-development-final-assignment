package be.ehb.multec.museumapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import be.ehb.multec.museumapp.R;
import be.ehb.multec.museumapp.model.Navigation;
import be.ehb.multec.museumapp.model.OpenPopUpPhoto;
import be.ehb.multec.museumapp.model.Werk;

public class WerkInformatieDetailActivity extends AppCompatActivity {
    private TextView lblNaam, lblAuteur, lblJaar, lblBeschrijving, lblHeadTitle;
    private ImageView imgAfbeelding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_werk_informatie_lay_out);

        Bundle mijnDoorgestGegevens = getIntent().getExtras();

        if (mijnDoorgestGegevens == null) {
            Log.d(this.getClass().getName(), "Er werden geen extra gegevens doorgestuurd");
        } else {
            Werk doorgestuurdeWerk = (Werk) mijnDoorgestGegevens.get("weergeven");

            setInformation(doorgestuurdeWerk);
        }
    }

    private void setInformation(final Werk doorgestuurdeWerk) {

        lblHeadTitle = (TextView) findViewById(R.id.lblHeadTitle);
        lblNaam = (TextView) findViewById(R.id.lblNaam);
        lblAuteur = (TextView) findViewById(R.id.lblAuteur);
        lblJaar = (TextView) findViewById(R.id.lblJaar);
        lblBeschrijving = (TextView) findViewById(R.id.lblBeschrijving);
        imgAfbeelding = (ImageView) findViewById(R.id.imgWerkDetail);



        String naam = getString(doorgestuurdeWerk.getNaam());
        String auteur = getString(doorgestuurdeWerk.getAuteur());
        String jaar = getString(doorgestuurdeWerk.getJaar());
        String beschrijving = getString(doorgestuurdeWerk.getBeschrijving());


        lblHeadTitle.setText(naam);
        imgAfbeelding.setImageResource(doorgestuurdeWerk.getFoto());
        lblNaam.setText(naam);
        lblAuteur.setText(auteur);
        lblJaar.setText(jaar);
        lblBeschrijving.setText(beschrijving);
        imgAfbeelding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenPopUpPhoto popUp = new OpenPopUpPhoto(WerkInformatieDetailActivity.this, doorgestuurdeWerk.getFoto());
                popUp.show();
            }
        });

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
