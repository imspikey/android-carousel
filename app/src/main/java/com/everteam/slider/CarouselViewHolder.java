package com.everteam.slider;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

public class CarouselViewHolder extends ICarouselViewHolder{

      private CarouselData mCarouselData;
      private ImageView mImgView;
      private AdapterItemListener mListener;


    public CarouselViewHolder(View itemView,  AdapterItemListener listener) {
        super(itemView,listener);

        this.mListener = listener;

        mImgView = itemView.findViewById(R.id.imgCarousel);

//        mImgView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onItemClick();
//            }
//        });
    }

    @Override
    void onBind(ICarouselData carouselData) {

        mCarouselData = (CarouselData)carouselData;

        if(carouselData.getIsLoadingIndicator())
        {
            mImgView.setVisibility(View.GONE);
        }
        else
        {
            mImgView.setVisibility(View.VISIBLE);
            Glide.with(mListener.getActivity()).load(carouselData.getImageUri()).into(mImgView);
        }
    }

}
