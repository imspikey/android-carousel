package com.everteam.slider;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ICarouselViewHolder extends RecyclerView.ViewHolder {


    public ICarouselViewHolder(@NonNull View itemView, final AdapterItemListener listener){
          super(itemView);

    }


    abstract void onBind(ICarouselData iCarouselData);
}
