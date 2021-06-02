package com.guide.gameguide.ui.weapon;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.guide.gameguide.R;
import com.guide.gameguide.csvreader.CSVFile;
import com.guide.gameguide.ui.vehicles.VehiclesAdapter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeaponList extends Fragment {

    private HomeViewModel homeViewModel;
    int images[] = {R.drawable.map1 , R.drawable.map2 , R.drawable.map3
    };


    RecyclerView recyclerView;
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        InputStream inputStream = getResources().openRawResource(R.raw.demo1);
        CSVFile csvFile = new CSVFile(inputStream);
        List scoreList= new ArrayList();
        scoreList = csvFile.read();
        //
        for(Object sa : scoreList) {
            //String[] Strval = sa.t;
            //Log.e("onCreateView: ",System.out.println(x)  );
            //System.out.println(Arrays.toString(sa));

            String[] a = (String[]) sa;
            System.out.println(a[1]);

        }

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}