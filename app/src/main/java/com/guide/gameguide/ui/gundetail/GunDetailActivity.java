package com.guide.gameguide.ui.gundetail;

import android.os.Bundle;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.guide.gameguide.R;
import com.guide.gameguide.csvreader.CSVFile;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GunDetailActivity extends AppCompatActivity {
    GunAdapter adapter;
    String t ;
    private TextView mTextView;
    List<String> list1=new ArrayList<String>();
    List<String> list2=new ArrayList<String>();
    List<String> list3=new ArrayList<String>();
    List<String> list4=new ArrayList<String>();
    List<String> list5=new ArrayList<String>();
    List<String> list6=new ArrayList<String>();
    List<String> list7=new ArrayList<String>();
    List<String> list8=new ArrayList<String>();
    List<String> list9=new ArrayList<String>();
    List<String> list10=new ArrayList<String>();
    List<String> list11=new ArrayList<String>();
    List<String> list12=new ArrayList<String>();
    List<Integer> img=new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gun_detail);

        RecyclerView recyclerView = findViewById(R.id.gundetailactivity);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Bundle bundle = getIntent().getExtras();
        t = bundle.getString("message");
        InputStream inputStream = getResources().openRawResource(R.raw.pubgweapon1);
        CSVFile csvFile = new CSVFile(inputStream);
        List scoreList = csvFile.read();

        for(Object a : scoreList) {
            String[] c = (String[]) a;
            if (c[0].startsWith(t)) {
                /*image1[counter] = getResId(c[0], R.drawable.class);
                s1[counter] = c[1];
                s2[counter] = c[2];
                s3[counter] = c[3];
                s4[counter] = c[4];
                s5[counter] = c[5];
                s6[counter] = c[6];
                s7[counter] = c[7];
                s8[counter] = c[8];
                s9[counter] = c[9];
                s10[counter] = c[10];
                s11[counter] = c[11];
                s12[counter] = c[12];
                counter++;*/
                list1.add(c[1]);
                list2.add(c[2]);
                list3.add(c[3]);
                list4.add(c[4]);
                list5.add(c[5]);
                list6.add(c[6]);
                list7.add(c[7]);
                list8.add(c[8]);
                list9.add(c[9]);
                list10.add(c[10]);
                list11.add(c[11]);
                list12.add(c[12]);
                img.add(getResId(c[0], R.drawable.class));


            }
        }
        adapter = new GunAdapter(this,list1.toArray(new String[list1.size()]),list2.toArray(new String[list2.size()]),list3.toArray(new String[list3.size()]),list4.toArray(new String[list4.size()]),list5.toArray(new String[list5.size()]),list6.toArray(new String[list6.size()]),list7.toArray(new String[list7.size()]),list8.toArray(new String[list8.size()]),list9.toArray(new String[list9.size()]),list10.toArray(new String[list10.size()]),list11.toArray(new String[list11.size()]),list12.toArray(new String[list12.size()]),img.stream().mapToInt(i->i).toArray());
       // adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
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