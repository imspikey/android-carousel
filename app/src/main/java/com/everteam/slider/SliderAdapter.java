package com.everteam.slider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<CarouselViewHolder> {

    private AdapterItemListener mListener;
    private List<CarouselItem> mCarouselItems;

     SliderAdapter(List<CarouselItem> carouselItems, AdapterItemListener listner){
        this.mCarouselItems = carouselItems;
        this.mListener = listner;
    }

    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.caroucel_viewholder, parent ,false);

        return new CarouselViewHolder(view, mListener);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);


    }

    @Override
    public void onBindViewHolder(@NonNull CarouselViewHolder holder, int position) {
        holder.onBind(mCarouselItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mCarouselItems.size();
    }
}
