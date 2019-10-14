package com.everteam.slider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<ICarouselViewHolder> {

    private AdapterItemListener mListener;
    private List<CarouselItem> mCarouselItems;

     SliderAdapter(List<CarouselItem> carouselItems, AdapterItemListener listner){
        this.mCarouselItems = carouselItems;
        this.mListener = listner;
    }

    @NonNull
    @Override
    public ICarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        CarouselItem carouselItem = mCarouselItems.get(viewType);

        View view = LayoutInflater.from(parent.getContext()).
                inflate(carouselItem.getmLayout(), parent ,false);

        try {
            String className =  carouselItem.VHC.getName();
            Class<?> c =   Class.forName(className);
            Constructor<?> cons = c.getConstructor(View.class, AdapterItemListener.class);
            Object v = cons.newInstance(view, mListener);

            return (CarouselViewHolder)v;

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return  null;
    }

    @Override
    public void onBindViewHolder(@NonNull ICarouselViewHolder holder, int position) {
        holder.onBind(mCarouselItems.get(position).getCarouselData());
    }


    @Override
    public int getItemViewType(int position) {
        super.getItemViewType(position);
        return position;
    }



    @Override
    public int getItemCount() {
        return mCarouselItems.size();
    }
}
