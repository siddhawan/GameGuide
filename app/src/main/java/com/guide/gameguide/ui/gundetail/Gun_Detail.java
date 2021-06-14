package com.guide.gameguide.ui.gundetail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guide.gameguide.R;
import com.guide.gameguide.ui.vehicles.VehiclesAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Gun_Detail#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Gun_Detail extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Gun_Detail() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Gun_Detail.
     */
    // TODO: Rename and change types and number of parameters
    public static Gun_Detail newInstance(String param1, String param2) {
        Gun_Detail fragment = new Gun_Detail();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /* assign all vaues to all 12 fields as String arrays and images name here*/
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gun__detail, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.gunview);

        GunAdapter gunAdapter = new GunAdapter(container.getContext(),/*all arrays*/);
        recyclerView.setAdapter(gunAdapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));
        return  rootView;
    }
}