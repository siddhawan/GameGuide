package com.guide.gameguide.ui.gundetail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guide.gameguide.R;
import com.guide.gameguide.csvreader.CSVFile;
import com.guide.gameguide.ui.vehicles.VehiclesAdapter;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;

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
    String s1[]=new String[51];
    String s2[]=new String[51];
    String s3[]=new String[51];
    String s4[]=new String[51];
    String s5[]=new String[51];
    String s6[]=new String[51];
    String s7[]=new String[51];
    String s8[]=new String[51];
    String s9[]=new String[51];
    String s10[]=new String[51];
    String s11[]=new String[51];
    String s12[]=new String[51];
    int image1[]=new int[51];

    int counter=0;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gun__detail, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.gunview);
        InputStream inputStream = getResources().openRawResource(R.raw.pubgweapon1);
        CSVFile csvFile = new CSVFile(inputStream);
        List scoreList = csvFile.read();

        for(Object a : scoreList)
        {
            String [] c  = (String[]) a;
            image1[counter]= getResId(c[0], R.drawable.class);
            s1[counter]=c[1];
            s2[counter]=c[2];
            s3[counter]=c[3];
            s4[counter]=c[4];
            s5[counter]=c[5];
            s6[counter]=c[6];
            s7[counter]=c[7];
            s8[counter]=c[8];
            s9[counter]=c[9];
            s10[counter]=c[10];
            s11[counter]=c[11];
            s12[counter]=c[12];




            //System.out.println(a);
            counter++;
        }

        GunAdapter gunAdapter = new GunAdapter(container.getContext(),s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,image1);
        recyclerView.setAdapter(gunAdapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));
        return  rootView;
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