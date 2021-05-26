package com.guide.gameguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MapsAdapter extends RecyclerView.Adapter<MapsAdapter.MapsViewHolder> {
    Context context;
    int images[];
    public MapsAdapter(Context ct , int img[]){
              context = ct;
              images = img;
    }
    @NonNull
    @Override
    public MapsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
       View view =  layoutInflater.inflate(R.layout.mapsrow,parent,false);

        return new MapsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MapsViewHolder holder, int position) {
        holder.myImages.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MapsViewHolder extends RecyclerView.ViewHolder {
        ImageView myImages ;
        public MapsViewHolder(@NonNull View itemView) {
            super(itemView);
            myImages = itemView.findViewById(R.id.my_maps);
        }
    }
}
