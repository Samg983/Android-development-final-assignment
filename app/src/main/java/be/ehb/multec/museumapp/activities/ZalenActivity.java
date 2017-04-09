package be.ehb.multec.museumapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import be.ehb.multec.museumapp.R;
import be.ehb.multec.museumapp.adapters.ZaalArrayAdapter;
import be.ehb.multec.museumapp.dao.ZaalDao;
import be.ehb.multec.museumapp.model.Navigation;
import be.ehb.multec.museumapp.model.Zaal;

public class ZalenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zalen_lay_out);
        updateZalenListView();
    }
    private void updateZalenListView() {
        ArrayList<Zaal> zaalLijst = ZaalDao.getZalen();

        ZaalArrayAdapter mijnZaalArrayAdapter = new ZaalArrayAdapter(getApplicationContext(), zaalLijst);

        ListView lstZalen = (ListView) findViewById(R.id.lstZalen);

        lstZalen.setAdapter(mijnZaalArrayAdapter);
        lstZalen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Zaal mijnGeselecteerdeZaal = (Zaal) parent.getItemAtPosition(position);

                Intent naarWerkenOverzicht = new Intent(getApplicationContext(), WerkenOverzichtActivity.class);
                naarWerkenOverzicht.putExtra("zaalId", mijnGeselecteerdeZaal.getZaalID());
                startActivity(naarWerkenOverzicht);
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
