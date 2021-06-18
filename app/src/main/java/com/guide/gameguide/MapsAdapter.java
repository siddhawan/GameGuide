package com.guide.gameguide;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guide.gameguide.ui.DisplayMap;

import java.io.File;

public class MapsAdapter extends RecyclerView.Adapter<MapsAdapter.MapsViewHolder> {
    Context context;
    int images[];
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
    public MapsAdapter(Context ct ,int img[]){
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

    public class MapsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView myImages ;
        public MapsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            myImages = itemView.findViewById(R.id.my_maps);
        }

        @Override
        public void onClick(View v) {

            buttonClick.setDuration(1);
            v.startAnimation(buttonClick);
            if(getLayoutPosition()==0){
                Intent myIntent = new Intent(v.getContext(), DisplayMap.class);
                myIntent.putExtra("message",getLayoutPosition());
                v.getContext().startActivity(myIntent);

            }

            if(getLayoutPosition()==1){
                Intent myIntent = new Intent(v.getContext(), DisplayMap.class);
                myIntent.putExtra("message",getLayoutPosition());
                v.getContext().startActivity(myIntent);
            }

            if(getLayoutPosition()==2){
                Intent myIntent = new Intent(v.getContext(), DisplayMap.class);
                myIntent.putExtra("message",getLayoutPosition());
                v.getContext().startActivity(myIntent);
            }

            if(getLayoutPosition()==3){
                Intent myIntent = new Intent(v.getContext(), DisplayMap.class);
                myIntent.putExtra("message",getLayoutPosition());
                v.getContext().startActivity(myIntent);
            }

            if(getLayoutPosition()==4){
                Intent myIntent = new Intent(v.getContext(), DisplayMap.class);
                myIntent.putExtra("message",getLayoutPosition());
                v.getContext().startActivity(myIntent);
            }

        }
    }
}
