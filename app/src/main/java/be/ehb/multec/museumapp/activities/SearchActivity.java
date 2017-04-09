package be.ehb.multec.museumapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import be.ehb.multec.museumapp.R;
import be.ehb.multec.museumapp.adapters.WerkArrayAdapter;
import be.ehb.multec.museumapp.dao.WerkDao;
import be.ehb.multec.museumapp.model.Navigation;
import be.ehb.multec.museumapp.model.Werk;


public class SearchActivity extends AppCompatActivity {
    private EditText txtSearch;
    private ListView lstGevondenWerken;
    private ArrayList<Werk> werkenLijst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_lay_out);
        txtSearch = (EditText) findViewById(R.id.txtSearch);

        lstGevondenWerken = (ListView) findViewById(R.id.lstGevondenWerken);
        werkenLijst = WerkDao.getWerken();

        loadWorks();

    }

    private void loadWorks() {
        WerkArrayAdapter mijnWerkArrayAdapter = new WerkArrayAdapter(getApplicationContext(), werkenLijst);
        updateWerkenListView(mijnWerkArrayAdapter);
    }

    public void searchItem(View view) {
        String input = txtSearch.getText().toString().toLowerCase();

        ArrayList<Werk> gevondenItems = searchItemsAndMakeArrayList(input);

        if (gevondenItems.isEmpty()) {
            Toast.makeText(getApplicationContext(), R.string.nothingFound, Toast.LENGTH_SHORT).show();
            loadWorks();
        } else {
            WerkArrayAdapter mijnGevondenWerkenAdapter = new WerkArrayAdapter(getApplicationContext(), gevondenItems);
            updateWerkenListView(mijnGevondenWerkenAdapter);
        }

    }

    private ArrayList<Werk> searchItemsAndMakeArrayList(String input) {

        ArrayList<Werk> mijnGezochteWerken = new ArrayList<Werk>();

        if (!input.equals("")) {
            for (Werk werk : werkenLijst) {
                String naamWerk = getResources().getString(werk.getNaam()).toLowerCase();
                if (naamWerk.contains(input)) mijnGezochteWerken.add(werk);
            }
        }

        return mijnGezochteWerken;
    }

    private void updateWerkenListView(WerkArrayAdapter mijnWerkenAdapter) {

        lstGevondenWerken.setAdapter(mijnWerkenAdapter);

        lstGevondenWerken.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
