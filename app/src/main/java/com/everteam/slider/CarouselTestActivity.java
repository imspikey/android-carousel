package com.everteam.slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;


public class CarouselTestActivity extends AppCompatActivity implements AdapterItemListener {

    List<CarouselItem> carouselItems;
    CarouseManager carouseManager;

    public  Uri resourceToUri( int resID) {
        return Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                getResources().getResourcePackageName(resID) + '/' +
                getResources().getResourceTypeName(resID) + '/' +
                getResources().getResourceEntryName(resID) );
    }


    void initItems(){
        carouselItems = new ArrayList<>();
        carouselItems.add(new CarouselItem(resourceToUri(R.drawable.ic_launcher_background)));
        carouselItems.add(new CarouselItem(resourceToUri(R.drawable.ic_launcher_background)));
        carouselItems.add(new CarouselItem(resourceToUri(R.drawable.ic_launcher_background)));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caroucel_test);

        initItems();

        carouseManager = new CarouseManager(this, (RecyclerView) findViewById(R.id.sliderRecycler), carouselItems);

        carouseManager.create();
;
    }

    @Override
    public void onItemClick() {

    }

    @Override
    public Context getActivity() {
        return this;
    }

    @Override
    public void onScrollEndReached() {

        carouseManager.showLoadingIndicator();

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                carouseManager.setmIsScrollListenerEnabled(false);
                final List<CarouselItem> carouselItemsToAdd = new ArrayList<>();
                for(int i = 0; i < 5; i++){
                    CarouselItem carouselItem = new CarouselItem(Uri.parse("https://picsum.photos/200/300?"+ UUID.randomUUID().toString()));

                    carouselItemsToAdd.add(carouselItem);
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        carouseManager.removeLoadingIndicator();
                        carouseManager.addItem(carouselItemsToAdd);
                        carouseManager.setmIsScrollListenerEnabled(true);
                    }
                });


            }
        },3000);

    }

}
