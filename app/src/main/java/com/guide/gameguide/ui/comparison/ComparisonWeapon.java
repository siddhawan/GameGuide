package com.guide.gameguide.ui.comparison;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.guide.gameguide.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ComparisonWeapon#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ComparisonWeapon extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ComparisonWeapon() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ComparisonWepon.
     */
    // TODO: Rename and change types and number of parameters
    public static ComparisonWeapon newInstance(String param1, String param2) {
        ComparisonWeapon fragment = new ComparisonWeapon();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    Spinner spinner1,spinner2;
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10,textView11,textView12;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_comparison_weapon, container, false);
        spinner1 = rootView.findViewById(R.id.spinner2);
        spinner2 = rootView.findViewById(R.id.spinner3);

        textView1 = rootView.findViewById(R.id.ammoans1);
        textView2 = rootView.findViewById(R.id.ammoans2);

        textView3 = rootView.findViewById(R.id.guntypeans1);
        textView4 = rootView.findViewById(R.id.guntypeans2);

        textView5 = rootView.findViewById(R.id.dmgheadans1);
        textView6 = rootView.findViewById(R.id.dmgheadans2);

        textView7 = rootView.findViewById(R.id.dmgbodyans1);
        textView8 = rootView.findViewById(R.id.dmgbodyans2);

        textView9 = rootView.findViewById(R.id.bulletspeedans1);
        textView10 = rootView.findViewById(R.id.bulletspeedans2);

        textView11 = rootView.findViewById(R.id.reloadans1);
        textView12 = rootView.findViewById(R.id.reloadans2);





        List<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("what");
        spinnerArray.add("you");
        spinnerArray.add("know");
        spinnerArray.add("about"); // use this function to add list dynamically
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        return rootView;
    }
}