package com.guide.gameguide.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.guide.gameguide.R;

public class DisplayMap extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int Message;
    PhotoView photoView;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaymap);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                mAdView = findViewById(R.id.adView);
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);
            }
        });


         photoView = (PhotoView) findViewById(R.id.photo_view);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.mapstoggle, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Bundle bundle = getIntent().getExtras();
        int message = bundle.getInt("message");
        Message = message;
        Log.d("message",String.valueOf(message));
        spinner.setOnItemSelectedListener(this);

        if(message == 0){photoView.setImageResource(R.drawable.er01);
        }
        if(message == 1){photoView.setImageResource(R.drawable.mi01);}
        if(message == 2){photoView.setImageResource(R.drawable.sa01);}
        if(message == 3){photoView.setImageResource(R.drawable.vi01);}
        if(message == 4){photoView.setImageResource(R.drawable.ka01);}
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(Message == 0 && position==0){
            photoView.setImageResource(R.drawable.er01);
        }
        if(Message == 0 && position == 1){
            photoView.setImageResource(R.drawable.er02);
        }
        if(Message == 0 && position == 2){
            photoView.setImageResource(R.drawable.er03);
        }
        if(Message == 0 && position == 3){
            photoView.setImageResource(R.drawable.er04);
        }
        if(Message == 0 && position == 4){
            photoView.setImageResource(R.drawable.er05);
        }
        if(Message == 0 && position == 5){
            photoView.setImageResource(R.drawable.er06);
        }


        if(Message == 1 && position == 0){
            photoView.setImageResource(R.drawable.mi01);
        }
        if(Message == 1 && position == 1){
            photoView.setImageResource(R.drawable.mi02);
        }
        if(Message == 1 && position == 2){
            photoView.setImageResource(R.drawable.mi03);
        }
        if(Message == 1 && position == 3){
            photoView.setImageResource(R.drawable.mi01);
        }
        if(Message == 1 && position == 4){
            photoView.setImageResource(R.drawable.mi01);
        }
        if(Message == 1 && position == 5){
            photoView.setImageResource(R.drawable.mi04);
        }


        if(Message == 2 && position == 0){
            photoView.setImageResource(R.drawable.sa01);
        }
        if(Message == 2 && position == 1){
            photoView.setImageResource(R.drawable.sa02);
        }
        if(Message == 2 && position == 2){
            photoView.setImageResource(R.drawable.sa02);
        }
        if(Message == 2 && position == 3){
            photoView.setImageResource(R.drawable.sa03);
        }
        if(Message == 2 && position == 4){
            photoView.setImageResource(R.drawable.sa01);
        }
        if(Message == 2 && position == 5){
            photoView.setImageResource(R.drawable.sa04);
        }


        if(Message == 3 && position == 0){
            photoView.setImageResource(R.drawable.vi01);
        }
        if(Message == 3 && position == 1){
            photoView.setImageResource(R.drawable.vi02);
        }
        if(Message == 3 && position == 2){
            photoView.setImageResource(R.drawable.vi03);
        }
        if(Message == 3 && position == 3){
            photoView.setImageResource(R.drawable.vi01);
        }
        if(Message == 3 && position == 4){
            photoView.setImageResource(R.drawable.vi05);
        }
        if(Message == 3 && position == 5){
            photoView.setImageResource(R.drawable.vi05);
        }


        if(Message == 4 && position == 0){
            photoView.setImageResource(R.drawable.ka01);
        }
        if(Message == 4 && position == 1){
            photoView.setImageResource(R.drawable.ka02);
        }
        if(Message == 4 && position == 2){
            photoView.setImageResource(R.drawable.ka02);
        }
        if(Message == 4 && position == 3){
            photoView.setImageResource(R.drawable.ka02);
        }
        if(Message == 4 && position == 4){
            photoView.setImageResource(R.drawable.ka02);
        }
        if(Message == 4 && position == 5){
            photoView.setImageResource(R.drawable.ka02);
        }




    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}

