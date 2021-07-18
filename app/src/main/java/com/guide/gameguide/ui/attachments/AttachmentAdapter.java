package com.guide.gameguide.ui.attachments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guide.gameguide.R;



public class AttachmentAdapter extends RecyclerView.Adapter<AttachmentAdapter.AttachmentViewHolder> {

    Context context;
    String data1[],data2[],data3[];
    int images[];

    public AttachmentAdapter(Context ct, int[] attachImage,String[] nameAtt , String[] informationAtt)
    {
        data1 = nameAtt;
        data2 = informationAtt;
        images = attachImage;
        context = ct;
    }
    @NonNull
    @Override
    public AttachmentAdapter.AttachmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =  layoutInflater.inflate(R.layout.attachmentcardviewpage,parent,false);

        return new AttachmentAdapter.AttachmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttachmentAdapter.AttachmentViewHolder holder, int position) {
        holder.myImages.setImageResource(images[position]);
        holder.t1.setText(data1[position]);
        holder.t2.setText(data2[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class AttachmentViewHolder extends RecyclerView.ViewHolder {
        ImageView myImages ;
        TextView t1,t2;
        public AttachmentViewHolder(@NonNull View itemView) {
            super(itemView);
            myImages = itemView.findViewById(R.id.attachmentimg);
            t1 = itemView.findViewById(R.id.attachmentname);
            t2 = itemView.findViewById(R.id.attachmentinfo);
        }
    }
}
