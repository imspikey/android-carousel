package com.everteam.slider;

import androidx.annotation.LayoutRes;

public abstract class ICarouselItem<VH extends ICarouselViewHolder,  CI extends ICarouselData>  {

    public   Class<VH> VHC;
    private @LayoutRes int mLayout;

    public VH carouselViewHolder;
    CI carouselData;

    ICarouselItem(int layout, Class<VH> carouselViewHolder, CI carouselData)  {
        this.mLayout = layout;
        this.carouselData = carouselData;

        VHC = carouselViewHolder;
    }

    abstract VH getViewHolder();
    abstract void setViewHolder( VH v);

    abstract  CI getCarouselData();
    abstract void setCarouselIData(CI c);


    public int getmLayout() {
        return mLayout;
    }

    public void setmLayout(int mLayout) {
        this.mLayout = mLayout;
    }
}
