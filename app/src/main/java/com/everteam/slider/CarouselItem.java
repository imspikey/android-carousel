package com.everteam.slider;

import android.net.Uri;

import androidx.recyclerview.widget.RecyclerView;


class CarouselItem {

        private Uri mImageUri;
        private Boolean mIsLoadingIndicator = false;

        CarouselViewHolder carouselViewHolder;

        CarouselItem(Uri uri, Boolean isLoadingIndicator){
            this(uri);
            this.mIsLoadingIndicator = isLoadingIndicator;
        }

        CarouselItem(Uri uri ){
            this.mImageUri = uri;
        }

        Uri getImageUri() {
            return mImageUri;
        }

     void setImageUri(Uri mImageUri) {
            this.mImageUri = mImageUri;
     }

     public Boolean getIsloadingIndicator() {
         return mIsLoadingIndicator;
     }

     public void setIsloadingIndicator(Boolean mIsloadingIndicator) {
         this.mIsLoadingIndicator = mIsloadingIndicator;
     }
 }
