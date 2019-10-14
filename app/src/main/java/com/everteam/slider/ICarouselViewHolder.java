package com.everteam.slider;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ICarouselViewHolder extends RecyclerView.ViewHolder {



   public   ICarouselViewHolder(View itemView, AdapterItemListener listener){
          super(itemView);

    }

    abstract void onBind(ICarouselData iCarouselData);
}
