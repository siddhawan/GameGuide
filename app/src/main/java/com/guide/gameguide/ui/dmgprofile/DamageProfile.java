package com.guide.gameguide.ui.dmgprofile;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.guide.gameguide.R;
import com.guide.gameguide.csvreader.CSVFile;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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
    List<String> headl = new ArrayList<String>();
    List<String> neckl = new ArrayList<String>();
    List<String> claviclesl = new ArrayList<String>();
    List<String> upperchestl = new ArrayList<String>();
    List<String> lowerchestl =new ArrayList<String>();
    List<String> stomachl = new ArrayList<String>();
    List<String> pelvisl =new ArrayList<String>();
    List<String> upperlimbl = new ArrayList<String>();
    List<String> lowerlimbl = new ArrayList<String>();
    List<String> hand_footl =new ArrayList<String>();

    Switch switchDm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_damage_profile, container, false);
        spinner1 = view.findViewById(R.id.dmgprofilegunspinner);
        spinner2 = view.findViewById(R.id.dmgprofilehelmetspinner);
        spinner3 = view.findViewById(R.id.dmgprofilevestspinner);
        switchDm= view.findViewById(R.id.switch1);
        switchDm.setText("Damage");
        switchDm.requestLayout();
        List<String> spinnerArray1 = new ArrayList<String>();
        List<String> spinnerArray2 = new ArrayList<String>();
        List<String> spinnerArray3 = new ArrayList<String>();
        spinnerArray2.add("No Helmet");
        spinnerArray2.add("level 1");
        spinnerArray2.add("level 2");
        spinnerArray2.add("level 3");
        spinnerArray3.add("No vest");
        spinnerArray3.add("level 1");
        spinnerArray3.add("level 2");
        spinnerArray3.add("level 3");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, spinnerArray2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, spinnerArray3);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
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

        List<Integer> img=new ArrayList<Integer>();
        InputStream inputStream1 = getResources().openRawResource(R.raw.damage);
        CSVFile csvFile1 = new CSVFile(inputStream1);
        List scoreList1 = csvFile1.read();


        for(Object a : scoreList1) {
            String[] c = (String[]) a;

            headl.add(c[2]);
            neckl.add(c[3]);
            claviclesl.add(c[4]);
            upperchestl.add(c[5]);
            lowerchestl.add(c[6]);
            stomachl.add(c[7]);
            pelvisl.add(c[8]);
            upperlimbl.add(c[9]);
            lowerlimbl.add(c[10]);
            hand_footl.add(c[11]);
            spinnerArray1.add(c[1]);

        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, spinnerArray1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setdata();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setdata();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setdata();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

      switchDm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              setdata();
          }
      });

       return view;
    }
    public void setdata(){
        int position1=spinner1.getSelectedItemPosition();
        int position2=spinner2.getSelectedItemPosition();
        int position3=spinner3.getSelectedItemPosition();

        Upperlimb1.setText(upperlimbl.get(position1));
        upperlimb2.setText(upperlimbl.get(position1));
        lowerlimb1.setText(lowerlimbl.get(position1));
        lowerlimb2.setText(lowerlimbl.get(position1));
        hand_foot1.setText(hand_footl.get(position1));
        hand_foot2.setText(hand_footl.get(position1));
        neck.setText(neckl.get(position1));
        head.setText(headl.get(position1));
        clavicles.setText(claviclesl.get(position1));
        upperchest.setText(upperchestl.get(position1));
        lowerchest.setText(lowerchestl.get(position1));
        stomach.setText(stomachl.get(position1));
        pelvis.setText(pelvisl.get(position1));
        double num,num2,num3,num4,num5;
        int numyy;
        if (position2==1)
        {
            num= Double.parseDouble(headl.get(position1)) * 0.7;
            num2= Double.parseDouble(neckl.get(position1)) * 0.7;
            neck.setText(String.format("%.1f", num2));
            head.setText(String.format("%.1f", num));

        }else if(position2==2){

            num= Double.parseDouble(headl.get(position1)) * 0.6;
            num2= Double.parseDouble(neckl.get(position1)) * 0.6;
            neck.setText(String.format("%.1f", num2));
            head.setText(String.format("%.1f", num));
        }else if(position2==3){

            num= Double.parseDouble(headl.get(position1)) * 0.45;
            num2= Double.parseDouble(neckl.get(position1)) * 0.45;
            neck.setText(String.format("%.1f", num2));
            head.setText(String.format("%.1f", num));
        }

        if (position3==1)
        {
            num= Double.parseDouble(claviclesl.get(position1)) * 0.7;
            num2= Double.parseDouble(upperchestl.get(position1)) * 0.7;
            num3= Double.parseDouble(lowerchestl.get(position1)) * 0.7;
            num4= Double.parseDouble(stomachl.get(position1)) * 0.7;
            num5= Double.parseDouble(pelvisl.get(position1)) * 0.7;
            clavicles.setText(String.format("%.1f", num));
            upperchest.setText(String.format("%.1f", num2));
            lowerchest.setText(String.format("%.1f", num3));
            stomach.setText(String.format("%.1f", num4));
            pelvis.setText(String.format("%.1f", num5));

        }else if(position3==2){

            num= Double.parseDouble(claviclesl.get(position1)) * 0.6;
            num2= Double.parseDouble(upperchestl.get(position1)) * 0.6;
            num3= Double.parseDouble(lowerchestl.get(position1)) * 0.6;
            num4= Double.parseDouble(stomachl.get(position1)) * 0.6;
            num5= Double.parseDouble(pelvisl.get(position1)) * 0.6;
            clavicles.setText(String.format("%.1f", num));
            upperchest.setText(String.format("%.1f", num2));
            lowerchest.setText(String.format("%.1f", num3));
            stomach.setText(String.format("%.1f", num4));
            pelvis.setText(String.format("%.1f", num5));
        }else if(position3==3){

            num= Double.parseDouble(claviclesl.get(position1)) * 0.45;
            num2= Double.parseDouble(upperchestl.get(position1)) * 0.45;
            num3= Double.parseDouble(lowerchestl.get(position1)) * 0.45;
            num4= Double.parseDouble(stomachl.get(position1)) * 0.45;
            num5= Double.parseDouble(pelvisl.get(position1)) * 0.45;
            clavicles.setText(String.format("%.1f", num));
            upperchest.setText(String.format("%.1f", num2));
            lowerchest.setText(String.format("%.1f", num3));
            stomach.setText(String.format("%.1f", num4));
            pelvis.setText(String.format("%.1f", num5));
        }

        if (switchDm.isChecked())
        {

            switchDm.setText("Hits");
             numyy =(int)Math.ceil(100/(Double.valueOf(Upperlimb1.getText().toString())));

            Upperlimb1.setText(String.valueOf(numyy));
            numyy =(int)Math.ceil(100/(Double.valueOf(upperlimb2.getText().toString())));
            upperlimb2.setText(String.valueOf(numyy));
            numyy =(int)Math.ceil(100/(Double.valueOf(lowerlimb1.getText().toString())));
            lowerlimb1.setText(String.valueOf(numyy));
            numyy =(int)Math.ceil(100/(Double.valueOf(lowerlimb2.getText().toString())));
            lowerlimb2.setText(String.valueOf(numyy));
            numyy =(int)Math.ceil(100/(Double.valueOf(hand_foot1.getText().toString())));
            hand_foot1.setText(String.valueOf(numyy));
            numyy =(int)Math.ceil(100/(Double.valueOf(hand_foot2.getText().toString())));
            hand_foot2.setText(String.valueOf(numyy));
            numyy =(int)Math.ceil(100/(Double.valueOf(neck.getText().toString())));
            neck.setText(String.valueOf(numyy));
            numyy =(int)Math.ceil(100/(Double.valueOf(head.getText().toString())));
            head.setText(String.valueOf(numyy));
            numyy =(int)Math.ceil(100/(Double.valueOf(clavicles.getText().toString())));
            clavicles.setText(String.valueOf(numyy));
            numyy =(int)Math.ceil(100/(Double.valueOf(upperchest.getText().toString())));
            upperchest.setText(String.valueOf(numyy));
             numyy =(int)Math.ceil(100/(Double.valueOf(lowerchest.getText().toString())));
            lowerchest.setText(String.valueOf(numyy));
            numyy =(int)Math.ceil(100/(Double.valueOf(stomach.getText().toString())));
            stomach.setText(String.valueOf(numyy));
            numyy =(int)Math.ceil(100/(Double.valueOf(pelvis.getText().toString())));
            pelvis.setText(String.valueOf(numyy));

        }
        else
            {

                switchDm.setText("Damage");



        }
        DrawableCompat.setTintList(switchDm.getThumbDrawable(), new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_checked},
                        new int[]{}
                },
                new int[]{
                        Color.parseColor("#ffcc0000"),
                        Color.GRAY
                }));



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