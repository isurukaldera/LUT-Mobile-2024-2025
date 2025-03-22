package com.example.lutmobile2024_2025.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lutmobile2024_2025.Activity.DetailsActivity;
import com.example.lutmobile2024_2025.Model.ItemModel;
import com.example.lutmobile2024_2025.databinding.ViewholderPopularBinding;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.Viewholder> {
    ArrayList<ItemModel> items;
    Context context;
    ViewholderPopularBinding binding;

    public PopularAdapter(ArrayList<ItemModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PopularAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ViewholderPopularBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();
        return new Viewholder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.Viewholder holder, int position) {
        // Use holder.getAdapterPosition() instead of position
        int adapterPosition = holder.getAdapterPosition();

        // Ensure the position is valid
        if (adapterPosition == RecyclerView.NO_POSITION) {
            return;
        }

        // Bind data to views
        binding.titleTxt.setText(items.get(adapterPosition).getTitle());
        binding.priceTxt.setText("$" + items.get(adapterPosition).getPrice() + "/Night");
        binding.addressTxt.setText(items.get(adapterPosition).getAddress());
        binding.scoreTxt.setText("" + items.get(adapterPosition).getScore());

        Glide.with(context)
                .load(items.get(adapterPosition).getPic().get(0))
                .into(binding.pic);

        // Set click listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("object", items.get(adapterPosition));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(ViewholderPopularBinding binding) {
            super(binding.getRoot());
        }
    }

}