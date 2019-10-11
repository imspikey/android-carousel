package com.everteam.slider;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

class CarouselViewHolder extends RecyclerView.ViewHolder {

      private CarouselItem mCarouselItem;
      private ImageView mImgView;
      private AdapterItemListener mListener;

     CarouselViewHolder(@NonNull View itemView, final AdapterItemListener listener) {
        super(itemView);

        this.mListener = listener;
        mImgView = itemView.findViewById(R.id.imgCarousel);
        mImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick();
            }
        });
    }

     void onBind(CarouselItem carouselItem ) {

         mCarouselItem = carouselItem;
         if(mCarouselItem.getIsloadingIndicator())
         {
             mImgView.setVisibility(View.GONE);
         }
         else
         {
             mImgView.setVisibility(View.VISIBLE);
             Glide.with(mListener.getActivity()).load(mCarouselItem.getImageUri()).into(mImgView);
         }
     }
 }
