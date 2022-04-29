package com.example.screen_finding.cardinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.screen_finding.R;


public class ImageHolder extends RecyclerView.ViewHolder {

    ImageView ivRestaurant;

    public ImageHolder(@NonNull View itemView) {
        super(itemView);
        ivRestaurant = itemView.findViewById(R.id.iv_restaurant);
    }

    public static ImageHolder create(ViewGroup parent) {
        return new ImageHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));
    }
}
