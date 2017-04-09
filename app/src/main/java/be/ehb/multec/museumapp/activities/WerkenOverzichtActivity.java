package be.ehb.multec.museumapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import be.ehb.multec.museumapp.R;
import be.ehb.multec.museumapp.adapters.WerkArrayAdapter;
import be.ehb.multec.museumapp.dao.WerkDao;
import be.ehb.multec.museumapp.model.Navigation;
import be.ehb.multec.museumapp.model.Werk;

public class WerkenOverzichtActivity extends AppCompatActivity {
    private ListView lstWerken;
    private TextView lblWerkenTitel;
    private int doorgestuurdeZaalId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_werken_overzicht_lay_out);


        lblWerkenTitel = (TextView) findViewById(R.id.lblWerkenTitel);
        lstWerken = (ListView) findViewById(R.id.lstWerken);



        Bundle mijnDoorgestuurdeZaal = getIntent().getExtras();

        if (mijnDoorgestuurdeZaal == null) {
            finish();
        } else {
            doorgestuurdeZaalId = mijnDoorgestuurdeZaal.getInt("zaalId");

            ArrayList<Werk> werkLijst = WerkDao.getWerkenByZaalId(doorgestuurdeZaalId);
            WerkArrayAdapter mijnWerkenAdapter = new WerkArrayAdapter(getApplicationContext(), werkLijst);

            updateWerkenListView(mijnWerkenAdapter);
            setMainTitle();

        }

    }

    private void setMainTitle() {
        switch (doorgestuurdeZaalId) {
            case 1:
                lblWerkenTitel.setText(R.string.title_works_1);
                break;
            case 2:
                lblWerkenTitel.setText(R.string.title_works_2);
                break;
            case 3:
                lblWerkenTitel.setText(R.string.title_works_3);
                break;
            case 4:
                lblWerkenTitel.setText(R.string.title_works_4);
                break;
            case 5:
                lblWerkenTitel.setText(R.string.title_works_5);
                break;
            case 6:
                lblWerkenTitel.setText(R.string.title_works_6);
                break;


        }

    }

    private void updateWerkenListView(WerkArrayAdapter mijnWerkenAdapter) {

        lstWerken.setAdapter(mijnWerkenAdapter);

        lstWerken.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Werk mijnGeselecteerdeWerk = (Werk) parent.getItemAtPosition(position);

                Intent mijnIntent = new Intent(getApplicationContext(), WerkInformatieDetailActivity.class);
                mijnIntent.putExtra("weergeven", mijnGeselecteerdeWerk);
                startActivity(mijnIntent);
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

