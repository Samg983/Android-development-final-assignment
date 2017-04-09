package be.ehb.multec.museumapp.model;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import be.ehb.multec.museumapp.R;

/**
 * Created by SamGoeman on 06/01/2017.
 */

public class OpenPopUpPhoto extends Dialog implements android.view.View.OnClickListener {

    private Activity activity;
    private int imgSrc;

    public OpenPopUpPhoto() {
        super(null);
    }

    public OpenPopUpPhoto(Activity activity, int imgSrc) {
        super(activity);
        this.activity = activity;
        this.imgSrc = imgSrc;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.open_popup_photo);
        ImageView img = (ImageView) findViewById(R.id.imgPopUp);
        img.setImageResource(imgSrc);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
        dismiss();

    }
}
