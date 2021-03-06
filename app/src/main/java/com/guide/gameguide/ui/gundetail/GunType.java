package com.guide.gameguide.ui.gundetail;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guide.gameguide.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GunType#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GunType extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GunType() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GunType.
     */
    // TODO: Rename and change types and number of parameters
    public static GunType newInstance(String param1, String param2) {
        GunType fragment = new GunType();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static void onBackPressed() {
        
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    RecyclerView recyclerView;
    TextView nameofguns;
    String[] gunname = {"Assault Rifle", "DMR" , "SMG" , "LMG" , "Sniper" , "Pistol" , "Melee" , "Shotguns" , "Crossbow"};
    int image[] = {R.drawable.assault_rifles,R.drawable.dmr,R.drawable.smg,R.drawable.lmg,R.drawable.sniper_rifle,R.drawable.pistol,R.drawable.melee,R.drawable.shotguns,R.drawable.crossbow};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_gun_type, container, false);
         recyclerView = (RecyclerView) rootView.findViewById(R.id.guntypere);
        GunTypeAdapter gunTypeAdapter = new GunTypeAdapter(container.getContext(),image,gunname);
        recyclerView.setAdapter(gunTypeAdapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));
        return  rootView;

    }
}