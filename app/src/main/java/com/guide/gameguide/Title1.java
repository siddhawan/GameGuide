package com.guide.gameguide;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Title1 extends Fragment {

    private Title1ViewModel mViewModel;

    public static Title1 newInstance() {
        return new Title1();
    }
    int images[] = {R.drawable.map1 , R.drawable.map2 , R.drawable.map3
    };
    RecyclerView recyclerView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
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

}