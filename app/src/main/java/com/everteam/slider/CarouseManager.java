package com.everteam.slider;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarouseManager {

    private SliderAdapter mSliderAdapter;
    private RecyclerView mRecyclerView;
    private List<CarouselItem> mCarouselItems;
    private AdapterItemListener mListner;
    private boolean mIsScrollListenerEnabled = true;

    public CarouseManager(AdapterItemListener listener, RecyclerView recyclerView, List<CarouselItem> carouselItems){
         this.mListner = listener;
         this.mRecyclerView = recyclerView;
         this.mCarouselItems = carouselItems;
    }

    void create(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mListner.getActivity(), LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mSliderAdapter = new SliderAdapter(mCarouselItems, mListner);
        mRecyclerView.setAdapter(mSliderAdapter);

        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if(mIsScrollListenerEnabled)
                if(!recyclerView.canScrollHorizontally(1)){
                    mIsScrollListenerEnabled = false;
                    mListner.onScrollEndReached();
                }
            }
        });
     }

     void setmIsScrollListenerEnabled(Boolean enabled){
        this.mIsScrollListenerEnabled = enabled;
     }

     void setLoadingStatus(){

     }

     void addItem(List<CarouselItem> carouselItemItems){

        if(carouselItemItems.size() > 0) {
            mCarouselItems.addAll(carouselItemItems);

            mSliderAdapter.notifyItemRangeChanged(mCarouselItems.size() -  carouselItemItems.size() -1, carouselItemItems.size());

            mRecyclerView.scrollToPosition(mCarouselItems.size() -  carouselItemItems.size() );
        }
     }

     void showLoadingIndicator(){
         this.mCarouselItems.add(new CarouselItem(R.layout.caroucel_viewholder ,
                 CarouselViewHolder.class,
                 new CarouselData(null, true)));
         mSliderAdapter.notifyItemChanged(this.mCarouselItems.size() -1);

     }

     void removeLoadingIndicator(){

         this.mCarouselItems.remove(this.mCarouselItems.size()-1);
         mSliderAdapter.notifyItemRemoved(this.mCarouselItems.size()-1);
     }

     void hideLoadingIndicator(){

     }

     //todo: implement later if needed
     void remove(CarouselItem ...carouselItemItems){

     }

}
