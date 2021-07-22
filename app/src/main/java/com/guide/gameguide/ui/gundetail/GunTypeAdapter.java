package com.guide.gameguide.ui.gundetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.guide.gameguide.R;
import com.guide.gameguide.ui.DisplayMap;
import com.guide.gameguide.ui.slideshow.SlideshowFragment;

public class GunTypeAdapter extends RecyclerView.Adapter<GunTypeAdapter.GunTypeViewHolder> {

    Context context ;
    int img[];
    String names[];
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
    public GunTypeAdapter(Context ct, int[] image,String[] name) {
        context = ct;
        img = image;
        names = name;

    }

    @NonNull
    @Override
    public GunTypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =  layoutInflater.inflate(R.layout.guntypelist,parent,false);

        return new GunTypeAdapter.GunTypeViewHolder(view);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull GunTypeViewHolder holder, int position) {
        holder.myImages.setImageResource(img[position]);
        holder.t.setText(names[position]);

    }


    @Override
    public int getItemCount() {
        return img.length;
    }

    public class GunTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView myImages;
        TextView t ;
        public GunTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            myImages = itemView.findViewById(R.id.guntypelist);
            t = itemView.findViewById(R.id.gunnameonimage);
        }

        @Override
        public void onClick(View v) {

            buttonClick.setDuration(1);
            v.startAnimation(buttonClick);
            //go through each item if you have few items within recycler view
            if(getLayoutPosition()==0){
                //Do whatever you want here
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                Fragment myFragment = new Gun_Detail("ar");
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.callfrag, myFragment).addToBackStack("old").commit();

                Intent myIntent = new Intent(v.getContext(), GunDetailActivity.class);
                myIntent.putExtra("message","ar");
                v.getContext().startActivity(myIntent);

            }else if(getLayoutPosition()==1){
                //Do whatever you want here
                //Toast.makeText(v.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                Fragment myFragment = new Gun_Detail("dm");
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.callfrag, myFragment).commit();

                Intent myIntent = new Intent(v.getContext(), GunDetailActivity.class);
                myIntent.putExtra("message","dm");
                v.getContext().startActivity(myIntent);

            }
            else if(getLayoutPosition()==2){
               // Toast.makeText(v.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                Fragment myFragment = new Gun_Detail("sm");
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.callfrag, myFragment).commit();

                Intent myIntent = new Intent(v.getContext(), GunDetailActivity.class);
                myIntent.putExtra("message","sm");
                v.getContext().startActivity(myIntent);
            }
            else if(getLayoutPosition()==3){
                //Do whatever you want here
                //Toast.makeText(v.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                Fragment myFragment = new Gun_Detail("lm");
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.callfrag, myFragment).commit();

                Intent myIntent = new Intent(v.getContext(), GunDetailActivity.class);
                myIntent.putExtra("message","lm");
                v.getContext().startActivity(myIntent);

            }
            else if(getLayoutPosition()==4){
                //Do whatever you want here
               // Toast.makeText(v.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                Fragment myFragment = new Gun_Detail("ba");
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.callfrag, myFragment).commit();
                Intent myIntent = new Intent(v.getContext(), GunDetailActivity.class);
                myIntent.putExtra("message","ba");
                v.getContext().startActivity(myIntent);

            }
            else if(getLayoutPosition()==5){
                //Do whatever you want here
                //Toast.makeText(v.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                Fragment myFragment = new Gun_Detail("pt");
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.callfrag, myFragment).commit();
                Intent myIntent = new Intent(v.getContext(), GunDetailActivity.class);
                myIntent.putExtra("message","pt");
                v.getContext().startActivity(myIntent);

            }
            else if(getLayoutPosition()==6){
                //Do whatever you want here
               // Toast.makeText(v.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                Fragment myFragment = new Gun_Detail("me");
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.callfrag, myFragment).commit();
                Intent myIntent = new Intent(v.getContext(), GunDetailActivity.class);
                myIntent.putExtra("message","me");
                v.getContext().startActivity(myIntent);

            }
            else if(getLayoutPosition()==7){
                //Do whatever you want here
                //Toast.makeText(v.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                Fragment myFragment = new Gun_Detail("sh");
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.callfrag, myFragment).commit();

                Intent myIntent = new Intent(v.getContext(), GunDetailActivity.class);
                myIntent.putExtra("message","sh");
                v.getContext().startActivity(myIntent);

            }
            else if(getLayoutPosition()==8){
                //Do whatever you want here
                // Toast.makeText(v.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                Fragment myFragment = new Gun_Detail("cr");
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.callfrag, myFragment).commit();

                Intent myIntent = new Intent(v.getContext(), GunDetailActivity.class);
                myIntent.putExtra("message","cr");
                v.getContext().startActivity(myIntent);

            }

        }

    }
}
