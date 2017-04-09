package be.ehb.multec.museumapp.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

import be.ehb.multec.museumapp.R;
import java.lang.String;
import be.ehb.multec.museumapp.model.Zaal;

/**
 * Created by SamGoeman on 07/12/2016.
 */

public class ZaalArrayAdapter extends ArrayAdapter<Zaal> {
    private Context mijnContext;
    private List<Zaal> mijnZaalLijst;

    public ZaalArrayAdapter(Context context, List<Zaal> objects) {
        super(context, -1, objects);
        this.mijnZaalLijst = objects;
        this.mijnContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mijnLayoutInflater = (LayoutInflater) mijnContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View mijnListViewItemView = mijnLayoutInflater.inflate(R.layout.listviewitem_zalen, parent, false);
        TextView lblZaalNaam = (TextView) mijnListViewItemView.findViewById(R.id.lblZaalNaam);

        Zaal weerTeGevenZaal = mijnZaalLijst.get(position);

        String naamZaal = mijnContext.getString(weerTeGevenZaal.getNaam());
        Drawable mijnFoto = ContextCompat.getDrawable(mijnContext, weerTeGevenZaal.getFoto());

        lblZaalNaam.setText(naamZaal);
        lblZaalNaam.setBackground(mijnFoto);

        return mijnListViewItemView;
    }
}
