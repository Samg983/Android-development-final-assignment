package be.ehb.multec.museumapp.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import be.ehb.multec.museumapp.R;
import be.ehb.multec.museumapp.model.Werk;

/**
 * Created by SamGoeman on 23/11/2016.
 */

public class WerkArrayAdapter extends ArrayAdapter<Werk>{
    private Context mijnContext;
    private List<Werk> mijnWerkLijst;
    public WerkArrayAdapter(Context context, List<Werk> objects) {
        super(context, -1, objects);
        this.mijnWerkLijst = objects;
        this.mijnContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mijnLayoutInflater = (LayoutInflater)mijnContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View mijnListViewItemView = mijnLayoutInflater.inflate(R.layout.listviewitem_werken, parent, false);

        ImageView imgAfbeelding = (ImageView)mijnListViewItemView.findViewById(R.id.imgAfbeeldingListViewitem);
        TextView lblWerkNaam = (TextView)mijnListViewItemView.findViewById(R.id.lblWerkNaam);
        TextView lblWerkAuteur = (TextView)mijnListViewItemView.findViewById(R.id.lblWerkAuteur);

        Werk weerTeGevenWerk = mijnWerkLijst.get(position);

        String naam = mijnContext.getString(weerTeGevenWerk.getNaam());
        String auteur = mijnContext.getString(weerTeGevenWerk.getAuteur());
        Drawable mijnFoto = ContextCompat.getDrawable(mijnContext, weerTeGevenWerk.getFoto());

        lblWerkNaam.setText(naam);
        lblWerkAuteur.setText(auteur);
        imgAfbeelding.setImageDrawable(mijnFoto);

        return mijnListViewItemView;
    }
}
