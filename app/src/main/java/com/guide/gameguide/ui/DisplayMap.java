package com.guide.gameguide.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.github.chrisbanes.photoview.PhotoView;
import com.guide.gameguide.R;

public class DisplayMap extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaymap);
        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        Bundle bundle = getIntent().getExtras();
        int message = bundle.getInt("message");
        Log.d("message",String.valueOf(message));
        if(message == 0){photoView.setImageResource(R.drawable.er01);}
        if(message == 1){photoView.setImageResource(R.drawable.mi01);}
        if(message == 2){photoView.setImageResource(R.drawable.sa01);}
        if(message == 3){photoView.setImageResource(R.drawable.vi01);}
        if(message == 4){photoView.setImageResource(R.drawable.ka01);}
    }
}

