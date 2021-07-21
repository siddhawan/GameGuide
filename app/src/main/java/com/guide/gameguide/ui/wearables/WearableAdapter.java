package com.guide.gameguide.ui.wearables;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guide.gameguide.R;

public class WearableAdapter  extends RecyclerView.Adapter<WearableAdapter.WearableViewHolder> {
    Context context;
    int[] image;
    String[] s1,s2,s3,s4;

    public WearableAdapter(Context context, int[] image, String[] s1, String[] s2, String[] s3, String[] s4) {
        this.context = context;
        this.image = image;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
    }

    @NonNull
    @Override
    public WearableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =  layoutInflater.inflate(R.layout.wearableslist,parent,false);
        return new WearableAdapter.WearableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WearableViewHolder holder, int position) {
        holder.myImages.setImageResource(image[position]);
        holder.t1.setText(s1[position]);
        holder.t2.setText(s2[position]);
        holder.t3.setText(s3[position]);
        holder.t4.setText(s4[position]);
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class WearableViewHolder extends RecyclerView.ViewHolder {

        ImageView myImages ;
        TextView t1,t2,t3,t4;

        public WearableViewHolder(@NonNull View itemView) {
            super(itemView);

            myImages = itemView.findViewById(R.id.wearbleimg);
            t1 =  itemView.findViewById(R.id.wearablename);
            t3 = itemView.findViewById(R.id.wearcapans);
            t2 = itemView.findViewById(R.id.weardurableans);
            t4 = itemView.findViewById(R.id.weardmgans);
        }
    }
}
