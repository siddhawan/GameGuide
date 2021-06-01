package com.guide.gameguide.ui.weapon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guide.gameguide.R;
import com.guide.gameguide.ui.vehicles.VehiclesAdapter;

public class WeaponAdapter extends RecyclerView.Adapter<com.guide.gameguide.ui.weapon.WeaponAdapter.WeaponViewHolder>{
        Context context;
        String data1[];
        int images[];

        public WeaponAdapter(Context ct , String s1[] , int img[]){
            context = ct;
            data1 = s1;
            images = img;
        }
        @NonNull
        @Override
        public com.guide.gameguide.ui.weapon.WeaponAdapter.WeaponViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view =  layoutInflater.inflate(R.layout.vehicleslist,parent,false);

            return new com.guide.gameguide.ui.weapon.WeaponAdapter.WeaponViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull com.guide.gameguide.ui.weapon.WeaponAdapter.WeaponViewHolder holder, int position) {
            holder.myImages.setImageResource(images[position]);
            holder.t1.setText(data1[position]);

        }

        @Override
        public int getItemCount() {
            return data1.length;
        }

        public class WeaponViewHolder extends RecyclerView.ViewHolder {
            ImageView myImages ;
            TextView t1;
            public WeaponViewHolder(@NonNull View itemView) {
                super(itemView);

                myImages = itemView.findViewById(R.id.imageVehicles);
                t1 =  itemView.findViewById(R.id.name);
            }
        }
    }


