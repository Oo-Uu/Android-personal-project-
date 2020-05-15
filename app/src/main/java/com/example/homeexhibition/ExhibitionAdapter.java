package com.example.homeexhibition;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ExhibitionAdapter extends RecyclerView.Adapter<ExhibitionAdapter.ExhibitionViewHolder> {
   private ArrayList<ExInfo>arrayList;
   private Context context;
   private View view;

    public ExhibitionAdapter(ArrayList<ExInfo> arrayList,Context context){
        this.arrayList=arrayList;
        this.context=context;
    }
    @Override
    public ExhibitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        ExhibitionViewHolder holder=new ExhibitionViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExhibitionViewHolder holder, int position) {
        Glide.with(holder.itemView).load(arrayList.get(position).getProfile()).into(holder.iv_profile);
        holder.tv_painter.setText(arrayList.get(position).getPainter());
        holder.tv_exhibitionname.setText(String.valueOf(arrayList.get(position).getExhibitionname()));

    }

    @Override
    public int getItemCount() {
        return (arrayList !=null ? arrayList.size():0);
    }

    public class ExhibitionViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        TextView tv_painter;
        TextView tv_exhibitionname;
        public ExhibitionViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile=itemView.findViewById(R.id.profile);
            this.tv_painter=itemView.findViewById(R.id.painter);
            this.tv_exhibitionname= itemView.findViewById(R.id.exhibitionname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=getAdapterPosition();
                    if(pos!=RecyclerView.NO_POSITION){
                        Intent intent= new Intent(context,Exhibition_van.class);
                        context.startActivity(intent);

                    }
                }
            });
        }


    }
}
