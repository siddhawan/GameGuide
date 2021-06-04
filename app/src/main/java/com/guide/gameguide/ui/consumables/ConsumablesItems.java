package com.guide.gameguide.ui.consumables;

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
 * Use the {@link ConsumablesItems#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsumablesItems extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConsumablesItems() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsumablesItems.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsumablesItems newInstance(String param1, String param2) {
        ConsumablesItems fragment = new ConsumablesItems();
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
    int images[] = {R.drawable.map1 , R.drawable.map2 , R.drawable.map3
    };
    String s1[] = {"car","truck","van"};
    String s2[] = {"1000hp","2000hp","1500hp"};
    String s3[] = {"100km/h","50km/h","80km/h"};
    String s4[] = {"4","10","5"};
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_consumables_items, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.listconsumables);
        ConsumablesAdapter consumablesAdapter = new ConsumablesAdapter(container.getContext(),s1,s2,s3,s4,images);
        recyclerView.setAdapter(consumablesAdapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));
        return  rootView;
    }
}