package com.guide.gameguide.ui.dmgprofile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.guide.gameguide.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DamageProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DamageProfile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DamageProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DamageProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static DamageProfile newInstance(String param1, String param2) {
        DamageProfile fragment = new DamageProfile();
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
    Spinner spinner1,spinner2,spinner3;
    ImageView imageView1;
    TextView head,neck,clavicles,upperchest,lowerchest,stomach,pelvis,Upperlimb1,upperlimb2,lowerlimb1,lowerlimb2 ,hand_foot1,hand_foot2;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_damage_profile, container, false);
        spinner1 = view.findViewById(R.id.dmgprofilegunspinner);
        spinner2 = view.findViewById(R.id.dmgprofilehelmetspinner);
        spinner3 = view.findViewById(R.id.dmgprofilevestspinner);

        imageView1 = view.findViewById(R.id.personfigure);

        head = view.findViewById(R.id.headdmgans);

        neck = view.findViewById(R.id.neckans);
        clavicles = view.findViewById(R.id.cans);
        upperchest = view.findViewById(R.id.chestans);
        lowerchest = view.findViewById(R.id.ucheshans);
        stomach = view.findViewById(R.id.stoans);
        pelvis = view.findViewById(R.id.pelans);
        Upperlimb1 = view.findViewById(R.id.uarmans);
        upperlimb2 = view.findViewById(R.id.ulegans);
        lowerlimb1 = view.findViewById(R.id.larmans);
        lowerlimb2 = view.findViewById(R.id.llegans);
        hand_foot1 = view.findViewById(R.id.hand1);
        hand_foot2 = view.findViewById(R.id.footans);




       return view;
    }
}