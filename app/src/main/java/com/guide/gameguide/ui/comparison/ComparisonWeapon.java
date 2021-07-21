package com.guide.gameguide.ui.comparison;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.guide.gameguide.R;
import com.guide.gameguide.csvreader.CSVFile;

import java.io.Console;
import java.io.InputStream;
import java.lang.reflect.Field;
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
    ImageView imageView1,imageView2;
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

        imageView1 = rootView.findViewById(R.id.gun1);
        imageView2 = rootView.findViewById(R.id.gun2);
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


        List<Integer> img=new ArrayList<Integer>();
        InputStream inputStream1 = getResources().openRawResource(R.raw.damage);
        CSVFile csvFile1 = new CSVFile(inputStream1);
        List scoreList1 = csvFile1.read();
        List<String> dataArray0 = new ArrayList<String>();
        List<String> dataArray1 = new ArrayList<String>();

        List<String> spinnerArray1 = new ArrayList<String>();
        for(Object a : scoreList1) {
            String[] c = (String[]) a;
                dataArray0.add(c[0]);
            dataArray1.add(c[2]);
                spinnerArray1.add(c[1]);
            img.add(getResId(c[0], R.drawable.class));
        }


        InputStream inputStream2 = getResources().openRawResource(R.raw.pubgweapon1);
        CSVFile csvFile2 = new CSVFile(inputStream2);
        List scoreList2 = csvFile2.read();
        List<String> datafind = new ArrayList<String>();
        List<String> dataArray2 = new ArrayList<String>();
        List<String> dataArray3 = new ArrayList<String>();
        List<String> dataArray4 = new ArrayList<String>();
        List<String> dataArray5 = new ArrayList<String>();
        for(Object a : scoreList2) {
            String[] c = (String[]) a;
            datafind.add(c[0]);
            dataArray2.add(c[2]);
            dataArray3.add(c[3]);
            dataArray4.add(c[9]);
            dataArray5.add(c[11]);
        }

 // use this function to add list dynamically
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, spinnerArray1);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageView1.setImageResource(img.get(position));
                textView1.setText(dataArray2.get(datafind.indexOf(dataArray0.get(position))));
                if (dataArray0.get(position).startsWith("ar")){
                    textView3.setText("Assault Rifle");
                }
                else if (dataArray0.get(position).startsWith("cr")){
                    textView3.setText("Cross Bow");
                }else if (dataArray0.get(position).startsWith("lm")){
                    textView3.setText("LMG");
                }else if (dataArray0.get(position).startsWith("sm")){
                    textView3.setText("SMG");
                }else if (dataArray0.get(position).startsWith("ba")){
                    textView3.setText("Bolt Action");
                }else if (dataArray0.get(position).startsWith("pt")){
                    textView3.setText("Pistol");
                }else if (dataArray0.get(position).startsWith("sh")){
                    textView3.setText("Shotgun");
                }else if (dataArray0.get(position).startsWith("me")){
                    textView3.setText("Melee");
                }else if (dataArray0.get(position).startsWith("dm")){
                    textView3.setText("DMR");
                }


                textView5.setText(dataArray1.get(position));
                textView7.setText(dataArray3.get(datafind.indexOf(dataArray0.get(position))));
                textView11.setText(dataArray4.get(datafind.indexOf(dataArray0.get(position))));
                textView9.setText(dataArray5.get(datafind.indexOf(dataArray0.get(position))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageView2.setImageResource(img.get(position));
                textView2.setText(dataArray2.get(datafind.indexOf(dataArray0.get(position))));
                if (dataArray0.get(position).startsWith("ar")){
                    textView4.setText("Assault Rifle");
                }
                else if (dataArray0.get(position).startsWith("cr")){
                    textView4.setText("Cross Bow");
                }else if (dataArray0.get(position).startsWith("lm")){
                    textView4.setText("LMG");
                }else if (dataArray0.get(position).startsWith("sm")){
                    textView4.setText("SMG");
                }else if (dataArray0.get(position).startsWith("ba")){
                    textView4.setText("Bolt Action");
                }else if (dataArray0.get(position).startsWith("pt")){
                    textView4.setText("Pistol");
                }else if (dataArray0.get(position).startsWith("sh")){
                    textView4.setText("Shotgun");
                }else if (dataArray0.get(position).startsWith("me")){
                    textView4.setText("Melee");
                }else if (dataArray0.get(position).startsWith("dm")){
                    textView4.setText("DMR");
                }
                textView6.setText(dataArray1.get(position));
                textView8.setText(dataArray3.get(datafind.indexOf(dataArray0.get(position))));
                textView12.setText(dataArray4.get(datafind.indexOf(dataArray0.get(position))));
                textView10.setText(dataArray5.get(datafind.indexOf(dataArray0.get(position))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return rootView;
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