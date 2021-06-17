package com.guide.gameguide.ui.gundetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.guide.gameguide.R;
import com.guide.gameguide.ui.vehicles.VehiclesAdapter;

public class GunAdapter extends RecyclerView.Adapter<GunAdapter.GunViewHolder> {
    Context context;
    String data1[],data2[],data3[],data4[],data5[],data6[],data7[],data8[],data9[],data10[],data11[],data12[];
    int images[];


    public GunAdapter(Context ct, String s1[], String s2[], String s3[], String s4[], String s5[], String s6[], String s7[], String s8[], String s9[], String s10[], String s11[], String s12[], int img[]){
        this.context = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        data4 = s4;
        data5 = s5;
        data6 = s6;
        data7 = s7;
        data8 = s8;
        data9 = s9;
        data10 = s10;
        data11 = s11;
        data12 = s12;
        images = img;
    }

    @NonNull
    @Override
    public GunViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =  layoutInflater.inflate(R.layout.gunlist,parent,false);

        return new GunAdapter.GunViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GunViewHolder holder, int position) {

        holder.myImages.setImageResource(images[position]);
        holder.t1.setText(data1[position]);
        holder.t2.setText(data2[position]);
        holder.t3.setText(data3[position]);
        holder.t4.setText(data4[position]);

        holder.t5.setText(data5[position]);
        holder.t6.setText(data6[position]);
        holder.t7.setText(data7[position]);
        holder.t8.setText(data8[position]);
        holder.t9.setText(data9[position]);

        holder.t10.setText(data10[position]);
        holder.t11.setText(data11[position]);
        holder.t12.setText(data12[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class GunViewHolder extends RecyclerView.ViewHolder {
        ImageView myImages ;
        TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
        public GunViewHolder(@NonNull View itemView) {
            super(itemView);

            myImages = itemView.findViewById(R.id.gunimg);
            t1 =  itemView.findViewById(R.id.gunname);

            t2 = itemView.findViewById(R.id.ammotype);
            t3 = itemView.findViewById(R.id.hitdmg);
            t4 = itemView.findViewById(R.id.hitimpact);

            t5 =  itemView.findViewById(R.id.attchpts);
            t6 = itemView.findViewById(R.id.defmagsize);
            t7 = itemView.findViewById(R.id.extendedmagsize);
            t8 = itemView.findViewById(R.id.firingmode);

            t9 =  itemView.findViewById(R.id.drt);
            t10 = itemView.findViewById(R.id.qrt);
            t11 = itemView.findViewById(R.id.bulletspeed);
            t12 = itemView.findViewById(R.id.spawn);

//            t1 =  itemView.findViewById(R.id.gunname);
//            t3 = itemView.findViewById(R.id.speedvalue);
//            t2 = itemView.findViewById(R.id.helthvalue);
//            t4 = itemView.findViewById(R.id.capacityvalue);

        }
    }
    public static  void onBackPressed()
    {
        //AppCompatActivity activity = (AppCompatActivity)getContext();
        //popBackStack();
        //Fragment myFragment = new GunType();
        //getSupportFragmentManager().beginTransaction().replace(R.id.callfrag, myFragment).addToBackStack("old").commit();
    }
}
