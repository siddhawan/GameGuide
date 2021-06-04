package com.guide.gameguide.ui.consumables;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guide.gameguide.R;


public class ConsumablesAdapter extends RecyclerView.Adapter<ConsumablesAdapter.ConsumablesViewHolder> {
    Context context;
    String data1[],data2[],data3[],data4 [];
    int images[];
    public ConsumablesAdapter(Context ct , String s1[] ,  String s2[],String s3[],String s4[], int img[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        data4 = s4;
        images = img;
    }
    @NonNull
    @Override
    public ConsumablesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =  layoutInflater.inflate(R.layout.consumableslist,parent,false);

        return new ConsumablesAdapter.ConsumablesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsumablesViewHolder holder, int position) {
        holder.myImages.setImageResource(images[position]);
        holder.t1.setText(data1[position]);
        holder.t2.setText(data2[position]);
        holder.t3.setText(data1[position]);
        holder.t4.setText(data2[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class ConsumablesViewHolder extends RecyclerView.ViewHolder {
        ImageView myImages ;
        TextView t1,t2,t3,t4;
        public ConsumablesViewHolder(@NonNull View itemView) {
            super(itemView);
            myImages = itemView.findViewById(R.id.consumeimage);
            t1 = itemView.findViewById(R.id.timetaken);
            t2 = itemView.findViewById(R.id.tcap);
            t3 = itemView.findViewById(R.id.condes);
            t4 = itemView.findViewById(R.id.consumablename);

        }
    }
}
