package com.guide.gameguide.ui.wearables;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guide.gameguide.R;
import com.guide.gameguide.csvreader.CSVFile;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WearablesList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WearablesList extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WearablesList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WearablesList.
     */
    // TODO: Rename and change types and number of parameters
    public static WearablesList newInstance(String param1, String param2) {
        WearablesList fragment = new WearablesList();
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
    RecyclerView recyclerView;
    List<Integer> img;
    List<String> l1,l2,l3,l4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        img=new ArrayList<Integer>();
        l1 = new ArrayList<String>();
        l2 = new ArrayList<String>();
        l3 = new ArrayList<String>();
        l4 = new ArrayList<String>();

        InputStream inputStream1 = getResources().openRawResource(R.raw.wearablescsv);
        CSVFile csvFile1 = new CSVFile(inputStream1);
        List scoreList1 = csvFile1.read();
        for(Object a : scoreList1) {
            String[] c = (String[]) a;
            l1.add(c[1]);
            l2.add(c[3]);
            l3.add(c[2]);
            l4.add(c[4]);
            img.add(getResId(c[0], R.drawable.class));
        }

        View view =  inflater.inflate(R.layout.fragment_wearables_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.wearableslistrecyclerview);

        WearableAdapter wearableAdapter = new WearableAdapter(container.getContext(),img.stream().mapToInt(i->i).toArray(), l1.toArray(new String[l1.size()]) , l2.toArray(new String[l1.size()]) , l3.toArray(new String[l1.size()]),l4.toArray(new String[l1.size()]));
        recyclerView.setAdapter(wearableAdapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));
        return view;
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