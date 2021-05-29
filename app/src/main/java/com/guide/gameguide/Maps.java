package com.guide.gameguide;

import androidx.lifecycle.ViewModelProvider;

import android.content.ContextWrapper;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;

public class Maps extends Fragment {

    private Title1ViewModel mViewModel;

    public static Maps newInstance() {
        return new Maps();
    }
    int images[] = {R.drawable.map1 , R.drawable.map2 ,getResId("a", R.drawable.class)};



    RecyclerView recyclerView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ContextWrapper cw = new ContextWrapper(container.getContext());


        View rootView = inflater.inflate(R.layout.fragment_title1, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.mapsRecycle);
        MapsAdapter mapsAdapter = new MapsAdapter(container.getContext(),images);
        recyclerView.setAdapter(mapsAdapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));


        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Title1ViewModel.class);
        // TODO: Use the ViewModel
    }


    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}