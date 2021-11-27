package com.sala.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class Adaptor extends RecyclerView.Adapter<Adaptor.carditem> {
    Context context;

    public Adaptor(Context context){
        this.context = context;
    }
    public static class carditem extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView imageView;

        public carditem(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public carditem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_card,parent,false); //inflate the layout
        //create the instance
        carditem ci = new carditem(view);
        return ci;

    }

    @Override
    public void onBindViewHolder(@NonNull carditem holder, int position) {
        Picasso.get().load("https://cataas.com/cat?width=500").networkPolicy(NetworkPolicy.NO_CACHE,NetworkPolicy.NO_STORE).memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

}
