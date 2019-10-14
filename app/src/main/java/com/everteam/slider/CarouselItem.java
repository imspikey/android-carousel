package com.everteam.slider;


class CarouselItem extends ICarouselItem< CarouselViewHolder, CarouselData> {


    CarouselItem(int layout, Class<CarouselViewHolder> carouselViewHolder, CarouselData carouselData) {
        super(layout, carouselViewHolder, carouselData);
    }

    @Override
    public CarouselViewHolder getViewHolder() {
        return carouselViewHolder;
    }

    @Override
    public void setViewHolder(CarouselViewHolder v) {
        this.carouselViewHolder = v;
    }

    @Override
    public CarouselData getCarouselData() {
        return carouselData;
    }

    @Override
    public void setCarouselIData(CarouselData c) {
        this.carouselData = c;
    }
}
