package com.everteam.slider;

import android.net.Uri;

public abstract class ICarouselData {
    private Uri mImageUri;
    private boolean mIsLoadingIndicator =  false;
    ICarouselData(Uri mImageUri,boolean mIsLoadingIndicator){
        this.mImageUri = mImageUri;
        this.mIsLoadingIndicator = mIsLoadingIndicator;
    }

    Uri getImageUri(){
        return  mImageUri;
    }

    void setImageUri(Uri uri){
        this.mImageUri = uri;
    }

   boolean getIsLoadingIndicator(){
        return mIsLoadingIndicator;
    }

    public void setIsLoadingIndicator(boolean mIsLoadingIndicator) {
        this.mIsLoadingIndicator = mIsLoadingIndicator;
    }
}
